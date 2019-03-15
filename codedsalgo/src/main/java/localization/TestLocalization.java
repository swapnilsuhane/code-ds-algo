package localization;

import java.security.acl.LastOwnerException;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class TestLocalization {

    public static void main(String[] args) {

        Locale locale = new Locale("hi", "IN");
        System.out.println(locale.getDisplayLanguage() + " - " + locale.getDisplayCountry());

        Locale japan = Locale.JAPAN;
        System.out.println(japan.getDisplayLanguage() + " - " + japan.getDisplayCountry());

        Locale japanese = Locale.JAPANESE;
        System.out.println(japanese.getDisplayLanguage() + " - " + japanese.getDisplayCountry());

        Locale us = Locale.forLanguageTag("en-US");
        System.out.println(us.getDisplayLanguage() + "  - " + us.getDisplayCountry());

        Locale[] numberLocales = NumberFormat.getAvailableLocales();
        Locale[] dateLocales = DateFormat.getAvailableLocales();
        Locale[] locales = Locale.getAvailableLocales();

        System.out.println("number locales: ");
        Arrays.asList(numberLocales).stream().map(l -> l + ", ").forEach(System.out::print);
        System.out.println("\n\ndate locales: ");
        Arrays.asList(dateLocales).stream().map(l -> l + ", ").forEach(System.out::print);
        System.out.println("\n\nlocales: ");
        Arrays.asList(locales).stream().map(l -> l + ", ").forEach(System.out::print);

        Locale defaultLocale = Locale.getDefault();
        System.out.println("\n\n default locale - " + defaultLocale);

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("hi-IN"));
        System.out.println(numberFormat.format(12345.67));
        System.out.println(numberFormat.getCurrency());
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-IN"));
        System.out.println(currencyFormat.format(10200.45));

        LocalDateTime now  = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("Local data time formatted" + dateTimeFormatter.format(now));

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", Locale.forLanguageTag("hi-In"));
        System.out.println("Customized data time formatted" + dateTimeFormatter1.format(now));

        DateFormat dateFormat = DateFormat.getDateTimeInstance(3, 1);
        System.out.println("data format with style nos" + dateFormat.format(Date.from(now.toInstant(ZoneOffset.UTC))));

        Locale.setDefault(Locale.JAPAN);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(simpleDateFormat.format(new Date()));

        DecimalFormat decimalFormat = new DecimalFormat("00000.00");
        System.out.println(decimalFormat.format(123456.6789));

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("^");
        decimalFormatSymbols.setDecimalSeparator('@');

        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        System.out.println(decimalFormat.format(1234.4567));


    }

}
