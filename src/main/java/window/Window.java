package window;

import processing.core.PApplet;
import window.config.Size;
import window.main.MainPanel;
import window.side.SidePanel;
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
        int sidePanelWidth = 160;
        int mainPanelWidth = windowWidth - sidePanelWidth;

        Size.mainWindowHeight = windowHeight;

        MainPanel mainPanel = new MainPanel(pApplet, 0, 0, mainPanelWidth, Size.mainWindowHeight);
        SidePanel sidePanel = new SidePanel(mainPanel, pApplet, mainPanelWidth, 0, sidePanelWidth, Size.mainWindowHeight);

        mainPanel.setSidePanelEvents(sidePanel);

        this.panels.add(mainPanel);
        this.panels.add(sidePanel);
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

    public void mouseReleased() {
        for (Panel panel : panels) {
            panel.mouseReleased();
        }
    }

}
