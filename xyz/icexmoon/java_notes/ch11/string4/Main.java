package ch11.string4;

public class Main {

    public static void main(String[] args) {
        String str = "-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:8662";
        String str2 = str.replaceAll("\\w+=\\w+", "key=value");
        System.out.println(str2);
        String str3 = str.replaceFirst("\\w+=\\w+", "key=value");
        System.out.println(str3);
    }
}
// -agentlib:key=value=dt_socket,key=value,key=value,key=value:8662
// -agentlib:key=value=dt_socket,server=n,suspend=y,address=localhost:8662