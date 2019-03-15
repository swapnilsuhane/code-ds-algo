package lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LamdaFunctions {
    public static boolean usingPredicate(String name, Predicate<String> predicate){
        return predicate.test(name);
    }

    public static void usingConsumer(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static String usingSupplier(Supplier<String> supplier){
        return supplier.get();
    }

    public static List<String> usingFunction(String name, Function<String, List<String>> func){
        return func.apply(name);
    }

    public static int usingIntFunction(int i, IntFunction<Integer> intFunction){
        return intFunction.apply(i);
    }

    public static Long usingLongFunction(Long i, LongFunction<Long> longFunction){
        return longFunction.apply(i);
    }

    public static Double usingDoubleFunction(double i, DoubleFunction<Double> doubleFunction){
        return doubleFunction.apply(i);
    }

    public static void usingBiConsumer(String s1, String s2, BiConsumer<String, String> biConsumer){
        biConsumer.accept(s1, s2);
    }

    public static boolean usingBiPredicate(String s1, String s2, BiPredicate<String, String> biPredicate){
        return biPredicate.test(s1, s2);
    }

    public static String[] usingBiFunction(String s1, String s2, BiFunction<String, String, String[]> biFunction){
        return biFunction.apply(s1, s2);
    }

    public static void main(String[] args) {
        System.out.println("usingPredicate: " +
            usingPredicate("Reyom", s -> s.equalsIgnoreCase("Reyom")));

        usingConsumer("Reyom", s -> System.out.println("usingConsumer: " + s));

        System.out.println("usingSupplier: " +
            usingSupplier(() -> "Hello Reyom"));

        System.out.println("usingFunction: " +
            usingFunction("Reyom", s -> Arrays.asList(s)));

        System.out.println("usingIntFunction: " +
            usingIntFunction(10, (i) -> i*10));

        System.out.println("usingLongFunction: " +
            usingLongFunction(10L, (i) -> i*10));

        System.out.println("usingDoubleFunction: " +
            usingDoubleFunction(10D, (i) -> i*10));

        usingBiConsumer("Reyom", "Suhane", (s1, s2) -> System.out.println("usingBiConsumer: " + s1 + " " +s2));

        System.out.println(usingBiPredicate("Reyom", "Suhane", (s1, s2) -> (s1 + " " + s2).equalsIgnoreCase("Reyom Suhane") ));

        System.out.println("usingBiFunction: " +
            usingBiFunction("Reyom", "Suhane", (s1, s2) -> {
                String[] sa = new String[2];
                sa[0] = s1;
                sa[1] = s2;
                return sa;
            })[0]);

    }
}
