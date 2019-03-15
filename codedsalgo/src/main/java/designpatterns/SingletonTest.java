package designpatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {
    private static SingletonTest instance;
    private static Map<Integer, SingletonTest> map = new HashMap<>();

    private SingletonTest() {
    }

    //double checked locking
    public static SingletonTest getInstance(){
            if (instance == null) {
                synchronized (SingletonTest.class) {
                    if (instance ==null) {
                        instance = new SingletonTest();
                    }
                }

        }
        return instance;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<100000;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        SingletonTest instance1 = getInstance();
                        map.putIfAbsent(instance1.hashCode(), instance1);
                        System.out.println(instance1.hashCode());
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(1000);
        System.out.println(map);

    }
}
