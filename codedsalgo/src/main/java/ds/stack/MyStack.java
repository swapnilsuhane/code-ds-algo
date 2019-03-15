package ds.stack;

import java.util.LinkedList;
import java.util.List;

//using array
public class MyStack<T> {
    List<T> l= new LinkedList<>();

    private void push(T t){
        l.add(t);
    }

    private void pop(T t){
        l.remove(t);
    }

    private T peek(T t){
        if(l.contains(t)){
            return t;
        }else{
            return null;
        }
    }

    private void print(){
        for(int i=l.size()-1; i>=0; i--){
            System.out.println(l.get(i));
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();

        stack.pop(20);
        System.out.println("after pop: ");
        stack.print();

        System.out.println("peek: " + stack.peek(10));
    }


}
