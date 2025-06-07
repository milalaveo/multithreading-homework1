package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class JoinThreadTask extends AbstractNamedTask {

    private static final int LINES_TO_PRINT = 5;

    public JoinThreadTask() {
        super("Join Thread Task");
    }

    @Override
    public void run() {
        Thread childThread = new Thread(() -> {
            printLines("Child thread");
        });

        childThread.start();

        try {
            childThread.join(); // waiting for child
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting.");
        }

        printLines("Main thread");
    }

    private void printLines(String label) {
        for (int i = 1; i <= LINES_TO_PRINT; i++) {
            System.out.printf("%s: строка %d%n", label, i);
        }
    }
}
