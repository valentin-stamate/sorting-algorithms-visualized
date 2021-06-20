package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class SelectionSort extends SortingAlgorithm {
    public SelectionSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Selection Sort");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        selectionSort();

        onAlgorithmStops();
    }

    private void selectionSort() {
        int n = vector.length;

        for (int i = 0; i < n - 1; i++) {

            setColor(i, Colors.CURRENT_INDEX);

            for (int j = i + 1; j < n; j++) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;
                if (vector[i] > vector[j]) {

                    setColor(j, Colors.SWAPPING_INDEX);
                    playSound(j);
                    sleep();
                    stopSound();

                    swap(i, j);

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    resetColor(j);

                }
            }

            resetColor(i);
        }
    }

}
