package main.java.leetcode;

//add two numbers without using + sign
public class AddNumbers {

    private static int add(int a, int b) {
        while(b!=0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }



    public static void main(String[] args) {
        System.out.println("add:" + add(-20, 3));
    }
}
