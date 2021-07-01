package window.main;

import controlP5.ControlEvent;
import processing.core.PApplet;
import window.config.*;
import window.Panel;
import window.main.sorting.*;
import window.main.sorting.algorithms.*;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;
import window.main.sorting.input.AscendingInput;
import window.main.sorting.input.SinWaveInput;
import window.main.sorting.other.Blank;
import window.main.sorting.input.DescendingInput;
import window.main.sorting.input.ShuffleInput;
import window.side.SidePanel;

public class MainPanel extends Panel {

    private int[] vector = new int[0];
    private Color[] color = new Color[0];

    private float lineWeight = 3;

    private SortingAlgorithm sortingAlgorithm;

    public MainPanel(PApplet pApplet, int x, int y, int width, int height) {
        super(pApplet, x, y, width, height);
        resizeVector(Config.arraySize);
        sortingAlgorithm =  new Blank(pApplet, vector, color);
    }

    @Override
    public void draw() {
        Color backColor = Theme.mainPanelColor;
        pApplet.fill(backColor.r, backColor.g, backColor.b);
        pApplet.noStroke();
        pApplet.rect(x, y, width, height);

        float lineSpace = 1.0f * width / vector.length;

        for (int i = 0; i < vector.length; i++) {

            Color col = Colors.DEFAULT_LINE_COLOR;

            /* yeah, sometimes it crashed */
            try {
                col = color[i];
            } catch (Exception e) { }

            pApplet.stroke(col.r, col.g, col.b);
            if (col == Colors.DEFAULT_LINE_COLOR) {
                Color defCol = Theme.lineColor;
                pApplet.stroke(defCol.r, defCol.g, defCol.b);
            }

            pApplet.strokeWeight(lineWeight);

            int height = pApplet.height;
            float lineX = lineSpace * i + lineWeight;

            pApplet.line(lineX, height, lineX, height - vector[i]);
        }
    }

    @Override
    public void stop() {
        super.stop();

        sortingAlgorithm.stop();
    }

    @Override
    public void mouseReleased() {
        if (Config.arraySize != vector.length) {
            resizeVector(Config.arraySize);
            sortingAlgorithm = new Blank(pApplet, vector, color);
        }
    }

    /* VECTOR MANIPULATION */
    public static double mapValueToWindowSize(int windowHeight, int vectorMaxValue, int x) {
        windowHeight = windowHeight - 50;
        return (1.0 * x / vectorMaxValue) * windowHeight + 5;
    }

    public void resizeVector(int newSize) {
        vector = new int[newSize];
        color = new Color[newSize];
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            vector[i] = (int) MainPanel.mapValueToWindowSize(Size.mainWindowHeight, n - 1, i);
            color[i] = Colors.DEFAULT_LINE_COLOR;
        }

        lineWeight = (int) (1.0 * width / vector.length / 1.4);

        if (lineWeight == 0) {
            lineWeight = 1;
        }
    }

    /* AUTO MODE */
    private void loopAlgorithms() {
        new Thread(() -> {
            Config.setAutoRunning(true);

            for (String algorithm : SortingAlgorithms.SORTING_ALGORITHMS) {
                int idealVectorSize = SortingAlgorithms.idealParameters.get(algorithm)[0];
                int idealDelay = SortingAlgorithms.idealParameters.get(algorithm)[1];

                Config.delayTime = idealDelay;
                Config.arraySize = idealVectorSize;
                resizeVector(Config.arraySize);

                startInputType(InputType.SHUFFLE);
                waitTillAlgorithmStops();

                if (!Config.isAutoRunning()) {
                    break;
                }

                sleep(500);

                startAlgorithm(algorithm);
                waitTillAlgorithmStops();

                if (!Config.isAutoRunning()) {
                    break;
                }

                sleep(500);
            }

            Config.setAutoRunning(false);
        }).start();

    }

    /* USER INTERACTION */
    public void setSidePanelEvents(SidePanel sidePanel) {
        sidePanel.addControlListener((event, type) -> {
            if (type == Controls.TYPE_BUTTON) {
                onButtonPressed(event);
            }

            if (Config.isAutoRunning()) {
                return;
            }

            if (type == Controls.TYPE_INPUT_TYPE) {
                onInputTypeSelected(event);
            } else if (type == Controls.TYPE_SORTING) {
                onSortingAlgorithmSelected(event);
            } else if (type == Controls.TYPE_SLIDER) {
                onSliderValueChanged(event);
            }
        });
    }

    private void onInputTypeSelected(ControlEvent event) {
        int index = (int) event.getValue();
        String inputType = InputType.INPUT_TYPES[index];

        startInputType(inputType);
    }

    private void onSortingAlgorithmSelected(ControlEvent event) {
        int index = (int) event.getValue();
        String algorithm = SortingAlgorithms.SORTING_ALGORITHMS[index];

        startAlgorithm(algorithm);
    }

    private void onButtonPressed(ControlEvent event) {
        String buttonName = event.getName();

        startButtonPressed(buttonName);
    }

    private void startInputType(String inputType) {
        switch (inputType) {
            case InputType.SHUFFLE:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new ShuffleInput(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case InputType.ASCENDING:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new AscendingInput(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case InputType.DESCENDING:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new DescendingInput(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case InputType.SIN_WAVE:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new SinWaveInput(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
        }

        sleep(10);
    }

    private void startAlgorithm(String algorithm) {
        switch (algorithm) {
            case SortingAlgorithms.BUBBLE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new BubbleSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.INSERTION_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new InsertionSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.SELECTION_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new SelectionSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.SHELL_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new ShellSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.QUICK_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new QuickSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.RADIX_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new RadixSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.MERGE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new MergeSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.GNOME_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new GnomeSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.HEAP_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new HeapSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.PIGEONHOLE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new PigeonholeSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.COUNTING_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new CountingSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.COCKTAIL_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new CocktailSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.ODD_EVEN_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new OddEvenSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.GRAVITY_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new GravitySort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.IN_PLACE_MERGE_SORT_ONE:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new InPlaceMergeSortOne(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.IN_PLACE_MERGE_SORT_TWO:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new InPlaceMergeSortTwo(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.BITONIC_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                int currentSize = Config.arraySize;

                /* IF IT'S NOT POWER OF TWO */
                if ((currentSize & (currentSize - 1)) != 0) {
                    int newSize = 1;
                    while (newSize * 2 <= currentSize) {
                        newSize *= 2;
                    }

                    Config.arraySize = newSize;

                    resizeVector(newSize);
                    return;
                }

                sortingAlgorithm = new BitonicSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.CIRCLE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new CircleSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.BOGO_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new BogoSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.CYCLE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new CycleSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.SMOOTH_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new SmoothSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.COMB_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new CombSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
            case SortingAlgorithms.ITERATIVE_MERGE_SORT:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                sortingAlgorithm = new IterativeMergeSort(pApplet, vector, color);
                sortingAlgorithm.start();
                break;
        }

        sleep(10);
    }

    private void startButtonPressed(String buttonName) {
        switch (buttonName) {
            case Controls.TOGGLE_SOUND:
                Config.sound = !Config.sound;
                break;
            case Controls.STOP:
                sortingAlgorithm.stop();
                Config.setAutoRunning(false);
                break;
            case Controls.THEME:
                Theme.currentTheme = Theme.currentTheme == Theme.LIGHT_THEME ?
                        Theme.DARK_THEME : Theme.LIGHT_THEME;

                Theme.refreshTheme();
                break;
            case Controls.PAUSE:
                sortingAlgorithm.togglePause();
                break;
            case Controls.AUTO:
                if (!Config.isAutoRunning()) {
                    loopAlgorithms();
                }
                break;
            default:
                break;
        }
    }

    private void onSliderValueChanged(ControlEvent event) {
        String sliderName = event.getName();
        int sliderValue = (int) event.getValue();

        switch (sliderName) {
            case Controls.VECTOR_SIZE:
                if (sortingAlgorithm.isRunning()) {
                    return;
                }

                Config.arraySize = sliderValue;
                break;
            case Controls.DELAY:
                Config.delayTime = sliderValue;
                break;
            default:
                break;
        }
    }

    /* UTIL */
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitTillAlgorithmStops() {
        while (sortingAlgorithm.isRunning()) {
            sleep(200);
        }
    }

    /* GETTERS AND SETTERS */
    public int getComparisons() {
        return sortingAlgorithm.getComparisons();
    }

    public int getArrayAccess() {
        return sortingAlgorithm.getArrayAccess();
    }

    public String getAlgorithm() {
        return sortingAlgorithm.getAlgorithm();
    }

    public int getSwaps() {
        return sortingAlgorithm.getSwaps();
    }

    public String getTimeComplexity() {
        return sortingAlgorithm.getTimeComplexity();
    }

    public String getSpaceComplexity() {
        return sortingAlgorithm.getSpaceComplexity();
    }
}
