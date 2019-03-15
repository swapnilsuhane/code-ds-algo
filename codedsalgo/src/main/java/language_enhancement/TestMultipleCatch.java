package language_enhancement;

import java.io.IOException;

public class TestMultipleCatch {

    public void test() throws IOException {
        //can have a method without throwing exception
    }

    public void test2() throws ClassCastException {
        throw new ClassCastException("Test2 exception");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        TestMultipleCatch testMultipleCatch = new TestMultipleCatch();
        try {
            testMultipleCatch.test();
            testMultipleCatch.test2();
       // }catch (ClassCastException | IOException e){  below also ok
        }catch (IOException | ClassCastException e){
            //e = new IOException(); // e is final in multi-catch block
            e.printStackTrace();
           // System.out.println("in exception");
        }
        System.out.println("done");
    }
}
