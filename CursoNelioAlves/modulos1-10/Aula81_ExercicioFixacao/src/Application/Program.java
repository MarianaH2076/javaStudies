package Application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Is there an initial deposit? Y/N");
        char answer = sc.next().charAt(0);

        if (answer == 'y' || answer == 'Y'){
            System.out.println("Enter initial value: ");
            double initialDepositValue = sc.nextDouble();
            account = new Account(accountNumber, name, initialDepositValue);
        } else {
            account = new Account(accountNumber, name);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account.toString());

        System.out.println();
        System.out.println("Enter a deposit value: ");
        double depositValue = sc.nextDouble();

        account.deposit(depositValue);

        System.out.println();
        System.out.println("Updated account data: ");
        System.out.println(account.toString());

        System.out.println();
        System.out.println("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdrawal(withdrawValue);

        System.out.println();
        System.out.println("Updated account data: ");
        System.out.println(account.toString());

    }

}
