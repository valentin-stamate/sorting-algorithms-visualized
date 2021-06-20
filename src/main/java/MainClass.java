import processing.core.PApplet;
import processing.core.PFont;
import windows.Window;
import windows.config.Config;
import windows.config.Theme;
import windows.main.sorting.colors.Color;

public class MainClass extends PApplet {

    private Window window;

    public void settings() {
        size(1520, 640, P2D);
    }

    public void setup() {
        background(25);
        frameRate(60);

        PFont font36 = createFont("Arial", Config.MAX_FONT_SIZE);
        textFont(font36);
        surface.setTitle("Sorting Algorithms Visualized");

        strokeCap(SQUARE);
        shapeMode(CENTER);

        window = new Window(this);
        window.addComponents();
        window.start();
    }

    @Override
    public void draw() {
        Color backCol = Theme.backgroundColor;
        background(backCol.r, backCol.g, backCol.b);
    }

    /* TODO: make this work */
    @Override
    public void stop() {
        window.stop();
        System.out.println("Sketch closed");
    }

    @Override
    public void mouseReleased() {
        window.mouseReleased();
    }

    public static void main(String... args){
        PApplet.main("MainClass");
    }
}