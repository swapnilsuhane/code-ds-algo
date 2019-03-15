package stream;

public class User {
    int id;
    String name;
    int age;
    char sex;
    long salary;

    public User(int id, String name, int age, char sex, long salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.salary=salary;
    }

    public String toString(){
        return "id:" + id + "  - name:" + name + " - age:" + age + " - sex: " + sex + " - salary:" +salary;
    }
}
