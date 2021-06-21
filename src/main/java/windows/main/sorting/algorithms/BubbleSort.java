package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Bubble Sort");
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