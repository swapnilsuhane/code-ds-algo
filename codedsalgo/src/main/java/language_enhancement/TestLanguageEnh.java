package language_enhancement;

import java.io.IOException;

public class TestLanguageEnh {

    public static void main(String[] args) {
        int i = 10_1000; // use _ to make it more readable
        int j = 10_____1000; // same like above (can use multiple _ but its same as 1 _)
        // int k = _10_0; invalid
        //double dd = 10_00_0_D; //invalid
        float f = 10.0__0f;

        int b = 0b111 ;  // binary no starts with 0b
        double d1 = 0b10101010;
        double d2 = 0b1010101;
        float d3 = 0b1010101;
        //float d3 = 0b1010101f; //binary no can't have suffix except L for long
        //double d = 0b1010101d;
        long l = 0b1000L;

        float f2 = 0x1010101f;
        double d4 = 0x1010101f;  //hexadecimal no starts with 0x can have suffix
        double d5 = 12343D;  //decimal no can have suffix


        System.out.println(i);
        System.out.println(j);
        System.out.println(b);

    }
}
