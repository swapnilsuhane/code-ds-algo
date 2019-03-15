package lamda;

import java.util.function.Function;

public class Calculator {
    public static double calculate(double d, Function<Integer, Integer> f){
        return f.apply((int)d);
    }

    public static void main(String[] args) {
        double principle = 100;
        int interest = 5;

        double amount = calculate(principle, x->x*interest);

        System.out.println("amount: "+amount);

    }
}
