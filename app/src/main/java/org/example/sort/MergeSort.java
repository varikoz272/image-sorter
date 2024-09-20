package org.example.sort;

public class MergeSort extends SortStrategy {

    public MergeSort() {
    }

    public MergeSort(int sleepTime) {
        super(sleepTime);
    }

    @Override
    public void run() {
        sort(array);
    }

    private void sort(int[] subArray) {

        if (subArray.length < 2) {
            return;
        }
        int mid = subArray.length / 2;
        int[] l = new int[mid];
        int[] r = new int[subArray.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = subArray[i];
        }
        for (int i = mid; i < subArray.length; i++) {
            r[i - mid] = subArray[i];
        }
        sort(l);
        sort(r);

        merge(subArray, l, r, mid, subArray.length - mid);
    }

    private void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];

            if (sleepTime > 0)
                sleep();
        }

        while (i < left) {
            a[k++] = l[i++];
            if (sleepTime > 0)
                sleep();
        }

        while (j < right) {
            a[k++] = r[j++];
            if (sleepTime > 0)
                sleep();
        }
        if (sleepTime > 0) {
            sleep();

            // System.out.println("ARRAYS LENGTH" + (r.length + l.length));
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}
