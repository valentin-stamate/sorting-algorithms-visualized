package windows.main;

import processing.core.PApplet;
import windows.config.Buttons;
import windows.Panel;
import windows.config.Config;
import windows.config.Theme;
import windows.main.sorting.*;
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
        sortingAlgorithm =  new BlankAlgorithm(pApplet, vector, color);
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

    public static double mapValueToWindowSize(int windowHeight, int vectorMaxValue, int x) {
        windowHeight = windowHeight - 50;
        return (1.0 * x / vectorMaxValue) * windowHeight + 5;
    }

    public void resizeVector(int newSize) {
        vector = new int[newSize];
        color = new Color[newSize];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) mapValueToWindowSize(height, vector.length - 1, vector.length - i - 1);
            color[i] = Colors.DEFAULT;
        }
    }

    public void setSidePanelEvents(SidePanel sidePanel) {
        sidePanel.addControlListener((event) -> {
            String controlName = event.getName();
            int controlValue = (int) event.getValue();
            Object instance = event.getController();

            switch (controlName) {
                case Buttons.BUBBLE_SORT:
                    if (sortingAlgorithm.isRunning()) {
                        return;
                    }

                    sortingAlgorithm = new BubbleSort(pApplet, vector, color);
                    sortingAlgorithm.start();
                    break;
                case Buttons.SHUFFLE:
                    if (sortingAlgorithm.isRunning()) {
                        return;
                    }

                    sortingAlgorithm = new Shuffle(pApplet, vector, color);
                    sortingAlgorithm.start();
                    break;
                case Buttons.ASCENDING:
                    if (sortingAlgorithm.isRunning()) {
                        return;
                    }

                    sortingAlgorithm = new Ascending(pApplet, vector, color);
                    sortingAlgorithm.start();
                    break;
                case Buttons.DESCENDING:
                    if (sortingAlgorithm.isRunning()) {
                        return;
                    }

                    sortingAlgorithm = new Descending(pApplet, vector, color);
                    sortingAlgorithm.start();

                    break;
                case Buttons.TOGGLE_SOUND:
                    Config.sound = !Config.sound;
                    break;
                case Buttons.STOP:
                    sortingAlgorithm.stop();
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
        return sortingAlgorithm.getComparisons();
    }

    public int getArrayAccess() {
        return sortingAlgorithm.getArrayAccess();
    }

    public String getAlgorithm() {
        return sortingAlgorithm.getAlgorithm();
    }

    public int getSwaps() {
        return sortingAlgorithm.getSwaps();
    }
}
