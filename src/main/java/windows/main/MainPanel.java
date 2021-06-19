package windows.main;

import processing.core.PApplet;
import windows.Panel;
import windows.Theme;
import windows.main.sorting.BubbleSort;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainPanel extends Panel {

    private int[] vector = new int[0];
    private int[] color = new int[0];

    private float lineWeight = 2;
    private float lineMargin = 2;

    private SortingAlgorithm sortingAlgorithm;

    public MainPanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        resizeVector(128);

        sortingAlgorithm = new BubbleSort(vector, color);
        sortingAlgorithm.start();
    }

    @Override
    public void draw() {
        pApplet.fill(panelColor);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);

        float lineSpace = 1.0f * width / vector.length;

        for (int i = 0; i < vector.length; i++) {
            pApplet.stroke(color[i]);
            if (color[i] == Color.DEFAULT) {
                pApplet.stroke(Theme.LINE_COLOR);
            }

            pApplet.strokeWeight(lineWeight);

            int height = pApplet.height;
            float lineX = lineSpace * i + lineWeight + lineMargin;

            pApplet.line(lineX, height, lineX, height - vector[i]);
        }
    }

    private double mapValueToWindowSize(int x) {
        int windowHeight = height - 75;
        int vectorMaxValue = vector.length - 1;

        return (1.0 * x / vectorMaxValue) * windowHeight + 5;
    }

    public void resizeVector(int newSize) {
        vector = new int[newSize];
        color = new int[newSize];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int)mapValueToWindowSize(i);
            color[i] = Color.DEFAULT;
        }

        /* SHUFFLE THE ARRAY */
        Random rnd = ThreadLocalRandom.current();
        for (int i = vector.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = vector[index];
            vector[index] = vector[i];
            vector[i] = a;
        }
    }
}
