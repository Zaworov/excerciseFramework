package code4Schenker.ex1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Mailbox {
    int mailbox_size;
    private final LinkedList<String> mailQueue = new LinkedList<>();

    public Mailbox(int N) {
        mailbox_size = N;
    }

    public String pull() throws EmptyMailboxError {
        String firstMessage;
        try {
            firstMessage = mailQueue.peek();
            mailQueue.pop();
        } catch (NoSuchElementException emptyQueueException) {
            throw new EmptyMailboxError("No messages");
        }
        return firstMessage;
    }

    public void push(String message) throws FullQueueError {
        if (mailQueue.size() == mailbox_size) throw new FullQueueError("Queue full");
        mailQueue.addLast(message);
    }
}

class FullQueueError extends Exception {
    public FullQueueError(String message) {
        super(message);
    }
}

class EmptyMailboxError extends Exception {
    public EmptyMailboxError(String message) {
        super(message);
    }
}