package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.BUBBLE_SORT, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        bubbleSort();

        onAlgorithmStops();
    }

    private void bubbleSort() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (stop) {
                    return;
                }

                comparisons++;
                arrayAccess += 2;

                if (vector[j] > vector[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

}
