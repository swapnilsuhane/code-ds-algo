package language_enhancement;

import java.io.IOException;

public class TestNewTryBlock implements AutoCloseable{
    public void test() {
        System.out.println("test-1");
    }

    public void test2() throws IOException{
        System.out.println("test-2");
        throw new IOException();
    }

    public void close(){
        System.out.println("Closed - " + this.hashCode());
    }

    public static void main(String[] args) {
        try (TestNewTryBlock testNewTryBlock = new TestNewTryBlock()){
            testNewTryBlock.test();
        }

        try (TestNewTryBlock testNewTryBlock = new TestNewTryBlock()){
            testNewTryBlock.test2();
        }catch (IOException e){
            //e.printStackTrace(); print before (its not in sequence)
            System.out.println("test2 io exception");
        }

        try {
            TestNewTryBlock testNewTryBlock = new TestNewTryBlock();
            testNewTryBlock.test();
        } finally {
            System.out.println("must have either catch or finally");
        }

    }
}
