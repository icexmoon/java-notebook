package ch23.semaphore;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import util.Fmt;

class ObjectPool<T> {
    private int size;
    private List<T> objs;
    private Semaphore smp;
    @SuppressWarnings("unused")
    private Class<T> cls;
    private boolean[] used;

    public ObjectPool(int size, Class<T> cls) {
        this.size = size;
        this.cls = cls;
        objs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            T obj;
            try {
                obj = cls.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(e);
            }
            objs.add(obj);
        }
        smp = new Semaphore(size);
        used = new boolean[size];
        for (int i = 0; i < size; i++) {
            used[i] = false;
        }
    }

    public T out() throws InterruptedException {
        smp.acquire();
        T obj = get();
        if (obj == null) {
            smp.release();
        }
        return obj;
    }

    public void in(T obj) {
        if (back(obj)) {
            smp.release();
        }
    }

    private synchronized T get() {
        for (int i = 0; i < size; i++) {
            if (!used[i]) {
                used[i] = true;
                return objs.get(i);
            }
        }
        return null;
    }

    private synchronized boolean back(T obj) {
        int index = objs.indexOf(obj);
        if (index < 0) {
            return false;
        }
        if (!used[index]) {
            return false;
        }
        used[index] = false;
        return true;
    }
}

class Student {
    private static int counter = 0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return Fmt.sprintf("Student#%d", id);
    }
}

class OutTask<T> implements Runnable {
    private ObjectPool<T> pool;

    public OutTask(ObjectPool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T obj = pool.out();
            System.out.println(obj + " is get.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 5;
        ObjectPool<Student> pool = new ObjectPool<>(SIZE, Student.class);
        Student s = pool.out();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            es.execute(new OutTask<Student>(pool));
        }
        TimeUnit.SECONDS.sleep(2);
        pool.in(s);
        es.shutdown();
    }
}
// Student#2 is get.
// Student#5 is get.
// Student#3 is get.
// Student#4 is get.
// Student#1 is get.