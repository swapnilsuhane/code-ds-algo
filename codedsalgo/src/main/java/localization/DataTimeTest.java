package localization;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DataTimeTest  {

    public static void main(String[] args) {
        System.out.println("Next Tuesday on: " + LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        System.out.println("Next Tuesday on 2: " + TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));

        Instant now = Instant.now();
        System.out.println("Now: " + now);

        Instant now2 = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println("Now 2: " +now2);

    }
}
