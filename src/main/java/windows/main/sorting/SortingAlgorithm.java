package windows.main.sorting;

import processing.core.PApplet;
import processing.sound.TriOsc;
import windows.config.Config;
import windows.main.sorting.colors.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithm implements Runnable {

    protected int[] vector;
    protected Color[] color;

    private final PApplet pApplet;

    protected boolean pause = false;
    protected boolean stop = false;
    protected boolean running = false;

    protected int comparisons;
    protected int arrayAccess;
    protected int swaps;
    protected final String algorithm;

    private final List<TriOsc> oscList;
    private final boolean[] soundPlaying;

    public SortingAlgorithm(PApplet pApplet, int[] vector, Color[] color, String algorithm) {
        this.pApplet = pApplet;
        this.vector = vector;
        this.color = color;
        this.algorithm = algorithm;
        this.oscList = new ArrayList<>();
        this.soundPlaying = new boolean[5];

        for (int i = 0; i < 5; i++) {
            oscList.add(new TriOsc(pApplet));
        }

    }

    /* UTIL */
    synchronized protected void swap(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;

        arrayAccess += 4;
        swaps++;
    }

    protected void sleep() {
        try {
            Thread.sleep(Config.delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void playSound(int value) {
        int freq = (int) (15 * Math.sqrt(value));

        int n = oscList.size();
        for (int i = 0; i < n; i++) {
            if (soundPlaying[i]) {
                continue;
            }

            TriOsc triOsc = oscList.get(i);
            triOsc.freq(freq);
            triOsc.play();

            soundPlaying[i] = true;
            return;
        }

        System.out.println("No more channels");
    }

    protected void stopSound() {
        for (int i = 0; i < oscList.size(); i++) {
            oscList.get(i).stop();
            soundPlaying[i] = false;
        }
    }

    /* CONTROL */
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    protected void onAlgorithmStart() {
        stop = false;
        pause = false;
        running = true;
    }

    protected void onAlgorithmStops() {
        stop = false;
        pause = false;
        running = false;
    }

    public void stop() {
        /* THIS IN ORDER TO STOP THE THREADS */
        stop = true;

        pause = false;
        running = false;

        stopSound();
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
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

    public boolean isRunning() {
        return running;
    }

}
