package ch18.serilize2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Config implements Serializable {
    private String name;
    private String password;

    public Config() {
        System.out.println("Config's constructor is called.");
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class Main {
    private static Config config;
    private static final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch18/serilize2/";
    private static final String SAVED_FILE = CURRENT_DIR + "config.out";

    public static void main(String[] args) {
        try {
            loadConfig();
            checkLogin();
            saveConfig();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void checkLogin() throws IOException {
        String name = config.getName();
        if (name != null && name.length() != 0) {
            System.out.println("Hello, " + name);
        } else {
            System.out.println("please login.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("enter your name:");
            String nameInput = br.readLine();
            System.out.print("enter your password:");
            String pwdInput = br.readLine();
            config.setName(nameInput);
            config.setPassword(pwdInput);
        }
    }

    private static void loadConfig() throws IOException, ClassNotFoundException {
        File file = new File(SAVED_FILE);
        if (file.exists() && file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                config = (Config) ois.readObject();
            } finally {
                ois.close();
            }
        } else {
            config = new Config();
        }
    }

    private static void saveConfig() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(SAVED_FILE)));
        oos.writeObject(config);
        oos.close();
    }
}
