package core;

public class Car extends Vehicle {
    public String start(){
        System.out.println("Car started");
        return "Car started..";
    }

    //can override private method
    public String test(){
        System.out.println("testing car");
        return "testing car";
    }

    public void driveCar(){
        System.out.println("driving a car..");
    }

    public void doCar(Object c, Vehicle v){
        System.out.println("called doCar");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.start();
        System.out.println("Milage: " +vehicle.milage);
        ((Car)vehicle).test();

        ((Car)vehicle).driveCar();
        new Car().doCar(new Car(), new Car());
    }

    public static void main(String s){
        System.out.println("main..");
    }
}
