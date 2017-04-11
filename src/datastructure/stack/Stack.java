package datastructure.stack;

/**
 * User: hippo
 * Date: 4/11/17
 * Time: 12:48 AM
 */
public class Stack<T> {
    private StackNode<T> head;
    private static class StackNode<T> {
        private T data;
        StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }

    public T pop(){
        if(head == null){
            return null;
        }
        T tmp = head.data;
        head = head.next;
        return tmp;
    }


    public void push(T data){

    }

    public boolean isEmpty(){
        return (head == null)? true: false;
    }


}
