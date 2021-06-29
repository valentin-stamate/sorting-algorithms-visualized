package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class InsertionSort extends SortingAlgorithm {
    public InsertionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.INSERTION_SORT, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        insertionSort();

        onAlgorithmStops();
    }

    private void insertionSort() {
        int n = vector.length;

        for (int i = 1; i < n; ++i) {
            int current = vector[i];
            int j = i - 1;

            arrayAccess++;

            setColor(i, Colors.PIVOT_COLOR);

            comparisons++;
            while (j >= 0 && vector[j] > current) {
                if (stop) {
                    return;
                }

                arrayAccess++;
                comparisons++;

                animateIndex(j + 1);

                vector[j + 1] = vector[j];
                arrayAccess += 2;

                j = j - 1;
            }

            resetColor(i);

            vector[j + 1] = current;
            arrayAccess++;
        }
    }

}
