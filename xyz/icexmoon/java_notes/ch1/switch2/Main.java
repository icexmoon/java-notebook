package ch1.switch2;

public class Main {
    public static String callBack(String call) {
        switch (call.toLowerCase()) {
            case "hello":
                return "hello";
            case "bye":
                return "bye";
            default:
                return "I don't know";
        }
    }

    public static void main(String[] args) {
        String call = "hello";
        System.out.println("call:"+call+" back:"+callBack(call));
        call = "Bye";
        System.out.println("call:"+call+" back:"+callBack(call));
        call = "world";
        System.out.println("call:"+call+" back:"+callBack(call));
    }
}
// call:hello back:hello
// call:Bye back:bye
// call:world back:I don't know