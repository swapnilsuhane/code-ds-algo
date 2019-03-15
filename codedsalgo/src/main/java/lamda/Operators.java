package lamda;

public class Operators {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {
        Operators operators = new Operators();
        System.out.println("Addition " + operators.operateBinary(10, 20, (a, b) -> a+b));
        System.out.println("Multi " + operators.operateBinary(10, 20, (a, b) -> a*b));
        System.out.println("Subs" + operators.operateBinary(10, 20, (a, b) -> a-b));
    }
}
