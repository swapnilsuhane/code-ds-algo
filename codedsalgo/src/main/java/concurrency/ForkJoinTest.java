package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        Fibonacci fibonacci = new Fibonacci(5);
        int i = forkJoinPool.invoke(fibonacci);
        System.out.println(i);

    }
}

class Fibonacci extends RecursiveTask<Integer>{
    private int i;

    Fibonacci(int i){
        this.i = i;
    }

    public Integer compute(){

        if(i <=1){
            return i;
        }

        Fibonacci f1 = new Fibonacci(i-1);
        Fibonacci f2 = new Fibonacci(i-2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();

    }
}
