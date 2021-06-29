package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class InPlaceMergeSortOne extends SortingAlgorithm {
    public InPlaceMergeSortOne(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.IN_PLACE_MERGE_SORT_ONE, Complexities.N_LOG_2_N, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        mergeSort(0, vector.length - 1);

        onAlgorithmStops();
    }

    private void mergeSort(int s, int e) {
        if (s == e) {
            return;
        }

        int mid = (s + e) / 2;

        setColor(mid, Colors.PIVOT_COLOR);

        mergeSort(s, mid);
        mergeSort(mid + 1, e);
        inPlaceMerge(s, e);

        resetColor(mid);
    }

    private void inPlaceMerge(int start, int end) {
        if (stop) {
            return;
        }

        int gap = end - start + 1;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                if (stop) {
                    return;
                }

                int j = i + gap;

                arrayAccess += 2;
                comparisons++;

                if (vector[i] > vector[j]) {
                    swap(i, j);
                }
            }
        }
    }

    private int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }

        return (int) Math.ceil(gap / 2.0);
    }

}
