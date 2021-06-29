package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class QuickSort extends SortingAlgorithm {

    public QuickSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.QUICK_SORT, Complexities.N_LOG_N, Complexities.N);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        quickSort(0, vector.length - 1);

        onAlgorithmStops();
    }

    void quickSort(int low, int high) {
        if (stop) {
            return;
        }

        comparisons++;
        if (low < high) {
            int pi = partition(low, high);

            if (stop) {
                return;
            }

            setColor(pi, Colors.PIVOT_COLOR);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);

            resetColor(pi);
        }
    }

    int partition(int low, int high) {
        int pivot = vector[high];
        arrayAccess++;

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if (stop) {
                return 0;
            }

            setColor(j, Colors.CURRENT_INDEX);

            comparisons++;
            arrayAccess++;
            if (vector[j] < pivot) {
                i++;
                swap(i, j);
            }

            resetColor(j);
        }

        swap(i + 1, high);
        return (i + 1);
    }
}
