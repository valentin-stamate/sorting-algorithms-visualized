import processing.core.PApplet;
import windows.Window;

public class MainClass extends PApplet {

    public void settings() {
        size(1520, 600, P2D);
    }

    public void setup() {
        background(25);
        frameRate(60);

        surface.setTitle("Sorting Algorithms Visualized");
//        surface.setResizable(true);

        strokeCap(SQUARE);
        shapeMode(CENTER);

        Window window = new Window(this);
        window.addComponents();
        window.start();
    }

    @Override
    public void draw() {
        background(10);
    }

    public static void main(String... args){
        PApplet.main("MainClass");
    }
}