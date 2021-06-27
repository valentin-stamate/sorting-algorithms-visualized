package window.main.sorting.colors;

public class Color {
    public final int r;
    public final int g;
    public final int b;

    private Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color getColor(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public static Color getColor(int c) {
        return new Color(c, c, c);
    }

}
