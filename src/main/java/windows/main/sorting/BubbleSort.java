package windows.main.sorting;

import windows.Theme;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(int[] vector, Color[] color) {
        super(vector, color);
    }

    @Override
    public void run() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    swap(j, j + 1);

                    setColor(j, Colors.BLUE);
                    setColor(j + 1, Colors.RED);

                    sleep();

                    setColor(j, Theme.LINE_COLOR);
                    setColor(j + 1, Theme.LINE_COLOR);
                }
            }
        }
    }

}
