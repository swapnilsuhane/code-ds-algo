package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPriceTest {
    static class Price{
        double value;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Price>  list = Arrays.asList(new Price[2]);
        List<Price>  list2 = new ArrayList<>();

        list.forEach(p -> {
            p = new ItemPriceTest.Price();
            p.setValue(10);
            list2.add(p);
        });
        list2.forEach(p-> System.out.println(p.getValue()));

        //list2.stream().reduce(0.0, (p1,p2) -> p1.getValue() + p2.getValue());

        double sum = list2.stream().map(p-> p.getValue()).reduce(0.0, (p1,p2) -> p1+p2);
        System.out.println("sum: "+sum);
    }
}
