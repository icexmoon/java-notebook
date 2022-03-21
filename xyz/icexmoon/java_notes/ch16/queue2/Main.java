package ch16.queue2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import ch16.queue2.Message.Priority;
import util.Fmt;

class Message implements Comparable<Message> {
    public static enum Priority {
        LOW, MEDIUM, HIGH;
    }

    private String msg = "";
    private Priority priorityFirst;
    private Priority prioritySecond;

    public Message(String msg, Priority priorityFirst, Priority prioritySecond) {
        this.msg = msg;
        this.priorityFirst = priorityFirst;
        this.prioritySecond = prioritySecond;
    }

    public Message(String msg, Priority priorityFirst) {
        this(msg, priorityFirst, Priority.LOW);
    }

    public Message(String msg) {
        this(msg, Priority.LOW);
    }

    @Override
    public int compareTo(Message o) {
        int pfCompare = this.priorityFirst.compareTo(o.priorityFirst);
        if (pfCompare > 0) {
            return 1;
        } else if (pfCompare < 0) {
            return -1;
        } else {
            int psCompare = this.prioritySecond.compareTo(o.prioritySecond);
            if (psCompare > 0) {
                return 1;
            } else if (psCompare < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Msg(%s,%s,%s)", msg, priorityFirst, prioritySecond);
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Message> msgs = new PriorityQueue<>(Collections.reverseOrder());
        msgs.add(new Message("hello"));
        msgs.add(new Message("world", Priority.MEDIUM));
        msgs.add(new Message("How", Priority.HIGH));
        msgs.add(new Message("are", Priority.HIGH, Priority.HIGH));
        msgs.add(new Message("you", Priority.LOW, Priority.HIGH));
        while (msgs.peek() != null) {
            Message msg = msgs.remove();
            System.out.print(msg + " ");
        }
        System.out.println();
    }
}
// Msg(are,HIGH,HIGH) Msg(How,HIGH,LOW) Msg(world,MEDIUM,LOW) Msg(you,LOW,HIGH)
// Msg(hello,LOW,LOW)
