package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class CycleSort extends SortingAlgorithm {
    public CycleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Cycle Sort", "O(n^2)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        cycleSort();

        onAlgorithmStops();
    }

    private void cycleSort() {

        for (int cycleStart = 0; cycleStart < vector.length - 1; cycleStart++) {
            if (stop) {
                stopSound();
                return;
            }

            setColor(cycleStart, Colors.ITERATION_COLOR);
            playSound(cycleStart);

            int val = vector[cycleStart];
            arrayAccess++;

            int pos = cycleStart;
            for (int i = cycleStart + 1; i < vector.length; i++) {
                comparisons++;
                arrayAccess++;

                if (vector[i] < val) {
                    pos++;
                }
            }

            if (pos == cycleStart) {
                stopSound();
                resetColor(cycleStart);
                continue;
            }

            arrayAccess++;
            while (val == vector[pos]) {
                arrayAccess++;
                pos++;
            }


            animateIndex(pos);
            playSound(cycleStart);

            int tmp = vector[pos];
            vector[pos] = val;
            val = tmp;
            arrayAccess += 2;

            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < vector.length; i++) {
                    arrayAccess++;
                    comparisons++;
                    if (vector[i] < val) {
                        pos++;
                    }
                }

                arrayAccess++;
                while (val == vector[pos]) {
                    arrayAccess++;
                    pos++;
                }

                animateIndex(pos);
                playSound(cycleStart);

                tmp = vector[pos];
                vector[pos] = val;
                val = tmp;

                arrayAccess += 2;
            }

            stopSound();
            resetColor(cycleStart);
        }
    }
}
