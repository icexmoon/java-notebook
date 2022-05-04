package ch24.read_write_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Student {
}

class ClassRoom {
    private List<Student> students = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ClassRoom(int studentNum) {
        for (int i = 0; i < studentNum; i++) {
            students.add(new Student());
        }
    }

    public int getStudentsNum() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return students.size();
        } finally {
            readLock.unlock();
        }
    }

    public Student getStudent(int index) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return students.get(index);
        } finally {
            readLock.unlock();
        }
    }

    public void SetStudent(int index, Student s) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        students.set(index, s);
        writeLock.unlock();
    }
}

class ReadTask implements Runnable {
    private ClassRoom cr;
    private static Random rand = new Random();

    public ReadTask(ClassRoom cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500) + 500);
                Student s = cr.getStudent(rand.nextInt(cr.getStudentsNum()));
                System.out.println(s + " is geted.");
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }
}

class SetTask implements Runnable {
    private ClassRoom cr;
    private static Random rand = new Random();

    public SetTask(ClassRoom cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500) + 500);
                int index = rand.nextInt(cr.getStudentsNum());
                cr.SetStudent(index, new Student());
                System.out.println("student in " + index + " is seted.");
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        ClassRoom cr = new ClassRoom(10);
        for(int i=0;i<10;i++){
            es.execute(new ReadTask(cr));
        }
        es.execute(new SetTask(cr));
        es.awaitTermination(3, TimeUnit.SECONDS);
        es.shutdownNow();
    }
}
