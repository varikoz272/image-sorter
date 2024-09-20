package org.example.sort;

public abstract class SortStrategy implements Runnable {
    protected int sleepTime;
    protected int[] array;

    public SortStrategy(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public SortStrategy() {
        this.sleepTime = 0; // 60 FPS
    }

    protected static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public abstract String getName();
}
