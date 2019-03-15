package stream;

public interface Banglow extends House {
    default String build(){
        return "Banglow Default";
    }

    static String test() { return "Banglow Static"; }
}
