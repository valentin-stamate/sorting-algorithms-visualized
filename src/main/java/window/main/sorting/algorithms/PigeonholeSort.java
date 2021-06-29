package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class PigeonholeSort extends SortingAlgorithm {
    public PigeonholeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.PIGEONHOLE_SORT, Complexities.N_2_POW_K, Complexities.TWO_POW_K);
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

            animateIndex(i);

            arrayAccess++;
        }

        int index = 0;

        for(int j = 0; j < range; j++) {
            while(phole[j]-- > 0) {
                if (stop) {
                    return;
                }

                vector[index] = j + min;
                arrayAccess++;

                animateIndex(index);

                index++;
            }
        }
    }

}
