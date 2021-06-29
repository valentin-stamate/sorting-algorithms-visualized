package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class SelectionSort extends SortingAlgorithm {
    public SelectionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.SELECTION_SORT, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        selectionSort();

        onAlgorithmStops();
    }

    private void selectionSort() {
        int n = vector.length;

        for (int i = 0; i < n - 1; i++) {

            setColor(i, Colors.CURRENT_INDEX);

            for (int j = i + 1; j < n; j++) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;
                if (vector[i] > vector[j]) {
                    swap(i, j);
                }
            }

            resetColor(i);
        }
    }

}
