package windows.main.sorting;

import processing.core.PApplet;
import windows.main.sorting.colors.Color;

/* THIS CLASS IS MADE ONLY TO PREVENT NULL POINTER EXCEPTION */
public class BlankAlgorithm extends SortingAlgorithm {
    public BlankAlgorithm(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Not Selected");
    }

    @Override
    public void run() { }
}
