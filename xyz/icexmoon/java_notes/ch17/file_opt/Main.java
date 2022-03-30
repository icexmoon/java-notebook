package ch17.file_opt;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("File operation help:");
            System.out.println("command options [files]");
            System.out.println("options:");
            System.out.println("-l [regex] print current directorie's files.");
            System.out.println("-d file1 [file2 file3 ...] delete files.");
            System.out.println("-r old_name new_name renmae file.");
        } else if (args.length == 1 && args[0].equals("-l")) {
            printFiles(".*");
        } else if (args.length == 2 && args[0].equals("-l")) {
            printFiles(args[1]);
        } else if (args.length >= 2 && args[0].equals("-d")) {
            String[] fileNames = Arrays.copyOfRange(args, 1, args.length);
            removeFile(fileNames);
        } else if (args.length == 3 && args[0].equals("-r")) {
            rename(args[1], args[2]);
        }
    }

    private static void printFiles(final String regex) {
        File file = new File(".");
        int counter = 0;
        FilenameFilter ff = new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                if (pattern.matcher(name).matches()) {
                    return true;
                }
                return false;
            }

        };
        for (File subFile : file.listFiles(ff)) {
            if (subFile.isFile()) {
                System.out.println(subFile.getName());
                counter++;
            }
        }
        Fmt.printf("total %d files.\n", counter);
    }

    private static void removeFile(String... fileNames) {
        int success = 0;
        int fail = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.delete()) {
                Fmt.printf("The file %s is deleted.", fileName);
                success++;
            } else {
                fail++;
            }
        }
        Fmt.printf("delete operation is done, %d success, %d fail.", success, fail);
    }

    private static void rename(String oldName, String newName) {
        File file = new File(oldName);
        if(file.renameTo(new File(newName))){
            Fmt.printf("The file %s is renamed to %s.", oldName, newName);
        }
        else{
            System.out.println("rename operation is failed.");
        }
    }

}
