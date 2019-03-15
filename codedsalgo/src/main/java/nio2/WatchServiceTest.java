package nio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class WatchServiceTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(System.getProperty("user.home"));

        WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_MODIFY,
            StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Event: " + watchKey.pollEvents().size());

        WatchKey key;
        while( (key = watchService.take()) != null)  {
            List<WatchEvent<?>> events = key.pollEvents();

            for(WatchEvent event : events) {
                System.out.println("Event Occurred:  " + event.kind() + " - " +event.context());
            }

            key.reset();
        }

    }
}
