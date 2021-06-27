package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Bubble Sort", "O(n^2)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        bubbleSort();

        onAlgorithmStops();
    }

    private void bubbleSort() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (stop) {
                    return;
                }

                comparisons++;
                if (vector[j] > vector[j + 1]) {
                    arrayAccess += 2;

                    setColor(j, Colors.CURRENT_INDEX);
                    setColor(j + 1, Colors.SWAPPING_INDEX);

                    playSound(j + 1);
                    sleep();
                    stopSound();

                    swap(j, j + 1);

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    resetColor(j);
                    resetColor(j + 1);
                }
            }
        }
    }

}
