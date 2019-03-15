package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {
    static List<String> cities = Arrays.asList("Jabalpur", "Singapore", "Hyderabad", "London");
    static List<Integer> nos = Arrays.asList(1,2,3,4,5);



    public static void main(String[] args) {
        Map<Integer, String> map;
        cities.forEach(System.out::println);
        System.out.println("get cities names starts with letter 'J'");

        System.out.println("list of cities excluding london");
        cities.stream().filter(c -> !c.contains("London")).forEach(System.out::println);

        System.out.println("count the cities that has >7 letters in it");
        System.out.println(cities.stream().filter(c -> c.length()>7).count());

        System.out.println("get cities names starts with letter 'J' without using filter");
       //todo cities.stream().reduce(new ArrayList<String>(), c -> c.startsWith("J"));

        new Random().ints(100000).asLongStream().filter(l -> l <1000 && l > 10000).forEach(System.out::println);

        //IntStream.rangeClosed(100,120).forEach(System.out::println);

        cities.stream().filter(t -> t.equalsIgnoreCase("Jabalpur")).forEach(System.out::println);

        System.out.println("to Map");
        cities.stream().collect(Collectors.toMap(i -> cities.indexOf(i),  i -> i.toUpperCase())).
            forEach( (k,j) -> System.out.println(k + " - " + j));

        map = cities.stream().collect(Collectors.toMap(i -> cities.indexOf(i),  i -> i.toUpperCase()));
        cities.stream().forEach(i-> {
            int j =10;
            map.put(j, i.toUpperCase());
            j++;
        });

        System.out.println("second map: " +map);

        System.out.println("sum using SummarizingInt: " + nos.stream().collect(Collectors.summarizingInt(x->x)).getSum());
        System.out.println("sum using SummarizingInt 2: " + nos.stream().collect(Collectors.mapping(x->x, Collectors.summarizingInt(x->x))).getSum());


    }
}
