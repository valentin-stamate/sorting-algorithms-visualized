package windows.main.sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle extends SortingAlgorithm {

    public Shuffle(int[] vector, int[] color) {
        super(vector, color);
    }

    /** INSPIRED FROM : https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array */
    @Override
    public void run() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = vector.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(index, i);
        }
    }
}
