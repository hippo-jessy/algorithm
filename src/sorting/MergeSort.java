package sorting;

public class MergeSort {

    public static void mergeSort(int[] data, int[] tmp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(data, tmp, low, mid);
        mergeSort(data, tmp, mid + 1, high);
        merge(data, tmp, low, mid, high);

    }

    private static void merge(int[] data, int[] tmp, int low, int mid, int high) {
        int lp = low;
        int rp = mid + 1;
        int p = low;

        System.arraycopy(data, low, tmp, low, high - low + 1);
        while (lp <= mid && rp <= high) {
            data[p++] = (tmp[rp] < tmp[lp]) ? tmp[rp++] : tmp[lp++];
        }

        if (lp > mid) {
            System.arraycopy(tmp, rp, data, p, high - rp + 1);
        } else {
            System.arraycopy(tmp, lp, data, p, mid - lp + 1);

        }
    }


    /**
     * In-place merge sort.
     *
     * @param data the array to be sorted.
     * @param low  the lowest index of sub array to be sorted.
     * @param high the highest index of sub array to be sorted.
     */
    public static void inplaceMergeSort(int[] data, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        inplaceMergeSort(data, low, mid);
        inplaceMergeSort(data, mid + 1, high);

        inplaceMerge(data, low, mid + 1, high);
    }

    private static void inplaceMerge(int[] data, int low, int mid, int high) {
        int lp = low;
        int rp = mid;
        int p = rp;

        while (lp < p && rp <= high) {
            while (lp < p && data[lp] <= data[rp]) {
                lp++;
            }
            if (lp == p) {
                break;
            }
            while (rp <= high && data[rp] < data[lp]) {
                rp++;
            }

            convert(data, lp, p, rp - 1);
            lp += rp - p;
            p = rp;
        }

    }

    private static void convert(int[] data, int low, int pivot, int high) {
        if (low >= high) {
            return;
        }
        reverse(data, low, pivot - 1);
        reverse(data, pivot, high);
        reverse(data, low, high);
    }

    private static void reverse(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        while (low < high) {
            swap(data, low++, high--);
        }

    }

    private static void swap(int[] data, int indexA, int indexB) {
        if (indexA == indexB) {
            return;
        }
        data[indexA] ^= data[indexB];
        data[indexB] ^= data[indexA];
        data[indexA] ^= data[indexB];
    }
}
