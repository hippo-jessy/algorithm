package datastructure.queue;

import java.util.NoSuchElementException;

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

    public boolean add(T data) {
        if (tail == null) {
            head = new QueueNode(data);
            tail = head;
        } else {
            tail.next = new QueueNode(data);
        }
        return true;
    }


    public boolean offer(T data) {
        return add(data);
    }

    public T remove() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T tmpData = head.data;
            head = head.next;
            return tmpData;
        }
    }

    public T poll() {

        if (head == null) {
            return null;
        } else {
            T tmpData = head.data;
            head = head.next;
            return tmpData;
        }
    }

    public T element() {

        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head.data;
        }
    }

    public T peek() {
        return (head == null) ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }


}