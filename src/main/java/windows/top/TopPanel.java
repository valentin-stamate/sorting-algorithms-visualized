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
        Color backCol = Theme.topPanelColor;
        pApplet.fill(backCol.r, backCol.g, backCol.b);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);

        drawTextLeft(String.format("Array Size: %-7d %5s Delay: %-4s %5s Comparisons: %-7d %5s Array Access: %-7d %5s Swaps: %-7s %5s Algorithm: %s",
                Config.arraySize, "", Config.delayTime, "", mainPanel.getComparisons(), "", mainPanel.getArrayAccess(), "",
                mainPanel.getSwaps(), "", mainPanel.getAlgorithm()), 10, 30, Config.MAX_FONT_SIZE);

        drawTextLeft("By Valentin Stamate", width - 116, 42, 12);
    }
}
