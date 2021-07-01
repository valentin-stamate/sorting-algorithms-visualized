package window.config;

/* TODO: add setters and getters */
/* TODO: see if a listener when a parameter change is useful */
public class Config {
    public static final int FONT_SIZE = 11;
    public static final int PAUSE_DELAY_TIME = 100;

    public static final int MIN_DELAY_TIME = 1;
    public static int delayTime = 20;
    public static final int MAX_DELAY_TIME = 100;

    public static final int MIN_ARRAY_SIZE = 100;
    public static int arraySize = 128;
    public static final int MAX_ARRAY_SIZE = 2048;

    public static boolean sound = true;

    private static boolean autoRunning = false;

    /* SETTERS AND GETTERS */
    public static void setAutoRunning(boolean bool) {
        autoRunning = bool;
    }

    public static boolean isAutoRunning() {
        return autoRunning;
    }
}
