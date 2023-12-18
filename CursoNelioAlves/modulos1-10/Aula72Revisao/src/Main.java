import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double dollarPrice;
        double dollarsToBeBought;

        System.out.println("What is the dollar price?");
        dollarPrice = sc.nextDouble();

        System.out.println("How many dollars will be bought?");
        dollarsToBeBought = sc.nextDouble();

        double reais = CurrencyConverter.converter(dollarPrice, dollarsToBeBought);

        System.out.printf("Amount to be paid in reais: %.2f", reais);

    }
}