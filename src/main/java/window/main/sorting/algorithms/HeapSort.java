package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class HeapSort extends SortingAlgorithm {
    public HeapSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Heap Sort", "O(nlog(n))", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        heapSort();

        onAlgorithmStops();
    }

    public void heapSort() {
        int n = vector.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            if (stop) {
                return;
            }

            setColor(i, Colors.PIVOT_COLOR);
            heapify(n, i);
            resetColor(i);
        }

        for (int i = n - 1; i > 0; i--) {
            if (stop) {
                return;
            }

            swap(0, i);

            setColor(i, Colors.CURRENT_INDEX);
            heapify(i, 0);
            resetColor(i);
        }
    }

    void heapify(int n, int i) {
        if (stop) {
            return;
        }

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        comparisons += 2;
        arrayAccess += 2;
        if (l < n && vector[l] > vector[largest]) {
            largest = l;
        }

        comparisons += 2;
        arrayAccess += 2;
        if (r < n && vector[r] > vector[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }

}
