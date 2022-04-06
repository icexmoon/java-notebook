package ch18.compress2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch18/compress2/test/";
        String[] files = new String[] { "./LICENSE", "./README.md", "./.gitignore" };
        String compressedFile = CURRENT_DIR + "files.zip";
        compress(files, compressedFile);
        uncompress(compressedFile, CURRENT_DIR);
    }

    private static void compress(String[] files, String compressedFile) throws IOException {
        if (files.length == 0) {
            return;
        }
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(compressedFile), new Adler32());
        ZipOutputStream zos = new ZipOutputStream(cos);
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        zos.setComment("A compressed file.");
        try {
            for (String file : files) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                try {
                    zos.putNextEntry(new ZipEntry(file));
                    do {
                        int b = bis.read();
                        if (b == -1) {
                            break;
                        }
                        bos.write(b);
                    } while (true);
                    bos.flush();
                } finally {
                    bis.close();
                }
            }
            System.out.println("checksum:" + cos.getChecksum().getValue());
        } finally {
            bos.close();
        }
    }

    private static void uncompress(String compressedFile, String desDir) throws IOException {
        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(compressedFile), new Adler32());
        ZipInputStream zis = new ZipInputStream(cis);
        BufferedInputStream bis = new BufferedInputStream(zis);
        try {
            do {
                ZipEntry entry = zis.getNextEntry();
                if (entry == null) {
                    break;
                }
                String fileName = desDir + entry.getName();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
                try {
                    do {
                        int b = bis.read();
                        if (b == -1) {
                            break;
                        }
                        bos.write(b);
                    } while (true);
                } finally {
                    bos.close();
                }
            } while (true);
            System.out.println("checksum:" + cis.getChecksum().getValue());
        } finally {
            bis.close();
        }
    }
}
