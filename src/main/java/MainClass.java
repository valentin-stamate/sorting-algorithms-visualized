import processing.core.PApplet;
import processing.core.PFont;
import windows.Window;

public class MainClass extends PApplet {

    public void settings() {
        size(1520, 600, P2D);
    }

    public void setup() {
        background(25);
        frameRate(60);

        PFont font36 = createFont("Arial", 36);
        textFont(font36);
        surface.setTitle("Sorting Algorithms Visualized");

        strokeCap(SQUARE);
        shapeMode(CENTER);

        Window window = new Window(this);
        window.addComponents();
        window.start();
    }

    @Override
    public void draw() {
        background(15);
    }

    public static void main(String... args){
        PApplet.main("MainClass");
    }
}