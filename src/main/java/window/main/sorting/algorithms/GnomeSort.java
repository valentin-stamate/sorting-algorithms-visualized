package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class GnomeSort extends SortingAlgorithm {
    public GnomeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Gnome Sort", "O(n^2)", "O(1)");
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
