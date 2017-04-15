package sorting;

public class QuickSort {

    public static void quickSort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(data, low, high);
        quickSort(data, low, pivot - 1);
        quickSort(data, pivot + 1, high);
    }

    private static int partition(int[] data, int low, int high) {
        int lowPointer = low;
        int highPointer = high + 1;
        while (true) {
            while (data[++lowPointer] <= data[low]) {
                if (lowPointer >= high) {
                    break;
                }
            }
            while (data[--highPointer] > data[low])
                ;
            if (lowPointer >= highPointer) {
                break;
            }
            data[lowPointer] ^= data[highPointer];
            data[highPointer] ^= data[lowPointer];
            data[lowPointer] ^= data[highPointer];
        }
        int tmp = data[low];
        data[low] = data[highPointer];
        data[highPointer] = tmp;
        return highPointer;
    }

    /**
     * Quick sort with three-way.
     * This is an optimized version of general quick sort.
     * This version performs better and is used in preference to general quick sort
     * if multiple elements of the array have the same values.
     *
     * @param data
     * @param low
     * @param high
     */
    public static void threeWayQuickSort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int[] pivots = threeWayPartition(data, low, high);
        threeWayQuickSort(data, low, pivots[0] - 1);
        threeWayQuickSort(data, pivots[1] + 1, high);
    }

    /**
     * The traditional 3-way partition, that is "Dutch National Flag" solution.
     *
     * @param data the array to be partitioned.
     * @param low  the index of the first element, inclusively, to be partitioned
     * @param high the index of the last element, inclusively, to be partitioned
     * @return
     */
    private static int[] threeWayPartition(int[] data, int low, int high) {
        int[] index = new int[2];
        int pivot = data[low];
        index[0] = low;
        index[1] = high;
        int p = low;

        /*
         * the traditional 3-way partition
         * (or "Dutch National Flag") schema:
         *
         *   left part    center part              right part
         * +-------------------------------------------------+
         * |  < pivot  |   == pivot   |     ?    |  > pivot  |
         * +-------------------------------------------------+
         *              ^              ^        ^
         *              |              |        |
         *          index[0]           p     index[1]
         *
         * Invariants:
         *
         *   all in (left, index[0])   < pivot
         *   all in [index[0], p)     == pivot
         *   all in (index[1], right) > pivot
         *
         * Pointer p is the first index of ?-part.
         */
        while (p <= index[1]) {
            if (data[p] < pivot) {
                swap(data, p++, index[0]++);
            } else if (data[p] > pivot) {
                swap(data, p, index[1]--);
            } else {
                p++;
            }
        }
        return index;
    }

    private static void swap(int[] data, int a, int b) {
        if (a != b) {
            data[a] ^= data[b];
            data[b] ^= data[a];
            data[a] ^= data[b];
        }
    }

}
