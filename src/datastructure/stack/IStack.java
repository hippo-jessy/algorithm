package datastructure.stack;

/**
 * Created by hippo on 4/14/17.
 */
public interface IStack<T> {
    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();
}
