package ch12.reflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length <= 0) {
            System.out.println("Please enter params:[class_name <key_word>]");
        }
        String ClsName = args[0];
        String KeyWord = "";
        if (args.length >= 2) {
            KeyWord = args[1];
        }
        Class<?> cls = Class.forName(ClsName);
        Constructor[] constructors = cls.getConstructors();
        Pattern prefixPattern = Pattern.compile("\\w+\\.");
        for (Constructor constructor : constructors) {
            String funcSig = constructor.toString();
            funcSig = prefixPattern.matcher(funcSig).replaceAll("");
            if (KeyWord.length() == 0) {
                System.out.println(funcSig);
            } else if (funcSig.indexOf(KeyWord) != -1) {
                System.out.println(funcSig);
            } else {
                ;
            }
        }
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            String funcSig = method.toString();
            funcSig = prefixPattern.matcher(funcSig).replaceAll("");
            if (KeyWord.length() == 0) {
                System.out.println(funcSig);
            } else if (funcSig.indexOf(KeyWord) != -1) {
                System.out.println(funcSig);
            } else {
                ;
            }
        }
    }
}

class Test {
    public Test() {
    }

    public Test(int num) {
    }

    public void publicMethod() {
    };

    public static void publicStaticMethod() {
    }

    private void privateMethod() {
    };

    private static void privateStaticMethod() {
    }
}