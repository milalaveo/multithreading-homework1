package lolitamalaeva.multithreading.tasks;
import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class BasicThreadTask extends AbstractNamedTask {

    private static final int LINES_TO_PRINT = 5;

    public BasicThreadTask() {
        super("Basic Thread Task");
    }

    @Override
    public void run() {
        Thread childThread = new Thread(() -> {
            printLines("Child thread");
        });

        childThread.start();

        printLines("Main thread");
    }

    private void printLines(String threadName) {
        for (int i = 1; i <= LINES_TO_PRINT; i++) {
            System.out.printf("%s: строка %d%n", threadName, i);
        }
    }
}
