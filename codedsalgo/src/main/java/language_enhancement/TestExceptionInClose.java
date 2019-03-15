package language_enhancement;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestExceptionInClose implements AutoCloseable{

    public void open() throws Exception {
        System.out.println("Open called");
        throw new Exception("open");
    }

    public void test() throws IOException{
        throw new IOException();
        //throw new NumberFormatException(); no need to declare throws in method
        //throw new IOException();
    }

    public void close() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        try(TestExceptionInClose testExceptionInClose=new TestExceptionInClose();
            FileOutputStream fileOutputStream = new FileOutputStream("test");) {
            //testExceptionInClose = new TestExceptionInClose();
            // error in compile can not declare for final
            //testExceptionInClose.test();
            throw new Exception("main");
        }catch (Exception e){
            //e = new Exception("new exception"); //works fine
            e.printStackTrace();
        }
    }
}
