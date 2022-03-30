package ch17.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

class Directory implements Iterable<File> {
    private List<File> files = new LinkedList<>();
    private List<Directory> dirs = new LinkedList<>();
    private File root;
    private int deep = 0;
    private String regex;
    private static String DEFAULT_REGEX = ".*";

    public Directory(String path) {
        this(path, DEFAULT_REGEX);
    }

    public Directory(File path) {
        this(path, DEFAULT_REGEX);
    }

    public Directory(String path, String regex) {
        root = new File(path);
        this.regex = regex;
        init();
    }

    public Directory(File path, String regex) {
        root = path;
        this.regex = regex;
        init();
    }

    private void init() {
        FilenameFilter ff = new FilenameFilter() {
            Pattern p = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                String currentFileStr = dir.getAbsolutePath() + "\\" + name;
                File currentFile = new File(currentFileStr);
                if (currentFile.isDirectory()) {
                    return true;
                }
                return p.matcher(name).matches();
            }

        };
        for (File file : root.listFiles(ff)) {
            if (file.isFile()) {
                files.add(file);
            } else {
                Directory subDir = new Directory(file, regex);
                subDir.deep = deep + 1;
                dirs.add(subDir);
            }
        }
    }

    private void addPrefix(StringBuffer sb) {
        for (int i = 0; i < deep; i++) {
            sb.append("\t");
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        addPrefix(sb);
        sb.append(root.getName());
        sb.append("\n");
        for (File file : files) {
            addPrefix(sb);
            sb.append("|-------");
            sb.append(file.getName());
            sb.append("\n");
        }
        for (Directory dir : dirs) {
            sb.append(dir.toString());
        }
        return sb.toString();
    }

    @Override
    public Iterator<File> iterator() {
        return new Iterator<File>() {
            private Iterator<File> filesIterator = files.iterator();
            private int dirIndex = 0;

            @Override
            public boolean hasNext() {
                if (filesIterator.hasNext()) {
                    return true;
                } else {
                    if (dirIndex >= dirs.size()) {
                        return false;
                    }
                    filesIterator = dirs.get(dirIndex++).iterator();
                    return hasNext();
                }
            }

            @Override
            public File next() {
                File file;
                try {
                    file = filesIterator.next();
                } catch (NoSuchElementException e) {
                    if (dirIndex >= dirs.size()) {
                        return null;
                    }
                    filesIterator = dirs.get(dirIndex++).iterator();
                    return next();
                }
                return file;
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        Directory dir = new Directory("D:\\workspace\\java\\java-notebook\\ch0", ".*\\.java");
        System.out.println(dir);
        for (File file : dir) {
            System.out.println(file);
        }
    }
}
