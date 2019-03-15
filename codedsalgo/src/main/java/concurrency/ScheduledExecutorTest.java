package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

class ScheduledExecutorTest {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
            () -> System.out.println("beep"), 2, 2, SECONDS);
        scheduler.schedule(() -> beeperHandle.cancel(true),
            60 * 60, SECONDS);
    }

    public static void main(String args[]) { new ScheduledExecutorTest().beepForAnHour(); }
}
