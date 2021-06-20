import processing.core.PApplet;
import processing.core.PFont;
import processing.sound.SinOsc;
import windows.Window;
import windows.config.Config;

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
        background(15);
    }

    /* TODO: make this work */
    @Override
    public void stop() {
        window.stop();
        System.out.println("Sketch closed");
    }

    public static void main(String... args){
        PApplet.main("MainClass");
    }
}