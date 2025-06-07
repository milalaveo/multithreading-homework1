package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;

public class PriorityExampleTask extends AbstractNamedTask {

    public PriorityExampleTask() {
        super("Priority Example Task");
    }

    @Override
    public void run() {
        Runnable walker = () -> {
            for (int i = 1; i <= 30; i++) {
                System.out.println("Slow walker: step " + i);
            }
        };

        Runnable talker = () -> {
            for (int i = 1; i <= 30; i++) {
                System.out.println("Fast talker: step " + i);
            }
        };

        Thread walkMin = new Thread(walker, "Min");
        Thread talkMax = new Thread(talker, "Max");

        walkMin.setPriority(Thread.MIN_PRIORITY); // 1
        talkMax.setPriority(Thread.MAX_PRIORITY); // 10

        // Run in different order
        talkMax.start();
        walkMin.start();
    }
}
