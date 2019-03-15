package lamda;

public class FirstLamdaTest {
    public static void main(String[] args) {
        FirstLamdaInterface firstLamdaInterface =
            () -> {
            System.out.println("hello");
            };


        firstLamdaInterface.sayHello();
    }
}
