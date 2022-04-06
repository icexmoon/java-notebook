package ch18.serilize;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import util.MyMD5Util;

class Config implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        String md5 = MyMD5Util.encrypt(password);
        out.writeObject(md5);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        password = (String) in.readObject();
    }

}

public class Main {
    private static Config config;
    private static final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch18/serilize/";
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
            System.out.println("password:" + config.getPassword());
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
