package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;
import lolitamalaeva.multithreading.model.SharedCounter;

public class SynchronizedCounterTask extends AbstractNamedTask {

    private static final int THREADS = 10;
    private static final int INCREMENTS_PER_THREAD = 1_000;

    public SynchronizedCounterTask() {
        super("Synchronized Counter Task");
    }

    @Override
    public void run() {
        SharedCounter counter = new SharedCounter();
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Join interrupted");
            }
        }

        System.out.println("Expected count: " + (THREADS * INCREMENTS_PER_THREAD));
        System.out.println("Actual count: " + counter.get());
    }
}

