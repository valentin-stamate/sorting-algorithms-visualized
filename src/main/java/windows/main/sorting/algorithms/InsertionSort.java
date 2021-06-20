package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.config.Theme;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class InsertionSort extends SortingAlgorithm {
    public InsertionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Insertion Sort");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        int n = vector.length;

        for (int i = 1; i < n; ++i) {
            int current = vector[i];
            int j = i - 1;

            arrayAccess++;

            setColor(i, Colors.PIVOT_COLOR);

            while (j >= 0 && vector[j] > current) {
                if (stop) {
                    return;
                }
                comparisons += 2;
                arrayAccess++;

                setColor(j + 1, Colors.CURRENT_INDEX);
                setColor(j, Colors.SWAPPING_INDEX);

                playSound(vector[j + 1]);
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

                setColor(j, Theme.LINE_COLOR);
                setColor(j + 1, Theme.LINE_COLOR);

                j = j - 1;
            }

            setColor(i, Theme.LINE_COLOR);

            vector[j + 1] = current;
            arrayAccess++;
        }

        onAlgorithmStops();
    }
}
