package lolitamalaeva.multithreading.examples;

import lolitamalaeva.multithreading.base.NamedTask;
import lolitamalaeva.multithreading.base.RunnableTask;
import lolitamalaeva.multithreading.tasks.VolatileFlagTask;

public class RunVolatileFlagTask {
    public static void main(String[] args) {
        RunnableTask task = new VolatileFlagTask();

        if (task instanceof NamedTask named) {
            System.out.println("Запуск задачи: " + named.getName());
        }

        task.run();
    }
}
