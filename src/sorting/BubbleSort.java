package sorting;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort {
    @Test
    public void testBubbleSort() {
        int[] a = new int[]{4, 19, 345, 1, 0, 90, 24, 12, 3, 4, 31, 10, 28, 19};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Bubble sort implementation.
     *
     * @param data the array to be sorted
     */
    public static void bubbleSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    data[j] ^= data[j + 1];
                    data[j + 1] ^= data[j];
                    data[j] ^= data[j + 1];
                }
            }
        }
    }

    /**
     * Optimization version of bubble sort.
     *
     * @param data the array to be sorted
     */
    public static void bubbleSortOptimization(int[] data) {
        boolean hasSwap = false;
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    data[j] ^= data[j + 1];
                    data[j + 1] ^= data[j];
                    data[j] ^= data[j + 1];
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                return;
            }
        }
    }

}
