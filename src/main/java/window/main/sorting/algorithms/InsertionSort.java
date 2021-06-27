package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class InsertionSort extends SortingAlgorithm {
    public InsertionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Insertion Sort", "O(n^2)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        insertionSort();

        onAlgorithmStops();
    }

    private void insertionSort() {
        int n = vector.length;

        for (int i = 1; i < n; ++i) {
            int current = vector[i];
            int j = i - 1;

            arrayAccess++;

            setColor(i, Colors.PIVOT_COLOR);

            comparisons += 2;
            while (j >= 0 && vector[j] > current) {
                if (stop) {
                    return;
                }
                arrayAccess++;

                setColor(j + 1, Colors.CURRENT_INDEX);
                setColor(j, Colors.SWAPPING_INDEX);

                playSound(j + 1);
                sleep();
                stopSound();

                while (pause) {
                    if (stop) {
                        return;
                    }
                    pauseSleep();
                }

                vector[j + 1] = vector[j];
                arrayAccess += 2;

                resetColor(j);
                resetColor(j + 1);

                j = j - 1;
            }

            resetColor(i);

            vector[j + 1] = current;
            arrayAccess++;
        }
    }

}
