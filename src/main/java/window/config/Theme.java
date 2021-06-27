package window.config;

import window.main.sorting.colors.Color;

public final class Theme {
    public static final int LIGHT_THEME = 0;
    public static final int DARK_THEME = 1;

    public static int currentTheme = DARK_THEME;

    /* DARK THEME */
    public static final Color DARK_LINE_COLOR = Color.getColor(255, 255, 255);
    public static final Color DARK_TEXT_COLOR = Color.getColor(255);
    public static final Color DARK_BACKGROUND_COLOR = Color.getColor(15);
    public static final Color DARK_MAIN_PANEL_COLOR = Color.getColor(20);
    public static final Color DARK_INFO_PANEL_COLOR = Color.getColor(30);

    /* LIGHT THEME */
    public static final Color LIGHT_LINE_COLOR = Color.getColor(200);
    public static final Color LIGHT_TEXT_COLOR = Color.getColor(20);
    public static final Color LIGHT_BACKGROUND_COLOR = Color.getColor(240);
    public static final Color LIGHT_MAIN_PANEL_COLOR = Color.getColor(255);
    public static final Color LIGHT_INFO_PANEL_COLOR = Color.getColor(230);

    /* COMPONENTS COLOR */
    public static Color lineColor = DARK_LINE_COLOR;
    public static Color textColor = DARK_TEXT_COLOR;
    public static Color backgroundColor = DARK_BACKGROUND_COLOR;
    public static Color mainPanelColor = DARK_MAIN_PANEL_COLOR;
    public static Color infoPanelColor = DARK_INFO_PANEL_COLOR;

    public static void refreshTheme() {
        switch (currentTheme) {
            case LIGHT_THEME:
                lineColor = LIGHT_LINE_COLOR;
                textColor = LIGHT_TEXT_COLOR;
                backgroundColor = LIGHT_BACKGROUND_COLOR;
                mainPanelColor = LIGHT_MAIN_PANEL_COLOR;
                infoPanelColor = LIGHT_INFO_PANEL_COLOR;
                break;
            case DARK_THEME:
                lineColor = DARK_LINE_COLOR;
                textColor = DARK_TEXT_COLOR;
                backgroundColor = DARK_BACKGROUND_COLOR;
                mainPanelColor = DARK_MAIN_PANEL_COLOR;
                infoPanelColor = DARK_INFO_PANEL_COLOR;
                break;
            default:
                break;
        }
    }
}
