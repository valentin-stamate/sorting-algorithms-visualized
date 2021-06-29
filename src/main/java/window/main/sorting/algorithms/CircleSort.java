package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class CircleSort extends SortingAlgorithm {
    public CircleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Circle Sort","O(nlog(n))", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        circleSort();

        onAlgorithmStops();
    }

    private void circleSort() {
        while (circleSortR(0, vector.length - 1, 0) != 0) {
            if (stop) {
                return;
            }
        }
    }

    private int circleSortR(int lo, int hi, int numSwaps) {
        if (stop) {
            return 0;
        }

        if (lo == hi) {
            return numSwaps;
        }

        int high = hi;
        int low = lo;
        int mid = (hi - lo) / 2;

        while (lo < hi) {

            arrayAccess += 2;
            comparisons++;
            if (vector[lo] > vector[hi]) {

                setColor(lo, Colors.CURRENT_INDEX);
                setColor(hi, Colors.SWAPPING_INDEX);
                playSound(lo);
                playSound(hi);
                sleep();
                stopSound();

                while (pause) {
                    if (stop) {
                        return 0;
                    }
                    pauseSleep();
                }

                resetColor(lo);
                resetColor(hi);

                swap(lo, hi);
                numSwaps++;
            }

            lo++;
            hi--;
        }

        comparisons++;
        arrayAccess += 2;
        if (lo == hi && vector[lo] > vector[hi + 1]) {

            setColor(lo, Colors.CURRENT_INDEX);
            setColor(hi, Colors.SWAPPING_INDEX);
            playSound(lo);
            playSound(hi);
            sleep();
            stopSound();
            resetColor(lo);
            resetColor(hi);

            swap(lo, hi + 1);
            numSwaps++;
        }

        numSwaps = circleSortR(low, low + mid, numSwaps);
        numSwaps = circleSortR(low + mid + 1, high, numSwaps);

        return numSwaps;
    }

}
