package org.example.sort;

public class InsertionSort extends SortStrategy {

    @Override
    public void run() {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                sleep();
            }
            array[j + 1] = key;
            sleep();
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
