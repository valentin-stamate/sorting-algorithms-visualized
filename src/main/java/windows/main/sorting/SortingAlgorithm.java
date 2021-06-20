package windows.main.sorting;

import processing.core.PApplet;
import processing.sound.TriOsc;
import windows.main.sorting.colors.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithm implements Runnable {

    protected int[] vector;
    protected Color[] color;

    private final PApplet pApplet;

    protected boolean pause = false;
    protected boolean stop = false;
    protected int sleepTime = 10;

    protected int comparisons;
    protected int arrayAccess;
    protected int swaps;
    protected final String algorithm;

    private final List<TriOsc> oscList;
    private final boolean[] isPlaying;

    public SortingAlgorithm(PApplet pApplet, int[] vector, Color[] color, String algorithm) {
        this.pApplet = pApplet;
        this.vector = vector;
        this.color = color;
        this.algorithm = algorithm;
        this.oscList = new ArrayList<>();
        this.isPlaying = new boolean[5];

        for (int i = 0; i < 5; i++) {
            oscList.add(new TriOsc(pApplet));
        }

    }

    public void start() {
        stop = false;
        pause = false;

        Thread thread = new Thread(this);
        thread.start();
    }

    /* UTIL */
    protected void swap(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;

        arrayAccess += 4;
        swaps++;
    }

    protected void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void playSound(int value) {
        int freq = (int) (15 * Math.sqrt(value));

        int n = oscList.size();
        for (int i = 0; i < n; i++) {
            if (isPlaying[i]) {
                continue;
            }

            TriOsc triOsc = oscList.get(i);
            triOsc.freq(freq);
            triOsc.play();

            isPlaying[i] = true;
            return;
        }

        System.out.println("No more channels");
    }

    protected void stopSound() {
        for (int i = 0; i < oscList.size(); i++) {
            oscList.get(i).stop();
            isPlaying[i] = false;
        }
    }

    /* CONTROL */
    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    public void stop() {
        stop = true;
        stopSound();
    }

    /* GETTERS AND SETTERS */
    protected void setColor(int i, Color color) {
        this.color[i] = color;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getArrayAccess() {
        return arrayAccess;
    }

    public int getSwaps() {
        return swaps;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
