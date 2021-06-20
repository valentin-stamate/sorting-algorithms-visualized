package windows.side;

import controlP5.*;
import processing.core.PApplet;
import windows.config.Buttons;
import windows.Panel;
import windows.config.Config;

import java.util.ArrayList;
import java.util.List;

public class SidePanel extends Panel {

    private final ControlP5 cp5;
    private final List<ControlListener> controlListenerList;

    public SidePanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        this.cp5 = new ControlP5(pApplet);
        this.controlListenerList = new ArrayList<>();
        initializeButtons();
    }

    @Override
    public void draw() { }

    private void initializeButtons() {
        final int buttonWidth = 60;
        final int buttonHeight = 20;
        final int buttonSpace = buttonHeight + 10;
        final int marginTop = 10;
        final int buttonPosition = x + (width - buttonWidth) / 2;

        cp5.addButton(Buttons.PAUSE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, marginTop);

        cp5.addButton(Buttons.STOP)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace + marginTop);

        cp5.addButton(Buttons.SHUFFLE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 2 + marginTop);

        cp5.addButton(Buttons.ASCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 4 + marginTop);

        cp5.addButton(Buttons.DESCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 5 + marginTop);

        cp5.addButton(Buttons.BUBBLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 7 + marginTop);

        cp5.addButton(Buttons.INSERTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 8 + marginTop);

        cp5.addButton(Buttons.SELECTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 9 + marginTop);

        cp5.addButton(Buttons.QUICK_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 10 + marginTop);

        cp5.addButton(Buttons.RADIX_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 11 + marginTop);

        cp5.addButton(Buttons.MERGE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 12 + marginTop);

        cp5.addButton(Buttons.HEAP_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 13 + marginTop);

        cp5.addButton(Buttons.PIGEONHOLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 14 + marginTop);

        cp5.addButton(Buttons.COUNTING_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 15 + marginTop);

        cp5.addButton(Buttons.THEME)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 17 + marginTop);

        cp5.addButton(Buttons.TOGGLE_SOUND)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 18 + marginTop);

        Slider vectorSizeSlider = cp5.addSlider(Buttons.VECTOR_SIZE)
                .setRange(Config.MIN_ARRAY_SIZE, Config.MAX_ARRAY_SIZE)
                .setValue(Config.arraySize)
                .setSize(30, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 19 + marginTop);
        vectorSizeSlider.getValueLabel().setText("" + Config.arraySize);

        Slider delaySlider = cp5.addSlider(Buttons.DELAY)
                .setRange(Config.MAX_DELAY_TIME, Config.MAX_DELAY_TIME)
                .setValue(Config.delayTime)
                .setSize(30, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 20 + marginTop);
        delaySlider.getValueLabel().setText("" + Config.delayTime);

        /* LISTENER TO CONVERT FLOAT VALUES TO INT */
        /* TAKEN FROM: https://forum.processing.org/two/discussion/2905/controlp5-slider-linked-to-int-variable-doesn-t-show-some-values */
        CallbackListener callbackListener = c -> {
            Object controller = c.getController();

            if (!(controller instanceof Slider)) {
                return;
            }

            Slider slider = (Slider) c.getController();

            if(c.getAction()==ControlP5.ACTION_BROADCAST) {
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
