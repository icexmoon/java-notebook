package ch11.string3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str="-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:8662";
        String[] result = str.split("(,|=|:)");
        System.out.println(Arrays.toString(result));
        result = str.split("[,=:]");
        System.out.println(Arrays.toString(result));
    }
}
// [-agentlib, jdwp, transport, dt_socket, server, n, suspend, y, address, localhost, 8662]
// [-agentlib, jdwp, transport, dt_socket, server, n, suspend, y, address, localhost, 8662]