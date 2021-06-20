package windows.main.sorting.other;

import processing.core.PApplet;
import windows.config.Size;
import windows.main.MainPanel;
import windows.main.sorting.SortingAlgorithm;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class Descending extends SortingAlgorithm {
    public Descending(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Descending");
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
