import entities.Student;

import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.println("What's the student's name?");
        student.name = sc.nextLine();
        System.out.println("1st trimester grade: ");
        student.trimester1 = sc.nextDouble();
        System.out.println("2nd trimester grade: ");
        student.trimester2 = sc.nextDouble();
        System.out.println("3rd trimester grade: ");
        student.trimester3 = sc.nextDouble();

        System.out.printf(
                "FINAL GRADE: %.2f%n",
                student.showFinalGrade()
        );

        if (student.showFinalGrade() < 60){
            System.out.println("FAILED");
            System.out.printf(
                    "MISSING: %.2f POINTS%n",
                    student.missingPoints()
            );
        }
        else {
            System.out.println("PASS");
        }

    }
}