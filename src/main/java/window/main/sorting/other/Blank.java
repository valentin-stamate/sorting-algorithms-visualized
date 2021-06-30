package window.main.sorting.other;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

/* THIS CLASS IS MADE ONLY TO PREVENT NULL POINTER EXCEPTION */
public class Blank extends SortingAlgorithm {
    public Blank(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Not Selected", "", "");
    }

    @Override
    public void run() { }
}
