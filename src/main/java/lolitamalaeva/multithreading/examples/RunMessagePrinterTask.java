package lolitamalaeva.multithreading.examples;

import lolitamalaeva.multithreading.base.NamedTask;
import lolitamalaeva.multithreading.base.RunnableTask;
import lolitamalaeva.multithreading.tasks.MessagePrinterTask;

public class RunMessagePrinterTask {
    public static void main(String[] args) {
        RunnableTask task = new MessagePrinterTask();

        if (task instanceof NamedTask named) {
            System.out.println("Запуск задачи: " + named.getName());
        }

        task.run();
    }
}
