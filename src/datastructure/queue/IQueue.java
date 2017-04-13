package datastructure.queue;

/**
 * Created by hippo on 4/14/17.
 */
public interface IQueue<T> {
    boolean add(T item);

    boolean offer(T item);

    T remove();

    T poll();

    T element();

    T peek();

    boolean isEmpty();
}

