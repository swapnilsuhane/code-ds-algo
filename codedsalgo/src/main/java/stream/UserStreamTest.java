package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserStreamTest {
    static List<User> users = new ArrayList<>();

    static {
        IntStream.rangeClosed(100, 110).forEach(i->
            users.add(new User(i,
            "User" + i,
            getRandom(100),
            getGender(i),
            getRandom(10000))));
        //for (int i = 100; i < 110; i++) {
        //    users.add(new User(i,
        //        "User" + i,
        //        getRandom(100),
        //        getGender(i),
        //        getRandom(10000)));
        //}
    }

    private static int getRandom(int range) {
        return new Double(Math.random() * range).intValue();
    }

    private static char getGender(int i){
        return i%2==0?'M':'F';
    }

    public static void main(String[] args) {
        System.out.println("User's List-");
        users.forEach(System.out::println);

        System.out.println("get users age greater than 18");
        users.stream().filter(user -> user.age > 18).forEach(System.out::println);

        System.out.println("get max salary");
        users.stream().map(user -> user.salary).max(Comparator.comparing(s -> s)).ifPresent(System.out::println);

        System.out.println("get total salary of all users");
        System.out.println(users.stream().map(user -> user.salary).mapToLong(s -> s).sum());

        System.out.print("Sum using reduce 1: ");
        users.stream().map(user -> user.age).reduce((a, b) -> (a + b)).ifPresent(System.out::println);

        System.out.println("Sum using reduce 2: " + users.stream().map(user -> user.age)
            .reduce(10, (a,b)-> (a+b)));

        System.out.println("Sum using reduce 3: " + users.stream().map(user -> user.age)
            .reduce(0.0,
                ((integer, integer2) -> (integer+integer2)),
                ((integer, integer2) -> (integer+integer))));

        System.out.println("Ave Age: " + users.stream().map(user -> user.age)
            .reduce((a, b) -> (a + b)).map(a-> a/(users.size())).get());

        System.out.println("get avg age of users");
        users.stream().map(user -> user.age).mapToInt(a->a).average().ifPresent(System.out::println);

        System.out.println("user with max salary");
        users.stream().reduce((u1, u2) -> (u1.salary>u2.salary?u1:u2)).ifPresent(System.out::println);

        System.out.println("Create Map<id, User>");
        users.stream().map(user -> {
                    Map<Integer, User> map = new HashMap();
                    map.put(user.id, user);
                    return map;
                    }).forEach(System.out::println);

        System.out.println("sort Users by their salary");
        users.stream().sorted(Comparator.comparing(
            user->((User)user).salary).reversed()).forEach(System.out::println);

        System.out.println("find User with second largest salary");
        users.stream().sorted(Comparator.comparing(
            user->((User)user).salary).reversed()).limit(2).sorted(Comparator.comparing(
                user -> user.salary)).findFirst().ifPresent(System.out::println);

        System.out.println("get Male users with age>18 and salary >5000");
        users.stream().filter(user -> user.sex=='M' && user.age>18 && user.salary>5000).forEach(System.out::println);

        System.out.println("get user name list of all Female users");
        System.out.println(users.stream().filter(user -> user.sex == 'F')
            .map(user -> user.name).collect(Collectors.toList()));

        System.out.println("get map of username & age for all females users");
        System.out.println(users.stream().filter(user -> user.sex=='F').
            collect(Collectors.toMap(user->user.name,user->user.age)));

        System.out.println("get map of username & age for all females users");
        System.out.println(users.stream().filter(user -> user.sex=='F').
            collect(LinkedHashMap<String, Integer>::new,(map, user)-> map.put(user.name, user.age),LinkedHashMap::putAll)
            .toString());

        System.out.println("Collectors.groupby F/M");
        users.stream().collect(Collectors.groupingBy(u -> u.sex)).forEach((a,b) -> System.out.println(a + " - " + b));

        users.stream().collect(Collectors.groupingBy(u -> u.sex)).forEach((a,b) -> System.out.println(a + " - " + b.size()));

    }
}
