package test;

public class Generic<T> {
     T t;
     Class test(T t){
         this.t=t;
        return t.getClass();
    }

    public static void main(String[] args) {
         String s = new String();
        Generic<String > g = new Generic<>();
        System.out.println(g.test(s));
    }
}
