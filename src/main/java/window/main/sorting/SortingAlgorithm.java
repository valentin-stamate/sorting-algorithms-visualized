package window.main.sorting;

import processing.core.PApplet;
import processing.sound.TriOsc;
import window.config.Config;
import window.config.InputType;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;
import java.util.ArrayList;
import java.util.Date;
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

    private final String algorithm;
    private final String timeComplexity;
    private final String spaceComplexity;

    private final List<TriOsc> oscList;
    private final boolean[] soundPlaying;

    public SortingAlgorithm(PApplet pApplet, int[] vector, Color[] color, String algorithm, String timeComplexity, String spaceComplexity) {
        this.pApplet = pApplet;
        this.vector = vector;
        this.color = color;
        this.algorithm = algorithm;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
        this.oscList = new ArrayList<>();
        this.soundPlaying = new boolean[6];

        for (int i = 0; i < 6; i++) {
            oscList.add(new TriOsc(pApplet));
        }

    }

    @Override
    public abstract void run();

    /* VECTOR CHANGING METHODS */
    protected void swap(int i, int j) {
        /* ANIMATION AND SOUND */
        setColor(i, Colors.CURRENT_INDEX);
        setColor(j, Colors.SWAPPING_INDEX);
        playSound(i);
        playSound(j);

        sleep();

        stopSound();

        while (pause) {
            if (stop) {
                return;
            }
            sleep(Config.PAUSE_DELAY_TIME);
        }

        resetColor(i);
        resetColor(j);

        /* THE ACTUAL SWAP */
        swapWithNoEffects(i, j);

        /* UPDATING PARAMETERS */
        arrayAccess += 4;
        swaps++;
    }

    protected void animateIndex(int index) {
        setColor(index, Colors.ITERATION_COLOR);
        playSound(index);
        sleep();
        stopSound();

        while (pause) {
            if (stop) {
                return;
            }
            sleep(Config.PAUSE_DELAY_TIME);
        }

        resetColor(index);
    }

    protected void swapWithNoEffects(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;

        arrayAccess += 4;
        swaps++;
    }

    /* TODO: see if it's worth using these */
    protected void changeVectorIndex(int index, int changingIndex) {
        vector[index] = vector[changingIndex];
        arrayAccess += 2;
    }

    protected void changeVectorValue(int index, int value) {
        vector[index] = value;
        arrayAccess++;
    }

    /* UTIL */
    protected void sleep() {
        int delayTime = Config.delayTime;

        /* UPDATE DELAY TIME TO HAVE A CONSTANT LOOP TIME*/
        if (algorithm.equals(InputType.SHUFFLE) ||
                algorithm.equals(InputType.ASCENDING) ||
                algorithm.equals(InputType.DESCENDING) ||
                algorithm.equals(InputType.SIN_WAVE)) {

            int rd = ((int) (Math.random() * 1000));

            if (rd % 3 == 0) {
                return;
            }

            delayTime = getSleepTimeForOneIteration();
        }

        sleep(delayTime);
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getSleepTimeForOneIteration() {
        return (int) Math.ceil(1000.0 / Config.arraySize);
    }

    protected void playSound(int index) {
        int value = vector[index];
        if (!Config.sound) {
            return;
        }

        int freq = (int) (2 * Math.pow(value, 0.92)) + 50;

        playFreq(freq);
        playFreq(freq + 5);
        playFreq(freq + 10);
    }

    private void playFreq(int freq) {
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

    protected void playFinalAnimation() {
        if (algorithm.equals(InputType.SHUFFLE) ||
            algorithm.equals(InputType.ASCENDING) ||
            algorithm.equals(InputType.DESCENDING) ||
            algorithm.equals(InputType.SIN_WAVE)) {
            return;
        }

        int n = vector.length;
        int delay = getSleepTimeForOneIteration();

        for (int i = 0; i < n; i++) {
            setColor(i, Colors.CURRENT_INDEX);
            playSound(i);

            if (delay == 1 && i % 3 != 0) {
                stopSound();
                continue;
            }

            sleep(delay);
            stopSound();
        }

        for (int i = 0; i < n; i++) {
            resetColor(i);
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
        if (!stop) {
            playFinalAnimation();
        }

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

    public boolean isStopped() {
        return stop;
    }

    public void togglePause() {
        pause = !pause;
    }

    /* GETTERS AND SETTERS */
    protected void setColor(int i, Color color) {
        this.color[i] = color;
    }

    protected void resetColor(int i) {
        this.color[i] = Colors.DEFAULT_LINE_COLOR;
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

    protected int getMax() {
        int max = vector[0];
        for (int j : vector) {
            max = Math.max(max, j);
        }

        return max;
    }

    protected int getMin() {
        int min = vector[0];
        for (int j : vector) {
            min = Math.min(min, j);
        }

        return min;
    }

    protected boolean isSorted() {
        for (int i = 0; i < vector.length - 2; i++) {
            if (vector[i] > vector[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public String getTimeComplexity() {
        return timeComplexity;
    }

    public String getSpaceComplexity() {
        return spaceComplexity;
    }
}
