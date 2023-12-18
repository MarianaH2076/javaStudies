import java.util.Scanner;
import Entities.Triangle;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Digite os lados do triângulo x: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Digite os lados do triângulo y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        //Agora, com os dados de ambos os triângulos, vâmos calcular a área
            //e para calcular a área a gente precisa calcular p;

        double areaX = x.area();
        double areaY = y.area();

        if (areaX > areaY) {
            System.out.printf("A maior área é do triÂngulo X: %.2f%n", areaX);
        }
        else {
            System.out.printf("A maior área é do triÂngulo Y: %.2f%n", areaY);
        }
        
    }
}