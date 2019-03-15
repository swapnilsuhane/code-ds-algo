package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.home")+"/Swapnil");
        System.out.println("path tostring: " +path.toString());
        System.out.println("path file system: " +path.getFileSystem());
        System.out.println("path name(0): " + path.getName(0));
        System.out.println("path name(1): " + path.getName(1));
        path.forEach(t -> System.out.println("dir list from root: "  +t));

        path.iterator().forEachRemaining(c -> System.out.println( "for each remaining " +c));

        //Files.list(path).forEach(f -> System.out.println("files in this dir: " + f));

        Path path1 = Paths.get("//Users");

        System.out.println("path 0 " +path1.getName(0));

        Path p1 = Paths.get("Users/swapnil.suhane");
        Path p2 = Paths.get("tex.txt");
        Path p3 = p1.relativize(p2);
        Path p4 = p1.resolve(p2);

        System.out.println("relativize: " + p3);

        System.out.println("resolve: " + p4);


    }

}
