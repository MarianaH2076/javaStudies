package aula114;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Programa {

    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2022-08-10");
        LocalDateTime d05 = LocalDateTime.parse("2022-08-10T01:30:26");
        Instant d06 = Instant.parse("2022-08-10T01:30:26Z");

        LocalDate pastWeekLD = d04.minusWeeks(1);
        LocalDate nextWeekLD = d04.plusWeeks(2);

        System.out.println(d04);
        System.out.println(pastWeekLD);
        System.out.println(nextWeekLD);

    }

}
