package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamGroupByTest {
    private static List<String> fruits = Arrays.asList("apple", "orange", "banana", "apple", "grape", "apple", "orange");

    public static void main(String[] args) {
        fruits.stream().collect(Collectors.groupingBy(f -> f.toString())).forEach((a,b) -> System.out.println(a + " - " + b));
        System.out.println("counts : " + fruits.stream().collect(Collectors.groupingBy(f -> f.toString(), Collectors.counting())));

        System.out.println( "group by -> map:  " +
            fruits.stream().collect(Collectors.groupingBy(f-> f.toString(),
                Collectors.groupingBy(f -> f.startsWith("a")))));

    }

}
