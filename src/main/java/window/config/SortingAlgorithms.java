package window.config;

import java.util.HashMap;
import java.util.Map;

public class SortingAlgorithms {

    public final static String BUBBLE_SORT = "Bubble Sort";
    public final static String INSERTION_SORT = "Insertion Sort";
    public final static String SELECTION_SORT = "Selection Sort";
    public final static String COCKTAIL_SORT = "Cocktail Sort";
    public final static String ODD_EVEN_SORT = "Odd-Even Sort";
    public final static String GNOME_SORT = "Gnome Sort";
    public final static String COMB_SORT = "Comb Sort";
    public final static String CIRCLE_SORT = "Circle Sort";
    public final static String CYCLE_SORT = "Cycle Sort";
    public final static String SMOOTH_SORT = "Smooth Sort";
    public final static String SHELL_SORT = "Shell Sort";
    public final static String QUICK_SORT = "Quick Sort";
    public final static String RADIX_SORT = "Radix Sort";
    public final static String MERGE_SORT = "Merge Sort";
    public final static String ITERATIVE_MERGE_SORT = "Iterative Merge Sort";
    public final static String IN_PLACE_MERGE_SORT_ONE = "In Place Merge 1 Sort";
    public final static String IN_PLACE_MERGE_SORT_TWO = "In Place Merge 2 Sort";
    public final static String HEAP_SORT = "Heap Sort";
    public final static String BITONIC_SORT = "Bitonic Sort";
    public final static String COUNTING_SORT = "Counting Sort";
    public final static String PIGEONHOLE_SORT = "Pigeonhole Sort";
    public final static String GRAVITY_SORT = "Gravity Sort";
    public final static String BOGO_SORT = "Bogo Sort";

    public final static String[] SORTING_ALGORITHMS = new String[] {
            BUBBLE_SORT,
            ODD_EVEN_SORT,
            INSERTION_SORT,
            SELECTION_SORT,
            COCKTAIL_SORT,
            GNOME_SORT,
            COMB_SORT,
            CIRCLE_SORT,
            CYCLE_SORT,
            SMOOTH_SORT,
            SHELL_SORT,
            QUICK_SORT,
            RADIX_SORT,
            MERGE_SORT,
            ITERATIVE_MERGE_SORT,
            IN_PLACE_MERGE_SORT_ONE,
            IN_PLACE_MERGE_SORT_TWO,
            HEAP_SORT,
            BITONIC_SORT,
            COUNTING_SORT,
            PIGEONHOLE_SORT,
            GRAVITY_SORT,
            BOGO_SORT
    };

    public static final Map<String, int[]> idealParameters = new HashMap<>() {{
        put(BUBBLE_SORT,             new int[]{220, 1});
        put(ODD_EVEN_SORT,           new int[]{220, 1});
        put(INSERTION_SORT,          new int[]{220, 1});
        put(SELECTION_SORT,          new int[]{220, 1});
        put(COCKTAIL_SORT,           new int[]{220, 1});
        put(GNOME_SORT,              new int[]{220, 1});
        put(COMB_SORT,               new int[]{1500, 3});
        put(CIRCLE_SORT,             new int[]{1000, 3});
        put(CYCLE_SORT,              new int[]{2048, 4});
        put(SMOOTH_SORT,             new int[]{700, 1});
        put(SHELL_SORT,              new int[]{1600, 1});
        put(QUICK_SORT,              new int[]{2048, 1});
        put(RADIX_SORT,              new int[]{1000, 1});
        put(MERGE_SORT,              new int[]{1500, 1});
        put(ITERATIVE_MERGE_SORT,    new int[]{1500, 1});
        put(IN_PLACE_MERGE_SORT_ONE, new int[]{1500, 1});
        put(IN_PLACE_MERGE_SORT_TWO, new int[]{1500, 1});
        put(HEAP_SORT,               new int[]{1500, 1});
        put(BITONIC_SORT,            new int[]{2048, 1});
        put(COUNTING_SORT,           new int[]{2048, 2});
        put(PIGEONHOLE_SORT,         new int[]{2048, 2});
        put(GRAVITY_SORT,            new int[]{2048, 3});
        put(BOGO_SORT,               new int[]{128, 70});
    }};

}
