package ch19.chain;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.Fmt;

class MyFile {
    private String path;

    public MyFile(String path) {
        this.path = path;
    }

    public String getExt() {
        return path.substring(path.lastIndexOf(".") + 1, path.length());
    }
}

interface Classifyable {
    boolean classify(MyFile mf, Set<FileClassify> classifies);
}

class ClassifyManager implements Classifyable {

    @Override
    public boolean classify(MyFile mf, Set<FileClassify> classifies) {
        for (FileClassify fileClassify : FileClassify.values()) {
            if (fileClassify.classify(mf, classifies)) {
                return true;
            }
        }
        return false;
    }

}

enum FileClassify implements Classifyable {
    VEDIO {
        @Override
        public boolean classify(MyFile mf, Set<FileClassify> classifies) {
            Set<String> exts = new HashSet<>();
            exts.addAll(Arrays.asList("mkv", "mp4"));
            if (exts.contains(mf.getExt())) {
                classifies.add(this);
                return true;
            }
            return false;
        }
    },
    PICTURE {
        @Override
        public boolean classify(MyFile mf, Set<FileClassify> classifies) {
            Set<String> exts = new HashSet<>();
            exts.addAll(Arrays.asList("jpg", "jpeg", "png"));
            if (exts.contains(mf.getExt())) {
                classifies.add(this);
                return true;
            }
            return false;
        }
    },
    MUSIC {
        @Override
        public boolean classify(MyFile mf, Set<FileClassify> classifies) {
            Set<String> exts = new HashSet<>();
            exts.addAll(Arrays.asList("mp3"));
            if (exts.contains(mf.getExt())) {
                classifies.add(this);
                return true;
            }
            return false;
        }
    },
    OTHER {
        @Override
        public boolean classify(MyFile mf, Set<FileClassify> classifies) {
            classifies.add(this);
            return true;
        }
    };

    @Override
    public abstract boolean classify(MyFile mf, Set<FileClassify> classifies);
}

public class Main {
    public static void main(String[] args) {
        File root = new File("F:\\download");
        ClassifyManager cm = new ClassifyManager();
        for (File file : root.listFiles()) {
            if (file.isFile()) {
                MyFile mf = new MyFile(file.getAbsolutePath());
                Set<FileClassify> classifies = new HashSet<>();
                if (cm.classify(mf, classifies)) {
                    Fmt.printf("file %s classifies:%s\n", file.getName(), classifies.toString());
                }
            }
        }
    }
}
