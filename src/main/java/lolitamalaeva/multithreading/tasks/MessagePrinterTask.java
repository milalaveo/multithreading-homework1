package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;
import lolitamalaeva.multithreading.model.MessageSet;

import java.util.List;

public class MessagePrinterTask extends AbstractNamedTask {

    public MessagePrinterTask() {
        super("Multi-threaded Message Printer (OOP version)");
    }

    @Override
    public void run() {
        List<MessageSet> allMessages = List.of(
                new MessageSet("Thread-1", List.of("Wake", "up,", "check", "code,", "forget", "coffee")),
                new MessageSet("Thread-2", List.of("Another", "thread,", "another", "existential", "crisis")),
                new MessageSet("Thread-3", List.of("Compile,", "run,", "debug,", "breathe,", "repeat")),
                new MessageSet("Thread-4", List.of("Why", "does", "the", "cat", "understand", "me", "better?")),
                new MessageSet("Thread-5", List.of("Living", "in", "parallel,", "like", "my", "threads")),
                new MessageSet("Thread-6", List.of("Hope", "this", "doesn’t", "crash", "like", "my", "plans"))
        );

        for (MessageSet messageSet : allMessages) {
            Thread thread = new Thread(new MessagePrinterRunnable(messageSet));
            thread.start();
        }
    }

    private static class MessagePrinterRunnable implements Runnable {
        private final MessageSet messageSet;

        public MessagePrinterRunnable(MessageSet messageSet) {
            this.messageSet = messageSet;
        }

        @Override
        public void run() {
            for (String msg : messageSet.getMessages()) {
                System.out.printf("%s: %s%n", messageSet.getThreadName(), msg);
            }
        }
    }
}
