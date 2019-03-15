package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOPermissionTest {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(
            new FileReader("/Users/swapnil.suhane/test.txt")))
        //remove permission for this file
        {
            String s;
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
