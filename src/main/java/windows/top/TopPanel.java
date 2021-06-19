package windows.top;

import processing.core.PApplet;
import windows.Panel;
import windows.Theme;
import windows.main.MainPanel;
import windows.main.sorting.colors.Color;

public class TopPanel extends Panel {

    private final MainPanel mainPanel;

    public TopPanel(PApplet pApplet, MainPanel mainPanel, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        this.mainPanel = mainPanel;
    }

    @Override
    public void draw() {
        pApplet.fill(panelColor);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);

        Color textCol = Theme.TEXT_COLOR;
        pApplet.textSize(16);
        pApplet.fill(textCol.r, textCol.g, textCol.b);
        pApplet.text(String.format("Array Size: %-7d Comparisons: %-7d %5s Array Access: %-7d %5s Algorithm: %s",
                mainPanel.getVectorSize(), mainPanel.getComparisons(), "", mainPanel.getArrayAccess(), "",
                mainPanel.getAlgorithm()), 10, 30);

        pApplet.textSize(12);
        pApplet.text("By Valentin Stamate", width - 116, 42);
    }
}
