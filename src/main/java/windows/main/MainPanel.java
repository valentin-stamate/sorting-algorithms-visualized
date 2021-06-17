package windows.main;

import processing.core.PApplet;
import windows.Panel;

public class MainPanel extends Panel {

    public MainPanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
    }

    @Override
    public void draw() {
        pApplet.fill(panelColor);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);
    }
}
