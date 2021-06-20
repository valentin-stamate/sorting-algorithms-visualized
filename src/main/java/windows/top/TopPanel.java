package windows.top;

import processing.core.PApplet;
import windows.Panel;
import windows.config.Config;
import windows.config.Theme;
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
        pApplet.textSize(Config.MAX_FONT_SIZE);
        pApplet.fill(textCol.r, textCol.g, textCol.b);
        pApplet.text(String.format("Array Size: %-7d %5s Delay: %-4s %5s Comparisons: %-7d %5s Array Access: %-7d %5s Swaps: %-7s %5s Algorithm: %s",
                Config.arraySize, "", Config.delayTime, "", mainPanel.getComparisons(), "", mainPanel.getArrayAccess(), "",
                mainPanel.getSwaps(), "", mainPanel.getAlgorithm()),
                10, 30);

        pApplet.textSize(12);
        pApplet.text("By Valentin Stamate", width - 116, 42);
    }
}
