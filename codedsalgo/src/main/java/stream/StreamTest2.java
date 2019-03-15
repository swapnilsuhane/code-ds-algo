package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Swapnil", 31),
                                             new Person("Saurabh", 32),
                                             new Person("Nilesh", 33));

        //double d = persons.stream().filter(a -> a.age<30)
        //    .mapToInt(a-> a.age)
        //    .average().getAsDouble();

       // System.out.println("average: " + d);

        double s = persons.stream().filter(a -> a.age<30)
            .mapToInt(a-> a.age)
            .sum();

        System.out.println("sum: " + s);

        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        double avg = stream.mapToInt(i->i).average().getAsDouble();
        System.out.println("avg: " +avg);



    }


}

class Person {
    String name;
    int age;

   public Person(String name, int age){
       this.name=name;
       this.age=age;
   }

}
