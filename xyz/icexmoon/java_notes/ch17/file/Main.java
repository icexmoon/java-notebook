package ch17.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(".");
        String[] paths = file.list();
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
// .git
// .gitignore
// .vscode
// ch0
// exception.log
// exp.log
// LICENSE
// README.md
// test.txt
// xyz
