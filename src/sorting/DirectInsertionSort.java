package sorting;

import java.util.Arrays;

import org.junit.Test;

public class DirectInsertionSort {

    @Test
    public void testDirectInsertionSort() {
        int[] a = new int[]{4, 19, 345, 1, 0, 90, 24, 12, 3, 4, 31, 10, 28, 19};
//		directInsertionSortA(a);
//		directInsertionSortB(a);
// 		directInsertionSortC(a);
        directInsertionSortD(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Version A of direct insertion sort.
     * This version is in-place sort using only the original array
     * and several temporary variables.
     *
     * @param data the array to be sorted.
     */
    public static void directInsertionSortA(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > tmp) {
                    data[j + 1] = data[j];
                } else {
                    data[j + 1] = tmp;
                    break;
                }
                if (j == 0) {
                    data[j] = tmp;
                }
            }
        }
    }

    /**
     * Version B of direct insertion sort.
     * This version is not in-place sort. Because when the src argument and dst
     * argument of<code>System.arraycopy</code> are the same array object, a temporary
     * array is used to assist the copy process.
     *
     * @param data the array to be sorted.
     */
    public static void directInsertionSortB(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            for (int j = 0; j < i; j++) {
                if (data[j] > tmp) {
                    System.arraycopy(data, j, data, j + 1, i - j);
                    data[j] = tmp;
                    break;
                }
            }
        }
    }


    public static void directInsertionSortC(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j;
            /*
			 * Attention! The following code is mistaken.
			 * ******************************************
			 * for(j = i-1; j>=0 && data[j]>data[i];j--){
				data[j+1] = data[j];
			 * }
			 * ******************************************
			 * The value of data[i] could be changed by the statement
			 * data[j+1] = data[j];
			 * Keep in mind to store the initial data[i] using a temporary variable.
			 */
            for (j = i - 1; j >= 0 && data[j] > tmp; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = tmp;
        }
    }

    public static void directInsertionSortD(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j;
            for (j = i - 1; j >= 0 && data[j] > tmp; j--) {
                data[j + 1] ^= data[j];
                data[j] ^= data[j + 1];
                data[j + 1] ^= data[j];
            }
        }
    }
}








