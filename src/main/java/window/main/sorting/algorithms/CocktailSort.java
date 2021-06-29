package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class CocktailSort extends SortingAlgorithm {
    public CocktailSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.COCKTAIL_SORT, Complexities.N_2, Complexities.C);
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
                    swap(i, i + 1);
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
                    swap(i, i + 1);
                    swapped = true;
                }
            }

            start = start + 1;
        }
    }
}
