package window.main.sorting.input;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.InputType;
import window.config.Size;
import window.main.MainPanel;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;

public class SinWaveInput extends SortingAlgorithm {
    public SinWaveInput(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, InputType.SIN_WAVE, Complexities.N, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        sinWave();

        onAlgorithmStops();
    }

    private void sinWave() {
        int n = vector.length;
        int maxValue = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, n - 1) / 2;

        for (int i = 0; i < n; i++) {
            vector[i] = (int) (maxValue + Math.sin(degreeToRadian(i)) * maxValue) + 1;
            animateIndex(i);
        }

    }

    private double degreeToRadian(int degree) {
        return 1.0 * degree * Math.PI / 180.0;
    }

}
