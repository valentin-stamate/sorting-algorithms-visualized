package windows.main;

import processing.core.PApplet;
import windows.config.Buttons;
import windows.Panel;
import windows.config.Config;
import windows.config.Theme;
import windows.main.sorting.BubbleSort;
import windows.main.sorting.Shuffle;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;
import windows.side.SidePanel;

public class MainPanel extends Panel {

    private int[] vector = new int[0];
    private Color[] color = new Color[0];

    private float lineWeight = 2;
    private float lineMargin = 2;

    private SortingAlgorithm sortingAlgorithm;

    public MainPanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        resizeVector(Config.arraySize);
    }

    @Override
    public void draw() {
        pApplet.fill(panelColor);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);

        float lineSpace = 1.0f * width / vector.length;

        for (int i = 0; i < vector.length; i++) {
            Color col = color[i];
            pApplet.stroke(col.r, col.g, col.b);
            if (col == Colors.DEFAULT) {
                Color defCol = Theme.LINE_COLOR;
                pApplet.stroke(defCol.r, defCol.g, defCol.b);
            }

            pApplet.strokeWeight(lineWeight);

            int height = pApplet.height;
            float lineX = lineSpace * i + lineWeight + lineMargin;

            pApplet.line(lineX, height, lineX, height - vector[i]);
        }
    }

    private double mapValueToWindowSize(int x) {
        int windowHeight = height - 50;
        int vectorMaxValue = vector.length - 1;

        return (1.0 * x / vectorMaxValue) * windowHeight + 5;
    }

    public void resizeVector(int newSize) {
        vector = new int[newSize];
        color = new Color[newSize];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int)mapValueToWindowSize(vector.length - i);
            color[i] = Colors.DEFAULT;
        }
    }

    public void setSidePanelEvents(SidePanel sidePanel) {
        sidePanel.addControlListener((name, value) -> {
            switch (name) {
                case Buttons.BUBBLE_SORT:
                    sortingAlgorithm = new BubbleSort(pApplet, vector, color);
                    sortingAlgorithm.start();
                    break;
                case Buttons.SHUFFLE:
                    sortingAlgorithm = new Shuffle(pApplet, vector, color);
                    sortingAlgorithm.start();
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void stop() {
        super.stop();

        sortingAlgorithm.stop();
    }

    /* GETTERS AND SETTERS */
    public int getComparisons() {
        if (sortingAlgorithm == null) {
            return 0;
        }

        return sortingAlgorithm.getComparisons();
    }

    public int getArrayAccess() {
        if (sortingAlgorithm == null) {
            return 0;
        }

        return sortingAlgorithm.getArrayAccess();
    }

    public String getAlgorithm() {
        if (sortingAlgorithm == null) {
            return "";
        }

        return sortingAlgorithm.getAlgorithm();
    }

    public int getSwaps() {
        if (sortingAlgorithm == null) {
            return 0;
        }

        return sortingAlgorithm.getSwaps();
    }
}
