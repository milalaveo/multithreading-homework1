package lolitamalaeva.multithreading.model;

public class SharedFlag {
    private volatile boolean state = false;
    private volatile boolean stop = false;

    public boolean isActive() {
        return state;
    }

    public void toggle() {
        this.state = !this.state;
    }

    public void stop() {
        this.stop = true;
    }

    public boolean isStopped() {
        return stop;
    }
}
