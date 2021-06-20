package windows.side;

import controlP5.ControlEvent;

@FunctionalInterface
public interface ControlListener {
    void notify(ControlEvent event);
}
