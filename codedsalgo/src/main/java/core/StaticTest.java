package core;

public class StaticTest {

    public static StaticTest test(){
        System.out.println("test");
        return new StaticTest();
    }

    public static void main(String[] args) {
        StaticTest t1 = new StaticTest();
        StaticTest t2 = new StaticTest();

        System.out.println(t1.test().hashCode());
        System.out.println(t2.test().hashCode());
    }
}
