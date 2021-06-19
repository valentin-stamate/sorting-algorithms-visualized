package windows;

import processing.core.PApplet;
import windows.main.MainPanel;
import windows.side.SidePanel;
import windows.top.TopPanel;

import java.util.ArrayList;
import java.util.List;

/* THE MAIN WINDOW CLASS THAT BUILDS ... WELL THE WINDOW */
public class Window {
    private int windowWidth;
    private int windowHeight;

    private final PApplet pApplet;

    private final List<Panel> panels;

    public Window(PApplet pApplet) {
        this.windowWidth = pApplet.width;
        this.windowHeight = pApplet.height;
        this.pApplet = pApplet;

        this.panels = new ArrayList<>();

        pApplet.registerMethod("pre", this);
    }

    public void addComponents() {
        int mainPanelPercentage = 95;
        int sidePanelPercentage = 5;

        int mainPanelWidth = (int)(1.0 * mainPanelPercentage / 100 * windowWidth);
        int sidePanelWidth = (int)(1.0 * sidePanelPercentage / 100 * windowWidth);

        int topPanelHeight = 50;

        MainPanel mainPanel = new MainPanel(pApplet, 0, topPanelHeight, mainPanelWidth, windowHeight - topPanelHeight);
        TopPanel topPanel = new TopPanel(pApplet, mainPanel, 0, 0, mainPanelWidth, topPanelHeight);
        SidePanel sidePanel = new SidePanel(pApplet, mainPanelWidth, 0, sidePanelWidth, windowHeight);

        mainPanel.setSidePanelEvents(sidePanel);

        mainPanel.setColor(20);
        sidePanel.setColor(10);
        topPanel.setColor(30);

        this.panels.add(mainPanel);
        this.panels.add(sidePanel);
        this.panels.add(topPanel);
    }

    /* TODO: maybe resize the window */
    public void pre() {
        if (pApplet.width != windowWidth || pApplet.height != windowHeight) {
            windowWidth = pApplet.width;
            windowHeight = pApplet.height;
            System.out.println("resize");
        }
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
