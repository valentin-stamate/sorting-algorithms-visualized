package windows;

import processing.core.PApplet;
import windows.main.MainPanel;
import windows.side.SidePanel;
import java.util.ArrayList;
import java.util.List;

/* THE MAIN WINDOW CLASS THAT BUILDS ... WELL THE WINDOW */
public class Window {
    private final int windowWidth;
    private final int windowHeight;

    private final PApplet pApplet;

    private final List<Panel> panels;

    public Window(PApplet pApplet) {
        this.windowWidth = pApplet.width;
        this.windowHeight = pApplet.height;
        this.pApplet = pApplet;

        this.panels = new ArrayList<>();
    }

    public void addComponents() {
        int mainPanelPercentage = 75;
        int sidePanelPercentage = 25;

        int mainPanelWidth = (int)(1.0 * mainPanelPercentage / 100 * windowWidth);
        int sidePanelWidth = (int)(1.0 * sidePanelPercentage / 100 * windowWidth);

        MainPanel mainPanel = new MainPanel(pApplet, 0, 0, mainPanelWidth, windowHeight);
        SidePanel sidePanel = new SidePanel(pApplet, mainPanelWidth, 0, sidePanelWidth, windowHeight);

        sidePanel.setColor(10);

        this.panels.add(mainPanel);
        this.panels.add(sidePanel);
    }

    public void start() {
        for (Panel panel : panels) {
            panel.start();
        }
    }

    public void stop() {
        for (Panel panel : panels) {
            panel.stop();
        }
    }

}
