package windows.side;

import controlP5.*;
import processing.core.PApplet;
import windows.Buttons;
import windows.Panel;
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
        final int buttonPosition = x + (width - buttonWidth) / 2;

        cp5.addButton(Buttons.PAUSE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace);

        cp5.addButton(Buttons.SHUFFLE)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 2);

        cp5.addButton(Buttons.ASCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 4);

        cp5.addButton(Buttons.DESCENDING)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 5);

        cp5.addButton(Buttons.BUBBLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 7);

        cp5.addButton(Buttons.INSERTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 8);

        cp5.addButton(Buttons.SELECTION_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 9);

        cp5.addButton(Buttons.QUICK_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 10);

        cp5.addButton(Buttons.RADIX_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 11);

        cp5.addButton(Buttons.MERGE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 12);

        cp5.addButton(Buttons.HEAP_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 13);

        cp5.addButton(Buttons.PIGEONHOLE_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 14);

        cp5.addButton(Buttons.COUNTING_SORT)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 15);

        cp5.addButton(Buttons.THEME)
                .setSize(buttonWidth, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 17);

        Slider vectorSizeSlider = cp5.addSlider(Buttons.VECTOR_SIZE)
                .setRange(100, 1024)
                .setValue(128)
                .setSize(30, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 18);
        vectorSizeSlider.getValueLabel().setText("128");

        Slider delaySlider = cp5.addSlider(Buttons.DELAY)
                .setRange(1, 50)
                .setValue(20)
                .setSize(30, buttonHeight)
                .setPosition(buttonPosition, buttonSpace * 19);
        delaySlider.getValueLabel().setText("20");

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
            String controlName = event.getName();
            int controlValue = (int) event.getValue();
            Object instance = event.getController();

            for (ControlListener controlListener : controlListenerList) {
                controlListener.notify(controlName, controlValue);
            }
        });
    }

    public void addControlListener(ControlListener controlListener) {
        controlListenerList.add(controlListener);
    }

}
