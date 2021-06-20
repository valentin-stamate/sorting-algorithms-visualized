package windows.main.sorting.colors;

public final class Colors {
    public static final Color DEFAULT_LINE_COLOR = Color.getColor(0);

    private static final Color GREEN = Color.getColor(0, 121, 107);
    private static final Color RED = Color.getColor(229, 57, 53);
    private static final Color BLUE = Color.getColor(3, 169, 244);
    private static final Color ORANGE = Color.getColor(230, 74, 25);

    public static final Color PIVOT_COLOR = BLUE;
    public static final Color CURRENT_INDEX = GREEN;
    public static final Color SWAPPING_INDEX = RED;
    public static final Color ITERATION_COLOR = ORANGE;
}
