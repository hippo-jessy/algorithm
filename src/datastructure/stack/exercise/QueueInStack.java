package datastructure.stack.exercise;

import datastructure.queue.IQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * This is a solution for a stack interview question as below:
 *
 * Question:
 *
 * Implement a queue using two stacks.
 *
 * <p>
 * Solutions:
 *
 * Approach 1:
 *
 * use the second stack to reverse the order, pop everything from newTopStack to oldTopStack when remove() or poll()
 * triggered and then push everything back to the newTopStack.
 *
 * Approach 2(taken):
 *
 * approach 1 has too many unnecessary element movements and in approach 2, we pop everything from newTopStack to
 * oldTopStack only when oldTopStack is empty.
 *
 */
public class QueueInStack<T> implements IQueue<T> {
    private Stack<T> newTopStack = new Stack<>();
    private Stack<T> oldTopStack = new Stack<>();

    @Override
    public boolean add(T item) {
        newTopStack.add(item);
        return true;
    }

    @Override
    public boolean offer(T item) {
        return add(item);
    }

    @Override
    public T remove() {
        if (oldTopStack.isEmpty()) {
            if (newTopStack.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                //shift stacks only when the oldTopStack is empty
                shiftStack();
                return oldTopStack.pop();
            }
        }
        return oldTopStack.pop();
    }

    @Override
    public T poll() {
        if (oldTopStack.isEmpty()) {
            if (newTopStack.isEmpty()) {
                return null;
            } else {
                shiftStack();
                return oldTopStack.pop();
            }
        }
        return oldTopStack.pop();
    }

    @Override
    public T element() {
        if (oldTopStack.isEmpty()) {
            if (newTopStack.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                shiftStack();
                return oldTopStack.peek();
            }
        }
        return oldTopStack.peek();
    }

    @Override
    public T peek() {
        if (oldTopStack.isEmpty()) {
            if (newTopStack.isEmpty()) {
                return null;
            } else {
                shiftStack();
                return oldTopStack.peek();
            }
        }
        return oldTopStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return oldTopStack.isEmpty() && newTopStack.isEmpty();
    }

    public void shiftStack() {
        while (!newTopStack.isEmpty()) {
            oldTopStack.push(newTopStack.pop());
        }
    }
}
