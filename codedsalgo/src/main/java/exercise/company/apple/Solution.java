package main.java.exercise.company.apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Find the full path of person name having max children
 A
    B
        B1, B2
    C
        C1, C2, C3
return A.C
**/
public class Solution {
    static int max = Integer.MIN_VALUE;
    static String maxName = "";

    private static String findMaxChild(Person root) {
        if (root == null) {
            return "";
        }
        find(root, "");
        return maxName;
    }

    private static void find(Person person, String name) {
        if (person.child.size() == 0) {
            if (person.child.size() > max) {
                maxName = person.name;
                max = person.child.size();
            }
            return;
        }

        name += person.name;
        if (person.child.size() > max) {
            maxName = name;
            max = person.child.size();
        }
        for (Person p : person.child) {
            find(p, name);
        }
    }

    private static Person buildPerson() {
        Person pd1 = new Person("D1", Collections.emptyList());
        Person pd2 = new Person("D2", Collections.emptyList());
//        Person pd3 = new Person("D3", Collections.emptyList());
//        Person pd4 = new Person("D4", Collections.emptyList());
//        Person pd5 = new Person("D5", Collections.emptyList());

        Person pc1 = new Person("C1", Collections.emptyList());
        Person pc2 = new Person("C2", Collections.emptyList());
        Person pc3 = new Person("C3", Collections.emptyList());
        Person pc4 = new Person("C4", Collections.emptyList());

        Person pb1 = new Person("B1", Collections.emptyList());
        Person pb2 = new Person("B2", Collections.emptyList());

        Person[] ba = {pb1, pb2};
        Person[] ca = {pc1, pc2, pc3, pc4};
        Person[] da = {pd1, pd2};
        Person pb = new Person("B", Arrays.asList(ba));
        Person pc = new Person("C", Arrays.asList(ca));
        Person pd = new Person("D", Arrays.asList(da));
        Person[] aa = {pc, pb, pd};
        return new Person("A", Arrays.asList(aa));
    }

    public static void main(String[] args) {
        Person root = buildPerson();
        String maxChild = findMaxChild(root);
        System.out.println(maxChild);
    }

    static class Person {
        public String name;
        public List<Person> child;

        Person(String name, List<Person> child) {
            this.name = name;
            this.child = child;
        }
    }
}
