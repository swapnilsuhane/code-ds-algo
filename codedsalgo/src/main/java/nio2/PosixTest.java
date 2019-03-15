package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

//get file owner details
public class PosixTest {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/Users/swapnil.suhane/test.txt");
        PosixFileAttributes attributes = Files.getFileAttributeView(file, PosixFileAttributeView.class).readAttributes();

        System.out.format("%s %s", attributes.owner().getName(), PosixFilePermissions.toString(attributes.permissions()));

        //Files.getFileAttributeView(file, PosixFileAttributeView.class).setGroup(UserPrincipal);
    }
}
