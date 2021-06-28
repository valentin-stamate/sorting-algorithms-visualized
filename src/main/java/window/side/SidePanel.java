package window.side;

import controlP5.*;
import processing.core.PApplet;
import window.config.Controls;
import window.Panel;
import window.config.Config;
import window.config.SortingAlgorithms;
import window.config.Theme;
import window.main.MainPanel;
import window.main.sorting.colors.Color;
import window.side.events.ControlListener;

import java.util.ArrayList;
import java.util.List;

public class SidePanel extends Panel {

    private final ControlP5 cp5;
    private final List<window.side.events.ControlListener> controlListenerList;

    private final int rows = 40;
    private final int columns = 2;
    private final int rowSize;
    private final int columnSize;
    private final int padding = 10;

    private final int infoListWidth = 154;

    private final MainPanel mainPanel;

    public SidePanel(MainPanel mainPanel, PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        this.mainPanel = mainPanel;
        this.cp5 = new ControlP5(pApplet);
        this.controlListenerList = new ArrayList<>();

        this.rowSize = (height - padding * 2) / rows;
        this.columnSize = (width - padding * 2) / columns;

        initializeButtons();
    }

    @Override
    public void draw() {
        Color col = Theme.infoPanelColor;
        pApplet.fill(col.r, col.g, col.b);
        pApplet.noStroke();
        pApplet.rect(x, y, width, infoListWidth);

        drawTextLeft(String.format("Algorithm: %s", mainPanel.getAlgorithm()),
                x + columnSize * 0 + padding,
                y + rowSize * 0 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Array Size: %d", Config.arraySize),
                x + columnSize * 0 + padding,
                y + rowSize * 1 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Delay: %d", Config.delayTime),
                x + columnSize * 0 + padding,
                y + rowSize * 2 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Comparisons: %d", mainPanel.getComparisons()),
                x + columnSize * 0 + padding,
                y + rowSize * 4 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Array Accesses: %d", mainPanel.getArrayAccess()),
                x + columnSize * 0 + padding,
                y + rowSize * 5 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Swaps: %d", mainPanel.getSwaps()),
                x + columnSize * 0 + padding,
                y + rowSize * 6 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Time Complexity: %s", mainPanel.getTimeComplexity()),
                x + columnSize * 0 + padding,
                y + rowSize * 7 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft(String.format("Space Complexity: %s", mainPanel.getSpaceComplexity()),
                x + columnSize * 0 + padding,
                y + rowSize * 8 + padding + Config.FONT_SIZE, Config.FONT_SIZE);

        drawTextLeft("Created By Valentin Stamate",
                x + columnSize * 0 + padding,
                y + rowSize * 41 + padding, Config.FONT_SIZE);
    }

    private void initializeButtons() {
        final int listWidth = (int) (0.8 * width);
        final int listHeight = 240;

        final int buttonWidth = 60;
        final int buttonHeight = 20;

        final int panelCenter = x + width / 2;

        /* BUTTONS */
        cp5.addButton(Controls.PAUSE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 0 + padding, y + rowSize * 11 + padding);

        cp5.addButton(Controls.STOP)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 1 + padding + 10, y + rowSize * 11 + padding);

        cp5.addButton(Controls.SHUFFLE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 0 + padding, y + rowSize * 13 + padding);

        cp5.addButton(Controls.THEME)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 1 + padding + 10, y + rowSize * 13 + padding);

        cp5.addButton(Controls.TOGGLE_SOUND)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 0 + padding, y + rowSize * 15 + padding);

        cp5.addButton(Controls.ASCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 0 + padding, y + rowSize * 17 + padding);

        cp5.addButton(Controls.DESCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(x + columnSize * 1 + padding + 10, y + rowSize * 17 + padding);

        /* LIST */
        ListBox listBox = cp5.addListBox("Sorting Algorithms")
                .setPosition(panelCenter - (int) (1.0 * listWidth / 2), y + rowSize * 20 + padding)
                .setSize(listWidth, listHeight)
                .setItemHeight(15)
                .setBarHeight(15);

        listBox.addItems(SortingAlgorithms.SORTING_ALGORITHMS);

        /* SLIDERS */
        Slider vectorSizeSlider = cp5.addSlider(Controls.VECTOR_SIZE)
                .setRange(Config.MIN_ARRAY_SIZE, Config.MAX_ARRAY_SIZE)
                .setValue(Config.arraySize)
                .setSize(30, buttonHeight)
                .setPosition(x + columnSize * 0 + padding, y + rowSize * 38 + padding);
        vectorSizeSlider.getValueLabel().setText("" + Config.arraySize);

        Slider delaySlider = cp5.addSlider(Controls.DELAY)
                .setRange(Config.MIN_DELAY_TIME, Config.MAX_DELAY_TIME)
                .setValue(Config.delayTime)
                .setSize(30, buttonHeight)
                .setPosition(x + columnSize * 1 + padding + 10, y + rowSize * 38 + padding);
        delaySlider.getValueLabel().setText("" + Config.delayTime);

        /* LISTENER TO CONVERT FLOAT VALUES TO INT */
        /* TAKEN FROM: https://forum.processing.org/two/discussion/2905/controlp5-slider-linked-to-int-variable-doesn-t-show-some-values */
        CallbackListener callbackListener = c -> {
            Object controller = c.getController();

            if (!(controller instanceof Slider)) {
                return;
            }

            Slider slider = (Slider) c.getController();

            if(c.getAction() == ControlP5.ACTION_BROADCAST) {
                slider.getValueLabel().setText(String.format("%.0f" , slider.getValue()));
            }
        };

        vectorSizeSlider.addCallback(callbackListener);
        delaySlider.addCallback(callbackListener);

        /* REACT TO CLICKS */
        cp5.addListener((event) -> {
            for (ControlListener controlListener : controlListenerList) {
                controlListener.notify(event);
            }
        });
    }

    public void addControlListener(ControlListener controlListener) {
        controlListenerList.add(controlListener);
    }

}
