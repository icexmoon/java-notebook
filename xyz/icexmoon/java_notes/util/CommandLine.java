package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandLine {
    public static void exec(String command) {
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            InputStream processOut = process.getInputStream();
            InputStream processErr = process.getErrorStream();
            BufferedReader outBr = new BufferedReader(new InputStreamReader(processOut));
            BufferedReader errBr = new BufferedReader(new InputStreamReader(processErr));
            System.out.println("execute result:");
            do {
                String line = outBr.readLine();
                if (null == line) {
                    break;
                }
                System.out.println(line);
            } while (true);
            boolean hasErr = false;
            System.out.println("execute error:");
            do {
                String line = errBr.readLine();
                if (line == null) {
                    break;
                }
                hasErr = true;
                System.err.println(line);
            } while (true);
            if (hasErr) {
                throw new ExecuteException(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class ExecuteException extends RuntimeException {
        public ExecuteException(String command) {
            super(command);
        }
    }

    public static void main(String[] args) {
        exec("java --version");
    }
}
