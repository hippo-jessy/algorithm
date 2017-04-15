package datastructure.heap;


import sun.awt.FullScreenCapable;

import java.util.NoSuchElementException;

/**
 * This is a simple implementation for a max-heap.
 */
public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {

    public static final int DEFAULT_CAPACITY = 100;

    private T[] heapArray;
    private int currentSize;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }


    public MaxHeap(int initialCapacity) {
        heapArray = (T[]) new Comparable[initialCapacity];
    }


    @Override
    public boolean insert(T item) {
        if (currentSize == heapArray.length) {
            return false;
        }
        heapArray[currentSize] = item;
        percolateUp(currentSize++);
        return true;
    }

    @Override
    public T removeMax() {
        if (heapArray[0] == null) {
            throw new NoSuchElementException();
        }
        T tmp = heapArray[0];
        currentSize--;
        heapArray[0] = heapArray[currentSize];
        heapArray[currentSize] = null;
        percolateDown(0);
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return heapArray[0] == null;
    }


    private void percolateUp(int index) {
        T tmp = heapArray[index];
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heapArray[parentIndex].compareTo(heapArray[index]) < 0) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        heapArray[index] = tmp;
    }

    private void percolateDown(int index) {
        T tmp = heapArray[index];
        while ((index * 2 + 1) <= (currentSize - 1)) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int largerChild;

            if (rightChild < currentSize && heapArray[rightChild].compareTo(heapArray[leftChild]) > 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (heapArray[largerChild].compareTo(heapArray[index]) <= 0) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;

        }
        heapArray[index] = tmp;

    }
}
