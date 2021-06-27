package window;

import processing.core.PApplet;
import window.config.Theme;
import window.main.sorting.colors.Color;

public abstract class Panel {
    protected final int width;
    protected final int height;
    protected final int x;
    protected final int y;
    protected final PApplet pApplet;

    public Panel(PApplet pApplet, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        this.pApplet = pApplet;
    }

    public abstract void draw();

    public void start() {
        pApplet.registerMethod("draw", this);
    }

    public void stop() {
        pApplet.unregisterMethod("draw", this);
    }

    public void mouseReleased() { }

    /* TEXT DRAWING */
    protected void drawTextCenter(String text, int x, int y, int fontSize) {
        pApplet.textAlign(pApplet.CENTER);
        drawText(text, x, y, fontSize);
    }

    protected void drawTextLeft(String text, int x, int y, int fontSize) {
        pApplet.textAlign(pApplet.LEFT);
        drawText(text, x, y, fontSize);
    }

    private void drawText(String text, int x, int y, int fontSize) {
        Color textCol = Theme.textColor;
        pApplet.textSize(fontSize);
        pApplet.fill(textCol.r, textCol.g, textCol.b);
        pApplet.text(text,x, y);
    }
}
