package sorting;

import java.util.Arrays;

import org.junit.Test;

public class SimpleSelectionSort {

	@Test
	public void testSimpleSelectionSort() {
		int[] a = new int[] { 4, 19, 345, 1, 0, 90, 24, 12, 3, 4, 31, 10, 28, 19 };
		simpleSelectionSort(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Simple selection sort implementation.
	 * 
	 * @param data
	 *            the array to be sorted
	 */
	public static void simpleSelectionSort(int[] data) {
		int indexFlag;
		for (int i = data.length - 1; i > 0; i--) {
			indexFlag = i;
			for (int j = 0; j < i; j++) {
				if (data[j] > data[indexFlag]) {
					indexFlag = j;
				}
			}
			if (i != indexFlag) {
				data[i] ^= data[indexFlag];
				data[indexFlag] ^= data[i];
				data[i] ^= data[indexFlag];
			}
		}
	}
}
