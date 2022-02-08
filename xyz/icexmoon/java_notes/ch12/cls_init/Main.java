package ch12.cls_init;

import java.util.Random;

class MyCls1 {
    static final int num = 47;
    static {
        System.out.println("MyCls1 is inited.");
    }
}

class MyCls2 {
    static final int num = (new Random()).nextInt(100);
    static {
        System.out.println("MyCls2 is inited.");
    }
}

class MyCls3 {
    public final int num = 47;
    static {
        System.out.println("MyCls3 is inited.");
    }
}

public class Main {
    public static void main(String[] args) {
        Class MyCls1Class = MyCls1.class;
        Class MyCls2Class = MyCls2.class;
        Class MyCls3Class = MyCls3.class;
        System.out.println("class ref is geted.");
        System.out.println("access MyCls1's member.");
        System.out.println(MyCls1.num);
        System.out.println("access MyCls2's member.");
        System.out.println(MyCls2.num);
        System.out.println("access MyCls3's member.");
        MyCls3 mc = new MyCls3();
        System.out.println(mc.num);
    }
}
// class ref is geted.
// access MyCls1's member.
// 47
// access MyCls2's member.
// MyCls2 is inited.
// 56
// access MyCls3's member.
// MyCls3 is inited.
// 47
