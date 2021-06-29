package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class SelectionSort extends SortingAlgorithm {
    public SelectionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Selection Sort", "O(n^2)", "O(1)");
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
