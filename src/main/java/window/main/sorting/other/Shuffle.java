package window.main.sorting.other;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle extends SortingAlgorithm {

    public Shuffle(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Shuffle", "O(n)", "O(1)");
    }

    /** INSPIRED FROM : https://stackoverflow.com/q/1519736/10805602 */
    @Override
    public void run() {
        onAlgorithmStart();

        Random rnd = ThreadLocalRandom.current();
        for (int i = vector.length - 1; i > 0; i--) {
            if (stop) {
                return;
            }

            int index = rnd.nextInt(i + 1);
            swap(index, i);

            setColor(i, Colors.CURRENT_INDEX);
            setColor(index, Colors.SWAPPING_INDEX);

            playSound(index);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(i);
            resetColor(index);

        }

        onAlgorithmStops();
    }
}
