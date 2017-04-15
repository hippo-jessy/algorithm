package sorting;

public class RadixSort {

    public static void radixSort(int[] data, int radix, int digital) {
        for (int j = 1; j <= digital; j++) {
            countingSortForRadix(data, radix, j);
        }
    }


    private static void countingSortForRadix(int[] data, int radix, int currentDigital) {
        int[] countingArray = new int[radix];
        int[] outputArray = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            countingArray[mapD2C(data, i, radix, currentDigital)]++;
        }

        for (int j = 1; j < countingArray.length; j++) {
            countingArray[j] += countingArray[j - 1];
        }

        for (int k = data.length - 1; k >= 0; k--) {
            outputArray[--countingArray[mapD2C(data, k, radix, currentDigital)]] = data[k];
        }

        System.arraycopy(outputArray, 0, data, 0, data.length);
    }

    private static int mapD2C(int[] data, int index, int radix, int currentDigital) {
        return (data[index] / (int) Math.pow(radix, currentDigital - 1)) % radix;
    }
}
