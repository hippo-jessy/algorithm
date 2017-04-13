package datastructure.queue;

import java.util.NoSuchElementException;

/**
 * This is a simple implementation of queue.
 * <p>
 * It's super easy to mess up the updating of head and tail nodes, be careful.
 */
public class Queue<T> implements IQueue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> head;
    private QueueNode<T> tail;

    @Override
    public boolean add(T data) {
        if (tail == null) {
            head = new QueueNode(data);
            tail = head;
        } else {
            tail.next = new QueueNode(data);
            //Don't forget to update tail
            tail = tail.next;
        }
        return true;
    }

    @Override
    public boolean offer(T data) {
        return add(data);
    }

    @Override
    public T remove() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T tmpData = head.data;
            head = head.next;
            //Don't forget to update tail
            if (head == null) {
                tail = null;
            }
            return tmpData;
        }
    }

    @Override
    public T poll() {

        if (head == null) {
            return null;
        } else {
            T tmpData = head.data;
            head = head.next;
            //Don't forget to update tail
            if (head == null) {
                tail = null;
            }
            return tmpData;
        }
    }

    @Override
    public T element() {

        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head.data;
        }
    }

    @Override
    public T peek() {
        return (head == null) ? null : head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


}