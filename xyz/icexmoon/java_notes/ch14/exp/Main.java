package ch14.exp;

import java.lang.reflect.Array;
import java.util.Arrays;

interface ArrayCreator<T, E extends Exception> {
    T[] creat(Class<T> cls, int num) throws E;
}

class ParamError extends Exception {
}

class StrArrayCreator implements ArrayCreator<String, ParamError> {

    @Override
    public String[] creat(Class<String> cls, int num) throws ParamError {
        if (num <= 0) {
            throw new ParamError();
        }
        return (String[]) Array.newInstance(cls, num);
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayCreator<String, ParamError> ac = new StrArrayCreator();
        try {
            String[] arr = ac.creat(String.class, 10);
            System.out.println(Arrays.toString(arr));
            arr = ac.creat(String.class, 0);
            System.out.println(Arrays.toString(arr));
        } catch (ParamError e) {
            e.printStackTrace();
        }

    }
}
// [null, null, null, null, null, null, null, null, null, null]
// ch14.exp.ParamError
// at ch14.exp.StrArrayCreator.creat(Main.java:18)
// at ch14.exp.StrArrayCreator.creat(Main.java:1)
// at ch14.exp.Main.main(Main.java:31)
