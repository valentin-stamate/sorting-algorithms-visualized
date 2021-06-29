package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class BogoSort extends SortingAlgorithm {
    public BogoSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Bogo Sort", "n*n!", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        bogoSort();

        onAlgorithmStops();
    }

    private void bogoSort() {
        while(!isSorted()) {
            shuffle();
            playSound((int)(Math.random() * 10000) % (vector.length));
            sleep();
            stopSound();
        }
    }

    private void shuffle() {
        int i = vector.length - 1;
        while(i > 0) {
            swap(i--,(int)(Math.random() * i));
        }
    }

}
