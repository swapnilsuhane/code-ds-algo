package core;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date: " + date.toString());
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDate);
        System.out.println(localTime);

        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.getNano());
        System.out.println(LocalTime.of(10, 10, 10));
        System.out.println(LocalTime.parse("10:10:11"));
        System.out.println(LocalTime.from(localTime));

        System.out.println(localDateTime.with(localDate.atTime(10,10)));
        System.out.println(localDate.minusMonths(1));
        System.out.println(localDate.minus(10, ChronoUnit.MONTHS));
        System.out.println(localDate.minus(Period.ofDays(10)));
        System.out.println(localDate.minusYears(33));

        ZoneOffset zoneOffset = ZoneOffset.of("+05:30");
        OffsetTime offsetTime = OffsetTime.now();
        System.out.println(offsetTime.getOffset().getId());
        offsetTime.withOffsetSameInstant(zoneOffset);
        System.out.println(offsetTime);

        Period period = Period.of(0, 9, 1);
        System.out.println(period);

        Duration duration = Duration.between(LocalTime.of(10,10,10), LocalTime.now());
        System.out.println(duration);

        ChronoLocalDateTime chronoLocalDateTime = ChronoLocalDateTime.from(localDateTime);
        System.out.println(chronoLocalDateTime);

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(localDateTime);

    }
}
