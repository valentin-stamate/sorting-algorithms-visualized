package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class GnomeSort extends SortingAlgorithm {
    public GnomeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.GNOME_SORT, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        gnomeSort();

        onAlgorithmStops();
    }

    private void gnomeSort() {
        int n = vector.length;
        int index = 0;

        while (index < n) {
            if (stop) {
                return;
            }

            comparisons += 2;

            if (index == 0) {
                index++;
            }

            comparisons++;
            arrayAccess +=2;

            if (vector[index] >= vector[index - 1]) {
                index++;
            } else {
                swap(index, index - 1);
                index--;
            }
        }
    }

}
