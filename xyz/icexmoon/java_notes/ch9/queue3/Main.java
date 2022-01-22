package ch9.queue3;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

enum MsgPriority {
    HIGH, MIDDLE, LOW;

    public static int compare(MsgPriority o1, MsgPriority o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1 == HIGH) {
            return 1;
        } else if (o2 == HIGH) {
            return -1;
        } else if (o1 == MIDDLE) {
            return 1;
        } else if (o2 == MIDDLE) {
            return -1;
        } else {
            ;
        }
        return 0;
    }
}

class Message implements Comparable<Message> {
    private String msg;
    private MsgPriority priority;

    public Message(String msg, MsgPriority priority) {
        this.msg = msg;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return msg;
    }

    @Override
    public int compareTo(Message o) {
        return MsgPriority.compare(this.priority, o.priority);
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Message> msgs = new PriorityQueue<>(Collections.reverseOrder());
        msgs.offer(new Message("hello", MsgPriority.LOW));
        msgs.offer(new Message("world", MsgPriority.MIDDLE));
        msgs.offer(new Message("How are you.", MsgPriority.HIGH));
        msgs.offer(new Message("middle msg", MsgPriority.MIDDLE));
        do {
            try {
                Message msg = msgs.remove();
                System.out.println(msg);
            } catch (NoSuchElementException e) {
                break;
            }
        } while (true);
        // How are you.
        // middle msg
        // world
        // hello
    }
}
