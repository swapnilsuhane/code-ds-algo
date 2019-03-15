package nio2;

import java.net.URI;
import java.nio.file.*;

public class TestNio2 {
    public static void main(String[] args) throws Exception{
        String home = System.getProperty("user.home");
        System.out.println(home);

        //Arrays.asList(System.getProperties()).stream().forEach(System.out::println);
        Path path = Paths.get(home);
        System.out.println("File/Dir exists: " + Files.exists(path));
        System.out.println("is File  " + Files.isRegularFile(path));
        System.out.println(Files.size(path));

        //Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
        //
        //});

        Path p1 = Paths.get("//Users//swapnil.suhane");
        Path p2 = Paths.get("Usersd");
        System.out.println("resolve method: " + p1.resolve(p2));

        Path p3 = Paths.get(new URI("filse:///e:/temp"));



    }
}
