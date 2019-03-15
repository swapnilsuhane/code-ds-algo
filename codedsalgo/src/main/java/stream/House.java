package stream;

public interface House {
    default String build(){
        return "House Default";
    }

    static String test() { return "House Static"; }
}
