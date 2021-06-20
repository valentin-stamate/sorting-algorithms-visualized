package windows;

import processing.core.PApplet;

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
}
