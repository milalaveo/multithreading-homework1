package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class InterruptibleTask extends AbstractNamedTask {

    public InterruptibleTask() {
        super("Interruptible Task");
    }

    @Override
    public void run() {
        Thread deepThinker = new Thread(new DeepThinkingRunnable(), "DeepThinker");
        deepThinker.start();

        try {
            // sleep for 1.5s
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while sleeping.");
        }

        System.out.println("Main thread is interrupting DeepThinker...");
        deepThinker.interrupt();
    }

    private static class DeepThinkingRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Thinking deeply...");

            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("Still thinking... " + i + "s");
                }
                System.out.println("Thought complete.");
            } catch (InterruptedException e) {
                System.out.println("Interrupted while thinking. Existential panic.");
            }
        }
    }
}
