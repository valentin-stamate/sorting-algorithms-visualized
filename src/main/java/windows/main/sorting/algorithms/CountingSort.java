package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class CountingSort extends SortingAlgorithm {
    public CountingSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Counting Sort");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        countingSort();

        onAlgorithmStops();
    }

    void countingSort() {
        int n = vector.length;
        int max = getMax() + 1;

        int[] buffer = new int[n];
        int[] count = new int[max];

        for (int i = 0; i < n; ++i) {
            if (stop) {
                return;
            }

            ++count[vector[i]];

            setColor(i, Colors.ITERATION_COLOR);
            playSound(i);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(i);

            arrayAccess++;
        }

        for (int i = 1; i < max; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (stop) {
                return;
            }

            buffer[count[vector[i]] - 1] = vector[i];
            --count[vector[i]];

            setColor(i, Colors.ITERATION_COLOR);
            playSound(i);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(i);

            arrayAccess++;
        }

        for (int i = 0; i < n; ++i) {
            if (stop) {
                return;
            }

            vector[i] = buffer[i];

            setColor(i, Colors.ITERATION_COLOR);
            playSound(i);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(i);

        }

    }

}
