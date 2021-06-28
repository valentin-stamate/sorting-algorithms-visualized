package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class CocktailSort extends SortingAlgorithm {
    public CocktailSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Cocktail", "O(n^2)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        cocktailSort();

        onAlgorithmStops();
    }

    private void cocktailSort() {
        boolean swapped = true;
        int start = 0;
        int end = vector.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;

                if (vector[i] > vector[i + 1]) {

                    setColor(i, Colors.CURRENT_INDEX);
                    setColor(i + 1, Colors.SWAPPING_INDEX);

                    playSound(i);
                    playSound(i + 1);
                    sleep();
                    stopSound();

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    swap(i, i + 1);

                    resetColor(i);
                    resetColor(i + 1);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (stop) {
                    return;
                }

                arrayAccess += 2;
                comparisons++;

                if (vector[i] > vector[i + 1]) {

                    setColor(i, Colors.CURRENT_INDEX);
                    setColor(i + 1, Colors.SWAPPING_INDEX);

                    playSound(i);
                    playSound(i + 1);
                    sleep();
                    stopSound();

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    swap(i, i + 1);

                    resetColor(i);
                    resetColor(i + 1);

                    swapped = true;
                }
            }

            start = start + 1;
        }
    }
}
