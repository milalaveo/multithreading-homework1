package lolitamalaeva.multithreading.config;

public class ProducerConsumerConfig {
    public static final int TOGGLE_DELAY_MS = 500;   // Задержка для Producer (M)
    public static final int COUNTDOWN_START_MS = 5000; // Начальная точка отсчёта (K)
    public static final int STEP_DELAY_MS = TOGGLE_DELAY_MS / 10; // Задержка C при countdown
}