package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class ThreadVsRunnableTask extends AbstractNamedTask {

    public ThreadVsRunnableTask() {
        super("Thread vs Runnable");
    }

    @Override
    public void run() {
        Runnable runnable = new MyRunnable();
        Thread thread = new T1Thread(runnable);
        thread.start();
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("➡ MyRunnable: running");
        }
    }

    private static class T1Thread extends Thread {
        public T1Thread(Runnable target) {
            super(target);
        }

        @Override
        public void run() {
            System.out.println("T1Thread: overriding run()");
        }
    }
}
