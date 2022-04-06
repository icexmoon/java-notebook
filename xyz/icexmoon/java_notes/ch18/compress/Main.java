package ch18.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final String CURRENT_DIR = "./xyz/icexmoon/java_notes/ch18/compress/";
        final String SOURCE_FILE = CURRENT_DIR + "Main.java";
        final String COMPRESSED_FILE = CURRENT_DIR + "Main.gz";
        final String UNCOMPRESSED_FILE = CURRENT_DIR + "Main.txt";
        compress(SOURCE_FILE, COMPRESSED_FILE);
        uncompress(COMPRESSED_FILE, UNCOMPRESSED_FILE);
    }

    /**
     * 将指定文件压缩为目标文件
     * 
     * @param sourceFile 源文件
     * @param desFile    压缩后的文件
     * @throws FileNotFoundException
     */
    private static void compress(String sourceFile, String desFile) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(sourceFile));
        GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(desFile));
        BufferedOutputStream bos = new BufferedOutputStream(gos);
        try {
            do {
                int b = bi.read();
                if (b == -1) {
                    break;
                }
                bos.write(b);
            } while (true);
        } finally {
            bi.close();
            bos.close();
        }
    }

    /**
     * 将指定文件解压缩为目标文件
     * 
     * @param sourceFile 源文件
     * @param desFile    解压后的文件
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void uncompress(String sourceFile, String desFile) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(new GZIPInputStream(new FileInputStream(sourceFile)));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(desFile));
        try {
            do {
                int b = bi.read();
                if (b == -1) {
                    break;
                }
                bo.write(b);
            } while (true);
        } finally {
            bi.close();
            bo.close();
        }
    }
}
