package ds.stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingQueue<T> {
    Queue<T> queue = new PriorityQueue<>();

    private void push(T t){
        queue.add(t);
    }

    private void print(Queue<T> q){
        int i = (Integer)q.poll();
        if(q.size()>0) {
            print(q);
        }

        System.out.println(i);
    }


    private void print(){
        Queue q = new PriorityQueue();
        q.addAll(queue);
        print(q);
    }

    public static void main(String[] args) {
        StackUsingQueue<Integer> stack = new StackUsingQueue<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();
        //stack.print();
    }

}
