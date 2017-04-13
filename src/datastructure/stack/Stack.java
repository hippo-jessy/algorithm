package datastructure.stack;

import java.util.EmptyStackException;

/**
 * This is a simple implementaiton of stack.
 */
public class Stack<T> implements IStack<T> {
    private StackNode<T> head;

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    @Override
    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T tmp = head.data;
        head = head.next;
        return tmp;
    }

    @Override
    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = head;
        head = node;
    }

    @Override
    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            return head.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


}
