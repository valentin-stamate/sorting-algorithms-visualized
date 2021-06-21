package windows.side;

import controlP5.*;
import processing.core.PApplet;
import windows.config.Buttons;
import windows.Panel;
import windows.config.Config;
import windows.side.events.ControlListener;

import java.util.ArrayList;
import java.util.List;

public class SidePanel extends Panel {

    private final ControlP5 cp5;
    private final List<windows.side.events.ControlListener> controlListenerList;

    private final int center;
    private final int positionA;
    private final int positionB;

    private final int panelCenter;

    private final int buttonWidth = 60;
    private final int buttonHeight = 20;
    private final int margin = 10;
    private final int textOffset = 30;
    final int buttonSpace = buttonHeight + 10;

    public SidePanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        this.cp5 = new ControlP5(pApplet);
        this.controlListenerList = new ArrayList<>();

        center = x + (width - buttonWidth) / 2;
        positionA = x + (width - buttonWidth * 2) / 3;
        positionB = positionA + buttonWidth + margin;

        panelCenter = x + width / 2;

        initializeButtons();
    }

    @Override
    public void draw() {
        drawTextCenter("O(n^2)", panelCenter, buttonSpace * 2 + textOffset, 12);
        drawTextCenter("O(n log(n))", panelCenter, buttonSpace * 7 + textOffset, 12);
        drawTextCenter("~O(n)", panelCenter, buttonSpace * 10 + textOffset, 12);
    }

    private void initializeButtons() {
        cp5.addButton(Buttons.PAUSE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, margin);

        cp5.addButton(Buttons.STOP)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, margin);

        cp5.addButton(Buttons.SHUFFLE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(center, buttonSpace + margin);

        cp5.addButton(Buttons.ASCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 3 + margin);

        cp5.addButton(Buttons.DESCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 3 + margin);

        cp5.addButton(Buttons.BUBBLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 5 + margin);

        cp5.addButton(Buttons.INSERTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 5 + margin);

        cp5.addButton(Buttons.SELECTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 6 + margin);

        cp5.addButton(Buttons.QUICK_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 8 + margin);

        cp5.addButton(Buttons.RADIX_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 8 + margin);

        cp5.addButton(Buttons.MERGE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 9 + margin);

        cp5.addButton(Buttons.HEAP_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 9 + margin);

        cp5.addButton(Buttons.COUNTING_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 11 + margin);

        cp5.addButton(Buttons.PIGEONHOLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 11 + margin);

        cp5.addButton(Buttons.THEME)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionA, buttonSpace * 19 + margin);

        cp5.addButton(Buttons.TOGGLE_SOUND)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(positionB, buttonSpace * 19 + margin);

        Slider vectorSizeSlider = cp5.addSlider(Buttons.VECTOR_SIZE)
                .setRange(Config.MIN_ARRAY_SIZE, Config.MAX_ARRAY_SIZE)
                .setValue(Config.arraySize)
                .setSize(30, buttonHeight)
                .setPosition(positionA, buttonSpace * 20 + margin);
        vectorSizeSlider.getValueLabel().setText("" + Config.arraySize);

        Slider delaySlider = cp5.addSlider(Buttons.DELAY)
                .setRange(Config.MIN_DELAY_TIME, Config.MAX_DELAY_TIME)
                .setValue(Config.delayTime)
                .setSize(30, buttonHeight)
                .setPosition(positionB, buttonSpace * 20 + margin);
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

        /* REACT TO BUTTON CLICK */
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
