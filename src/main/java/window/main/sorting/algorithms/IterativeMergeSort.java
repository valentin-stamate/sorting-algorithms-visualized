package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

/* BOTTOM UP ITERATIVE MERGE SORT */
public class IterativeMergeSort extends SortingAlgorithm {
    public IterativeMergeSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Iterative Merge Sort", "O(nlog(n))", "O(n)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        mergeSort();

        onAlgorithmStops();
    }

    private void mergeSort() {
        int n = vector.length;

        for (int currSize = 1; currSize < n; currSize = 2 * currSize) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {

                int mid = Math.min(leftStart + currSize - 1, n-1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n-1);

                merge(leftStart, mid, rightEnd);
            }
        }
    }

    private void merge(int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = vector[l + i];
            arrayAccess++;
        }

        for (j = 0; j < n2; j++) {
            R[j] = vector[m + 1+ j];
            arrayAccess++;
        }

        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                vector[k] = L[i];
                i++;
            } else {
                vector[k] = R[j];
                j++;
            }

            arrayAccess++;

            animateIndex(k);

            k++;
        }

        while (i < n1) {
            vector[k] = L[i];
            arrayAccess++;

            animateIndex(k);

            i++;
            k++;

        }

        while (j < n2) {
            vector[k] = R[j];
            arrayAccess++;

            animateIndex(k);

            j++;
            k++;
            sleep();
        }
    }

}
