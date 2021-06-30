package window.main.sorting.input;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.InputType;
import window.config.Size;
import window.main.MainPanel;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class DescendingInput extends SortingAlgorithm {
    public DescendingInput(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, InputType.DESCENDING, Complexities.N, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        descending();

        onAlgorithmStops();
    }

    private void descending() {
        int n = vector.length;

        for (int i = n - 1; i >= 0; i--) {
            if (stop) {
                return;
            }

            vector[i] = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, n - i - 1);
            arrayAccess++;

            animateIndex(i);
        }
    }

}
