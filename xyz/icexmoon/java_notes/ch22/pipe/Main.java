package ch22.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CharacterWriter implements Runnable {
    private PipedWriter pipedWriter;

    public CharacterWriter(PipedWriter pipedWriter) {
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        char character = 'a';
        while (!Thread.interrupted()) {
            try {
                pipedWriter.append(character);
            } catch (IOException e) {
                System.out.println(e);
                break;
            }
            if (character == 'z') {
                break;
            }
            character++;
        }
    }

};

class CharacterReader implements Runnable {
    private PipedReader pipedReader;

    public CharacterReader(PipedReader pipedReader) {
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                char character = (char) pipedReader.read();
                System.out.print(character + " ");
                if(character == 'z'){
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
                break;
            }
        }
    }

};

public class Main {
    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader(pipedWriter);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new CharacterWriter(pipedWriter));
        es.execute(new CharacterReader(pipedReader));
        es.shutdown();
    }
}
// a b c d e f g h i j k l m n o p q r s t u v w x y z 