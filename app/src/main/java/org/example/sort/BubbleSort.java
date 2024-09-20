package org.example.sort;

public class BubbleSort extends SortStrategy {

    @Override
    public void run() {
        for (int j = 0; j < array.length; j++)
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }

                if (sleepTime > 0)
                    sleep();
            }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }

}
