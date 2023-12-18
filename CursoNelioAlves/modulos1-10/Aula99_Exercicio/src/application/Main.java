package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ": ");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idToIncrease = sc.nextInt();
        Integer position = position(list, idToIncrease);
        if (position == null){
            System.out.println("This employee does not exist");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            list.get(position).increaseSalary(percentage);
            System.out.println();
            System.out.println("List of employees: ");
            for (Employee emp: list) {
                System.out.println(emp);
            }
        }

    }

    public static Integer position(List<Employee> list, int id){
        //recebe uma lista de funcionários
        //retorna a posição do funcionário na lista
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

}