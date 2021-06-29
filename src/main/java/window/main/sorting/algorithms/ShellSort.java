package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.Config;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;
import java.util.Stack;

public class ShellSort extends SortingAlgorithm {
    public ShellSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.SHELL_SORT, Complexities.N_LOG_2_N, Complexities.N);
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
                        sleep(Config.PAUSE_DELAY_TIME);
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
