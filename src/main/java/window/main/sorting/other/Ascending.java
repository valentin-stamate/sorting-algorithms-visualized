package window.main.sorting.other;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.InputType;
import window.config.Size;
import window.main.MainPanel;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class Ascending extends SortingAlgorithm {
    public Ascending(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, InputType.ASCENDING, Complexities.N, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        ascending();

        onAlgorithmStops();
    }

    private void ascending() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            if (stop) {
                return;
            }

            vector[i] = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, i);
            arrayAccess++;

            animateIndex(i);
        }
    }

}
