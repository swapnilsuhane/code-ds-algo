package nio2;

import java.io.IOException;
import java.nio.file.*;

public class PathMatcherTest {

    public static void main(String[] args) throws IOException {

        System.out.println("file system provider: " + FileSystems.getDefault().provider());
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/Users/swapnil.suhane/test.txt");
        System.out.println("dir " + System.getProperty("user.home"));
        Path path = Paths.get(System.getProperty("user.home"));
        //Files.list(path).forEach(System.out::println);

        boolean match = pathMatcher.matches(path);
        System.out.println("matched file:"  + match);


    }
}
