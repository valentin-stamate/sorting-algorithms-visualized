package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;
import java.util.Stack;

public class ShellSort extends SortingAlgorithm {
    public ShellSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Shell Sort", "O(nlog(n)^2)", "O(n)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        shellSort();

        onAlgorithmStops();
    }

    private void shellSort() {
        int n = vector.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = vector[i];
                arrayAccess++;

                /* FOR VISUALIZATION */
                Stack<Integer> stack = new Stack<>();

                int j;
                for (j = i; j >= gap && vector[j - gap] > temp; j -= gap) {
                    if (stop) {
                        return;
                    }

                    comparisons++;
                    arrayAccess++;

                    stack.push(j);

                    setColor(j, Colors.SWAPPING_INDEX);
                    playSound(j);
                    sleep();
                    stopSound();

                    while (pause) {
                        if (stop) {
                            return;
                        }
                        pauseSleep();
                    }

                    vector[j] = vector[j - gap];
                    arrayAccess += 2;
                }

                while (!stack.empty()) {
                    resetColor(stack.pop());
                }

                vector[j] = temp;
                arrayAccess++;
            }
        }
    }
}
