package windows.main.sorting.algorithms;

import processing.core.PApplet;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

import java.util.Stack;

public class ShellSort extends SortingAlgorithm {
    public ShellSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Shell Sort");
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

                /* FOR VISUALIZATION */
                Stack<Integer> stack = new Stack<>();

                int j;
                for (j = i; j >= gap && vector[j - gap] > temp; j -= gap) {
                    if (stop) {
                        return;
                    }

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
                }

                while (!stack.empty()) {
                    resetColor(stack.pop());
                }


                vector[j] = temp;
            }
        }
    }
}
