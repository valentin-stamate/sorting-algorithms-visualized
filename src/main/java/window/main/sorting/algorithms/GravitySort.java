package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class GravitySort extends SortingAlgorithm {
    public GravitySort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Gravity Sort", "O(n*max)", "O(n*max)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        beadSort();

        onAlgorithmStops();
    }

    private void beadSort() {
        int n = vector.length;

        final int max = getMax() + 1;

        boolean[][] grid = new boolean[n][max];

        for (int val = 0; val < max; val++) {
            for (int i = 0; i < n; i++) {
                grid[i][val] = val <= vector[i];
            }
        }

        for (int val = max - 1; val >= 0; val--) {
            int i = n - 1;

            comparisons++;
            while (grid[i][val] && i > 0) {
                i--;
            }

            int j = i - 1;

            for (;j >= 0; j--) {
                if (stop) {
                    return;
                }

                comparisons++;
                if (grid[j][val]) {

                    setColor(i, Colors.ITERATION_COLOR);
                    setColor(j, Colors.SWAPPING_INDEX);
                    playSound(i);
                    playSound(j);
                    sleep();
                    stopSound();

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    resetColor(i);
                    resetColor(j);

                    swap(grid, i, j);
                    swap(i, j);

                    i--;
                }
            }
        }
    }

    private void swap(boolean[][] v, int i, int j) {
        boolean[] aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
