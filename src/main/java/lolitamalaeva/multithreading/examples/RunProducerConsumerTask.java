package lolitamalaeva.multithreading.examples;

import lolitamalaeva.multithreading.base.NamedTask;
import lolitamalaeva.multithreading.base.RunnableTask;
import lolitamalaeva.multithreading.tasks.ProducerConsumerTask;

public class RunProducerConsumerTask {
    public static void main(String[] args) {
        RunnableTask task = new ProducerConsumerTask();

        if (task instanceof NamedTask named) {
            System.out.println("Запуск задачи: " + named.getName());
        }

        task.run();
    }
}
