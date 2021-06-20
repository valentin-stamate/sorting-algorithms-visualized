package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class MergeSort extends SortingAlgorithm {

    public MergeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Merge Sort");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        mergeSort(0, vector.length - 1);

        onAlgorithmStops();
    }

    void mergeSort(int l, int r) {
        comparisons++;
        if (l < r) {

            int m = l + (r - l) / 2;

            setColor(m, Colors.PIVOT_COLOR);

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);

            resetColor(m);
        }
    }

    void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = vector[l + i];
            arrayAccess++;
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = vector[m + 1 + j];
            arrayAccess++;
        }

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            comparisons++;
            arrayAccess++;

            if (stop) {
                return;
            }

            if (L[i] <= R[j]) {
                vector[k] = L[i];
                i++;
            }
            else {
                vector[k] = R[j];
                j++;
            }

            setColor(k, Colors.CURRENT_INDEX);

            playSound(k);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(k);

            k++;
        }

        while (i < n1) {
            if (stop) {
                return;
            }

            vector[k] = L[i];

            setColor(k, Colors.CURRENT_INDEX);

            playSound(k);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(k);

            i++;
            k++;
        }

        while (j < n2) {
            if (stop) {
                return;
            }

            vector[k] = R[j];

            setColor(k, Colors.CURRENT_INDEX);

            playSound(k);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(k);

            j++;
            k++;
        }
    }

}
