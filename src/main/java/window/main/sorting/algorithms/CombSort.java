package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class CombSort extends SortingAlgorithm {
    public CombSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.COMB_SORT, Complexities.N_LOG_N, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        combSort();

        onAlgorithmStops();
    }

    private void combSort() {
        int n = vector.length;
        int gap = vector.length;

        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }

            swapped = false;
            for (int i = 0; i + gap < n; i++) {
                comparisons++;
                arrayAccess += 2;

                if (vector[i] > vector[i + gap]) {
                    swap(i, i + gap);
                    swapped = true;
                }
            }
        }
    }

}
