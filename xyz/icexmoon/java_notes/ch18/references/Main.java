package ch18.references;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

class Config {
    private String name;
    private transient String password;

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
    private static Preferences preferences = Preferences.userNodeForPackage(Main.class);

    public static void main(String[] args) {
        loadConfig();
        try {
            checkLogin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveConfig();
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

    private static void loadConfig() {
        String name = preferences.get("config.name", null);
        if (name != null && name.length() != 0) {
            config = new Config();
            config.setName(name);
            config.setPassword(preferences.get("config.pwd", ""));
        } else {
            config = new Config();
        }
    }

    private static void saveConfig() {
        preferences.put("config.name", config.getName());
        preferences.put("config.pwd", config.getPassword());
    }
}
