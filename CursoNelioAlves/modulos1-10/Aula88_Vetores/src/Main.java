import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = sc.nextInt();

        double[] alturas = new double[numero];

        for (int i = 0; i < numero; i++) {
            System.out.println("Digite uma altura:");
            alturas[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0; i < numero; i++) {
            soma += alturas[i];
        }

        double media = soma/numero;

        System.out.printf("A média das alturas é de %.2f cm", media);

    }
}