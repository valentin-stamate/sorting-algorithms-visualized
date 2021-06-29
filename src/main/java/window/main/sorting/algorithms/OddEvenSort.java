package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class OddEvenSort extends SortingAlgorithm {
    public OddEvenSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.ODD_EVEN_SORT, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        oddEvenSort();

        onAlgorithmStops();
    }

    private void oddEvenSort() {
        int n = vector.length;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i <= n - 2; i += 2) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;
                if (vector[i] > vector[i + 1]) {
                    swap(i, i + 1);

                    isSorted = false;
                }
            }

            for (int i = 0; i <= n - 2; i += 2) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;
                if (vector[i] > vector[i + 1]) {
                    swap(i, i + 1);

                    isSorted = false;
                }
            }
        }
    }

}
