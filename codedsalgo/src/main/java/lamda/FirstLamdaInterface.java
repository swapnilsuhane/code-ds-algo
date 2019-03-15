package lamda;

public interface FirstLamdaInterface {
    void sayHello();

    default void sayDefault(){
        System.out.println("hello");
    }
}
