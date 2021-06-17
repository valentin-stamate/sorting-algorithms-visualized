package windows.side;

import processing.core.PApplet;
import windows.Panel;

public class SidePanel extends Panel {

    public SidePanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);

    }

    @Override
    public void draw() {
        pApplet.fill(panelColor);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);
    }
}
