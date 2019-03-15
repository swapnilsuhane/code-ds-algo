package stream;

//multiple inheritance test
public class HouseTest implements Banglow{
    //not overriding from interface, its separate method
    static String test() { return "HouseTest Static"; }

    public static void main(String[] args) {
        House house = new HouseTest();
        Banglow banglow = new HouseTest();
        HouseTest houseTest = new HouseTest();

        System.out.println("house default: " + house.build());
        System.out.println("banglow default: " + banglow.build());

        System.out.println("house static: " + House.test());
        System.out.println("banglow static: " + Banglow.test());
        System.out.println("houseTest static: " + houseTest.test());


    }
}
