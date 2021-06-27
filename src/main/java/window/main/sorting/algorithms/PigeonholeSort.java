package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class PigeonholeSort extends SortingAlgorithm {
    public PigeonholeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Pigeonhole Sort", "O(n+2^k)", "O(2^k)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        pigeonholeSort();

        onAlgorithmStops();
    }

    private void pigeonholeSort() {
        int n = vector.length;

        int min = getMin();
        int max = getMax();

        int range = max - min + 1;
        int[] phole = new int[range];

        for (int i = 0; i < n; i++) {
            if (stop) {
                return;
            }

            phole[vector[i] - min]++;

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

        int index = 0;

        for(int j = 0; j < range; j++) {
            while(phole[j]-- > 0) {
                if (stop) {
                    return;
                }

                vector[index] = j + min;

                setColor(index, Colors.CURRENT_INDEX);
                playSound(index);
                sleep();
                stopSound();

                while (pause) {
                    if (stop) {
                        return;
                    }
                    pauseSleep();
                }

                resetColor(index);

                arrayAccess++;

                index++;
            }
        }
    }

}
