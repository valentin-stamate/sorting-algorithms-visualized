package windows.main.sorting;

import processing.core.PApplet;
import windows.config.Theme;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle extends SortingAlgorithm {

    public Shuffle(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Shuffle");
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

            playSound(vector[index]);
            setColor(i, Colors.CURRENT_INDEX);
            setColor(index, Colors.SWAPPING_INDEX);
            sleep();
            setColor(i, Theme.LINE_COLOR);
            setColor(index, Theme.LINE_COLOR);
            stopSound();

        }

        onAlgorithmStops();
    }
}
