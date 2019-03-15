package core;

public class Dog extends Animal {
    String name;

    public void say(){
        System.out.println("dog is laughing..");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name="pyara kutta";

        Animal animal = new Animal();
        animal.name = "pyara animal";

        //List<Dog> dogList = new ArrayList<Animal>();
        //List<Animal> animalList = new ArrayList<Dog>();
    }
}
