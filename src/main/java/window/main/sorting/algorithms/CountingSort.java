package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class CountingSort extends SortingAlgorithm {
    public CountingSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Counting Sort", "O(n+k)", "O(n+k)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        countingSort();

        onAlgorithmStops();
    }

    void countingSort() {
        int n = vector.length;
        int max = getMax() + 1;

        int[] buffer = new int[n];
        int[] count = new int[max];

        for (int i = 0; i < n; ++i) {
            if (stop) {
                return;
            }

            arrayAccess++;

            ++count[vector[i]];
            animateIndex(i);
        }

        for (int i = 1; i < max; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (stop) {
                return;
            }

            arrayAccess++;

            buffer[count[vector[i]] - 1] = vector[i];
            --count[vector[i]];
            animateIndex(i);
        }

        for (int i = 0; i < n; ++i) {
            if (stop) {
                return;
            }

            arrayAccess++;

            vector[i] = buffer[i];
            animateIndex(i);
        }
    }

}
