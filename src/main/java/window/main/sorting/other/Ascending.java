package window.main.sorting.other;

import processing.core.PApplet;
import window.config.Size;
import window.main.MainPanel;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class Ascending extends SortingAlgorithm {
    public Ascending(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Ascending", "O(n)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        int n = vector.length;

        for (int i = 0; i < n; i++) {
            if (stop) {
                return;
            }

            vector[i] = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, i);
            arrayAccess++;

            setColor(i, Colors.CURRENT_INDEX);
            playSound(i);
            sleep();
            stopSound();

            while (pause) {
                if (stop) {
                    return;
                }
                pauseSleep();
            }

            resetColor(i);
        }

        onAlgorithmStops();
    }
}
