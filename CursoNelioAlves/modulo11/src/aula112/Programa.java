package aula112;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Programa {

    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2022-08-10");
        LocalDateTime d05 = LocalDateTime.parse("2022-08-10T01:30:26");
        Instant d06 = Instant.parse("2022-08-10T01:30:26Z");

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println(r1);
        System.out.println(r2);

        System.out.println(d04.getDayOfMonth());
        System.out.println(d04.getDayOfWeek());
        System.out.println(d04.getMonth());
        System.out.println(d04.getMonthValue());
        System.out.println(d04.getYear());
        System.out.println(d04.getDayOfYear());

    }

}
