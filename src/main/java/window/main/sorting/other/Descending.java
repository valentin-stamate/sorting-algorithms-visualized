package window.main.sorting.other;

import processing.core.PApplet;
import window.config.Size;
import window.main.MainPanel;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class Descending extends SortingAlgorithm {
    public Descending(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Descending", "O(n)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        int n = vector.length;

        for (int i = n - 1; i >= 0; i--) {
            if (stop) {
                return;
            }

            vector[i] = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, n - i - 1);
            arrayAccess++;

            animateIndex(i);
        }

        onAlgorithmStops();
    }
}
