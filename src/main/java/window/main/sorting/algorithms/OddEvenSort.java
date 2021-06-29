package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class OddEvenSort extends SortingAlgorithm {
    public OddEvenSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Odd Even Sort", "O(n^2)", "O(1)");
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
