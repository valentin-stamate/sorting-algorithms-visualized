package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class BitonicSort extends SortingAlgorithm {
    public BitonicSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Bitonic Sort", "log(n)^2", "nlog(n)^2");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        bitonicSort(0, vector.length, 1);

        onAlgorithmStops();
    }

    private void bitonicSort(int low, int cnt, int dir) {
        if (stop) {
            return;
        }

        if (cnt > 1) {
            int k = cnt / 2;

            setColor(k, Colors.PIVOT_COLOR);

            bitonicSort(low, k, 1);
            bitonicSort(low + k, k, 0);

            bitonicMerge(low, cnt, dir);

            resetColor(k);
        }
    }

    private void bitonicMerge(int low, int cnt, int dir) {
        if (stop) {
            return;
        }

        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                if (stop) {
                    return;
                }

                compAndSwap(i, i + k, dir);
            }

            setColor(k, Colors.PIVOT_COLOR);

            bitonicMerge(low, k, dir);
            bitonicMerge(low + k, k, dir);

            resetColor(k);
        }
    }

    private void compAndSwap(int i, int j, int dir) {
        comparisons += 2;
        arrayAccess += 4;
        if ( (vector[i] > vector[j] && dir == 1) || (vector[i] < vector[j] && dir == 0)) {
            setColor(i, Colors.ITERATION_COLOR);
            setColor(j, Colors.SWAPPING_INDEX);

            swap(i, j);
        }
    }

}
