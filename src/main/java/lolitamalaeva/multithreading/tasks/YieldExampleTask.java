package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class YieldExampleTask extends AbstractNamedTask {

    public YieldExampleTask() {
        super("Yield Example Task");
    }

    @Override
    public void run() {
        Thread yieldingThread = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Yielding thread: " + i);
                Thread.yield();
            }
        });

        Thread regularThread = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Regular thread: " + i);
            }
        });

        yieldingThread.start();
        regularThread.start();
    }
}
