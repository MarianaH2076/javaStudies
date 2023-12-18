import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.println("Name: ");
        employee.name = sc.nextLine();
        System.out.println("Gross Salary: ");
        employee.grossSalary = sc.nextDouble();
        System.out.println("Tax: ");
        employee.tax = sc.nextDouble();

        //1 retorna os dados nome e salário líquido
        System.out.println(
                "Emploee: " + employee);

        //2. aumenta o salário bruto do funcionário
        System.out.println("Which percentage to increase salary?");
        double percentage = sc.nextDouble();
        employee.increaseSalary(percentage);

        //3. printa os dados atualizados
        System.out.println("Updated data: " + employee);

    }
}