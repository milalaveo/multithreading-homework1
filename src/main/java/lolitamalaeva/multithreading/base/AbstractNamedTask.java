package lolitamalaeva.multithreading.base;

public abstract class AbstractNamedTask implements RunnableTask, NamedTask {
    private final String name;

    protected AbstractNamedTask(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
