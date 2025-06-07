package lolitamalaeva.multithreading.model;

public class SharedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
