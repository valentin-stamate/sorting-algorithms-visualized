package window.main.sorting.input;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.InputType;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleInput extends SortingAlgorithm {

    public ShuffleInput(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, InputType.SHUFFLE, Complexities.N, Complexities.C);
    }

    /** INSPIRED FROM : https://stackoverflow.com/q/1519736/10805602 */
    @Override
    public void run() {
        onAlgorithmStart();

        shuffle();

        onAlgorithmStops();
    }

    private void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = vector.length - 1; i > 0; i--) {
            if (stop) {
                return;
            }

            int index = rnd.nextInt(i + 1);
            swap(i, index);
        }
    }

}
