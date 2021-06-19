package windows.side;

@FunctionalInterface
public interface ControlListener {
    void notify(String name, int value);
}
