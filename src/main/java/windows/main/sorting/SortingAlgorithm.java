package windows.main.sorting;

public abstract class SortingAlgorithm implements Runnable {

    protected int[] vector;
    protected int[] color;

    protected boolean pause = false;
    protected boolean stop = false;
    protected int sleepTime = 10;

    public SortingAlgorithm(int[] vector, int[] color) {
        this.vector = vector;
        this.color = color;
    }

    public void start() {
        stop = false;
        pause = false;

        Thread thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    public void stop() {
        stop = true;
    }

    protected void swap(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    protected void setColor(int i, int color) {
        this.color[i] = color;
    }

    protected void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
