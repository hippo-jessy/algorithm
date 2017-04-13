package datastructure.stack;

import java.util.EmptyStackException;

/**
 * This is a simple implementaiton of stack.
 */
public class Stack<T> {
    private StackNode<T> head;

    private static class StackNode<T> {
        private T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T tmp = head.data;
        head = head.next;
        return tmp;
    }


    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = head;
        head = node;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            return head.data;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }


}
