package windows.main.sorting;

import windows.main.sorting.colors.Color;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle extends SortingAlgorithm {

    public Shuffle(int[] vector, Color[] color) {
        super(vector, color, "Shuffle");
    }

    /** INSPIRED FROM : https://stackoverflow.com/q/1519736/10805602 */
    @Override
    public void run() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = vector.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(index, i);
        }
    }
}
