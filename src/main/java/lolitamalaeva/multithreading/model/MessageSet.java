package lolitamalaeva.multithreading.model;

import java.util.List;

public class MessageSet {
    private final String threadName;
    private final List<String> messages;

    public MessageSet(String threadName, List<String> messages) {
        this.threadName = threadName;
        this.messages = messages;
    }

    public String getThreadName() {
        return threadName;
    }

    public List<String> getMessages() {
        return messages;
    }
}