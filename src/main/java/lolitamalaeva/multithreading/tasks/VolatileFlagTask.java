package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class VolatileFlagTask extends AbstractNamedTask {

    public VolatileFlagTask() {
        super("Volatile Flag Task");
    }

    @Override
    public void run() {
        Worker worker = new Worker();
        Thread workerThread = new Thread(worker, "VolatileWorker");
        workerThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Stopping worker...");
        worker.stop(); // CHANGE FLAG
    }

    private static class Worker implements Runnable {
        private volatile boolean running = true; // volatile make sure that thread will see actual data

        public void stop() {
            running = false;
        }

        @Override
        public void run() {
            System.out.println("Worker started.");
            while (running) {
                System.out.println("Working...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted during work.");
                }
            }
            System.out.println("Worker stopped.");
        }
    }
}

