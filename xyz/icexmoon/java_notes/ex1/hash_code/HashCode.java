package ex1.hash_code;

public class HashCode {
    public static int hash(boolean b) {
        return b ? 0 : 1;
    }

    public static int hash(byte b) {
        return (int) b;
    }

    public static int hash(char c) {
        return (int) c;
    }

    public static int hash(int i) {
        return i;
    }

    public static int hash(short s) {
        return (int) s;
    }

    public static int hash(long l) {
        return (int) (l ^ (l >>> 32));
    }

    public static int hash(float f) {
        return Float.floatToIntBits(f);
    }

    public static int hash(double d) {
        long I = Double.doubleToLongBits(d);
        return (int) (I ^ (I >>> 32));
    }

    public static int hash(Object obj) {
        return obj.hashCode();
    }

    public static void main(String[] args) {
        System.out.println(hash(11));
        System.out.println(hash(2.5));
        System.out.println(hash('a'));
    }
}
// 11
// 1074003968
// 97