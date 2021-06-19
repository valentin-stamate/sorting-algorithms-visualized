package windows.main.sorting;

import windows.main.sorting.colors.Color;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(int[] vector, int[] color) {
        super(vector, color);
    }

    @Override
    public void run() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    swap(i, j);

                    setColor(j, Color.GREEN);
                    setColor(j + 1, Color.RED);

                    sleep();
                }
            }
        }

    }

}
