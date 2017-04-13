package datastructure.stack.exercise;

import java.util.EmptyStackException;

/**
 * This is a solution for a stack interview question as below:
 * Question:
 *        How to implement three stacks using a single array?
 */
public class ThreeInOne<T> {
    public static final int STACK_NUM = 3;
    private Object[] data;
    private int[] bounds = new int[6];
    private int[] tops = new int[3];

    public ThreeInOne(int stackSize) {
        this.data = new Object[stackSize * STACK_NUM];
        for (int i = 0; i < 3; i++) {
            bounds[i * 2] = stackSize * i;
            bounds[i * 2 + 1] = stackSize * i + stackSize - 1;
            tops[i] = stackSize * i;
        }
    }

    public void push(int stackIndex, T item) {
        if (isFull(stackIndex)) {
            throw new IndexOutOfBoundsException();
        }
        data[tops[stackIndex]] = item;
        tops[stackIndex]++;
    }

    public T pop(int stackIndex) {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }
        tops[stackIndex]--;
        return (T) data[tops[stackIndex]];

    }

    public T peek(int stackIndex) {
        if (isEmpty(stackIndex)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[tops[stackIndex] - 1];

    }

    public boolean isEmpty(int stackIndex) {
        return tops[stackIndex] <= bounds[stackIndex * 2];
    }

    public boolean isFull(int stackIndex) {
        return tops[stackIndex] > bounds[stackIndex * 2 + 1];
    }

}
