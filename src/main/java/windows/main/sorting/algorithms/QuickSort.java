package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class QuickSort extends SortingAlgorithm {

    public QuickSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Quick Sort");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        quickSort(0, vector.length - 1);

        onAlgorithmStops();
    }

    void quickSort(int low, int high) {
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

                setColor(i, Colors.SWAPPING_INDEX);

                playSound(i);

                sleep();
                stopSound();

                while (pause) {
                    if (stop) {
                        return 0;
                    }
                    pauseSleep();
                }

                swap(i, j);
                resetColor(i);
            }

            resetColor(j);
        }

        swap(i + 1, high);
        return (i + 1);
    }
}
