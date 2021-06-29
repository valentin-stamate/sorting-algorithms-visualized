package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class SmoothSort extends SortingAlgorithm {
    /* LEONARDO NUMBERS */
    static final int[] LP = { 1, 1, 3, 5, 9, 15, 25, 41, 67, 109,
            177, 287, 465, 753, 1219, 1973, 3193, 5167, 8361, 13529, 21891,
            35421, 57313, 92735, 150049, 242785, 392835, 635621, 1028457,
            1664079, 2692537, 4356617, 7049155, 11405773, 18454929, 29860703,
            48315633, 78176337, 126491971, 204668309, 331160281, 535828591,
            866988873
    };

    public SmoothSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Smooth Sort", "nlog(n)", "O(1)");
    }

    @Override
    public void run() {
        onAlgorithmStart();

        smoothSort(0, vector.length - 1);

        onAlgorithmStops();
    }


    private void smoothSort(int lo, int hi) {
        int head = lo;

        int p = 1;
        int pshift = 1;

        while (head < hi) {
            if (stop) {
                return;
            }

            setColor(head, Colors.PIVOT_COLOR);

            if ((p & 3) == 3) {

                sift(pshift, head);
                p >>>= 2;
                pshift += 2;
            } else {

                if (LP[pshift - 1] >= hi - head) {
                    trinkle(p, pshift, head, false);
                } else {
                    sift(pshift, head);
                }

                if (pshift == 1) {
                    p <<= 1;
                    pshift--;
                } else {
                    p <<= (pshift - 1);
                    pshift = 1;
                }
            }

            p |= 1;

            resetColor(head);
            head++;
        }

        trinkle(p, pshift, head, false);

        while (pshift != 1 || p != 1) {
            if (stop) {
                return;
            }

            if (pshift <= 1) {
                int trail = Integer.numberOfTrailingZeros(p & ~1);
                p >>>= trail;
                pshift += trail;
            } else {
                p <<= 2;
                p ^= 7;
                pshift -= 2;

                trinkle(p >>> 1, pshift + 1, head - LP[pshift] - 1, true);
                trinkle(p, pshift, head - 1, true);
            }

            animateIndex(head);
            head--;
        }
    }

    private void sift(int pshift, int head) {

        int val = vector[head];
        arrayAccess++;

        while (pshift > 1) {
            if (stop) {
                return;
            }

            int rt = head - 1;
            int lf = head - 1 - LP[pshift - 2];

            comparisons += 2;
            arrayAccess += 2;
            if (val >= vector[lf] && val >= vector[rt]) {
                break;
            }

            comparisons++;
            arrayAccess++;
            if (vector[lf] >= vector[rt]) {
                arrayAccess += 2;

                animateIndex(lf);
                vector[head] = vector[lf];

                head = lf;
                pshift -= 1;
            } else {
                arrayAccess += 2;

                animateIndex(rt);
                vector[head] = vector[rt];

                head = rt;
                pshift -= 2;
            }

        }

        animateIndex(head);

        vector[head] = val;
        arrayAccess++;
    }

    private void trinkle(int p, int pshift, int head, boolean isTrusty) {

        int val = vector[head];
        arrayAccess++;

        while (p != 1) {
            if (stop) {
                return;
            }

            int stepson = head - LP[pshift];

            arrayAccess++;
            comparisons++;
            if (vector[stepson] <= val) {
                break;
            }

            if (!isTrusty && pshift > 1) {
                int rt = head - 1;
                int lf = head - 1 - LP[pshift - 2];

                arrayAccess += 2;
                comparisons += 2;
                if (vector[rt] >= vector[stepson] || vector[lf] >= vector[stepson]) {
                    break;
                }
            }

            arrayAccess += 2;

            animateIndex(stepson);
            vector[head] = vector[stepson];

            head = stepson;
            int trail = Integer.numberOfTrailingZeros(p & ~1);
            p >>>= trail;
            pshift += trail;
            isTrusty = false;
        }

        if (!isTrusty) {

            animateIndex(head);
            vector[head] = val;

            arrayAccess++;
            sift(pshift, head);
        }
    }
}
