package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is an implementation of heap sort.
 */
public class HeapSort {
    private static class MinHeap<T extends Comparable<T>>{
        private T[] heapArray;
        private int currentSize;
        private static final int DEFAULT_CAPACITY = 100;

        public MinHeap(){
            this(DEFAULT_CAPACITY);
        }

        public MinHeap(int initCapacity){
            heapArray = (T[]) new Comparable[initCapacity];
            currentSize=0;
        }


        public boolean insert(T item){
            if(currentSize == heapArray.length){
                return false;
            }
            heapArray[currentSize] = item;
            percolateUp(currentSize++);
            return true;
        }

        public T removeMin(){
            if(currentSize == 0){
                throw new NoSuchElementException("Empty Heap!");
            }
            T tmp = heapArray[0];
            currentSize--;
            heapArray[0] = heapArray[currentSize];
            heapArray[currentSize] = null;
            percolateDown(0);
            return tmp;
        }


        private void percolateUp(int index){
            T tmp = heapArray[index];
            int parentIndex = (index - 1) / 2;
            while (index > 0 && heapArray[parentIndex].compareTo(tmp) > 0) {
                heapArray[index] = heapArray[parentIndex];
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }

            heapArray[index] = tmp;
        }

        private void percolateDown(int index){
            T tmp = heapArray[index];
            while (index < currentSize / 2) {
                int leftChild = index * 2 + 1;
                int rightChild = leftChild +1;
                int smallerChild;
                if (rightChild <= currentSize - 1 && heapArray[rightChild].compareTo(heapArray[leftChild]) < 0) {
                    smallerChild = rightChild;
                } else {
                    smallerChild = leftChild;
                }

                if (heapArray[smallerChild].compareTo(tmp) > 0) {
                    break;
                }

                heapArray[index] = heapArray[smallerChild];
                index = smallerChild;
            }
            heapArray[index] = tmp;
        }

    }

    public static void heapSort(int[] data){
        MinHeap<Integer> minHeap = new MinHeap<>(data.length);
        for (int m : data) {
            minHeap.insert(m);
        }
        for(int i =0; i<data.length;i++) {
            data[i] = minHeap.removeMin();
        }
    }

    @Test
    public void testHeapSort() {
        int[] data = new int[]{12,1,24,29,4,235,673,453,4,2,3,1,57,34,85,6,34};
        int[] data1 = data.clone();
        HeapSort.heapSort(data);
        System.out.println(Arrays.toString(data));
        Arrays.sort(data1);
        System.out.println(Arrays.toString(data1));
        Assert.assertArrayEquals(data1,data);
    }
}
