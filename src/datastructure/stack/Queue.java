package datastructure.stack;

/**
 * This is a simple implementation of queue.
 */
public class Queue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> head;
    private QueueNode<T> tail;

    public void add(T data) {

    }


    public T offer() {
    }

    public T remove() {

    }

    public void poll(T data) {

    }

    public T peek() {

    }

    public T element() {

    }

    public boolean isEmpty() {

    }


}