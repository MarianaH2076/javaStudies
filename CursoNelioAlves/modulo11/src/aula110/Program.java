package aula110;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        //Transformando texto em data-hora
        LocalDate d04 = LocalDate.parse("2022-08-10");
        LocalDateTime d05 = LocalDateTime.parse("2022-08-10T01:30:26");
        Instant d06 = Instant.parse("2022-08-10T01:30:26Z");

        //Passando um data-hora e transformando para zulu time
        Instant d07 = Instant.parse("2022-08-10T01:30:26-03:00");

        LocalDate d08 = LocalDate.parse("20/07/2023", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2023 01:30", fmt2);

        LocalDate d10 = LocalDate.of(2023, 8, 10);
        LocalDateTime d11 = LocalDateTime.of(2023, 8, 10, 1, 30);

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        System.out.println(d05);
        System.out.println(d06);
        System.out.println(d07);
        System.out.println(d08);
        System.out.println(d09);
        System.out.println(d10);
        System.out.println(d11);

    }

}
