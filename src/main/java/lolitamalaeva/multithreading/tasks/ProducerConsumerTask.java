package lolitamalaeva.multithreading.tasks;

import lolitamalaeva.multithreading.base.AbstractNamedTask;
import lolitamalaeva.multithreading.config.ProducerConsumerConfig;
import lolitamalaeva.multithreading.model.SharedFlag;

public class ProducerConsumerTask extends AbstractNamedTask {

    public ProducerConsumerTask() {
        super("Producer/Consumer Task");
    }

    @Override
    public void run() {
        SharedFlag flag = new SharedFlag();
        Thread producer = new Thread(new FlagProducer(flag), "Producer");
        Thread consumer = new Thread(new CountdownConsumer(flag), "Consumer");

        producer.start();
        consumer.start();
    }

    private static class FlagProducer implements Runnable {
        private final SharedFlag flag;

        public FlagProducer(SharedFlag flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            while (!flag.isStopped()) {
                flag.toggle();
                System.out.println("Producer toggled flag to: " + flag.isActive());
                sleep(ProducerConsumerConfig.TOGGLE_DELAY_MS);
            }
        }

        private void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException ignored) {}
        }
    }

    private static class CountdownConsumer implements Runnable {
        private final SharedFlag flag;

        public CountdownConsumer(SharedFlag flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            int countdown = ProducerConsumerConfig.COUNTDOWN_START_MS;

            while (countdown > 0) {
                if (flag.isActive()) {
                    System.out.println("Countdown: " + countdown + " ms");
                    countdown -= ProducerConsumerConfig.STEP_DELAY_MS;
                    sleep(ProducerConsumerConfig.STEP_DELAY_MS);
                } else {
                    sleep(50); // wait untill flag is on
                }
            }

            System.out.println("Countdown complete. Consumer requests stop.");
            flag.stop();
        }

        private void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException ignored) {}
        }
    }
}
