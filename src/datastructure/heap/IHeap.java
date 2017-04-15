package datastructure.heap;

/**
 *
 */
public interface IHeap<T extends Comparable<T>> {
    boolean insert(T item);

    T removeMax();

    boolean isEmpty();
}
