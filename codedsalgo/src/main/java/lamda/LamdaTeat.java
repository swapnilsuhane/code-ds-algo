package lamda;

import java.util.function.UnaryOperator;

public class LamdaTeat {
    public static void main(String[] args) {
        String s  = "hello";
        StringBuilder sb = new StringBuilder("reyom");

        UnaryOperator<String> o1 = s1 -> s1.concat(s);
        UnaryOperator<String> o2 = s2  -> s2.toUpperCase();

        //System.out.println(o2.apply(sb));
    }
}
