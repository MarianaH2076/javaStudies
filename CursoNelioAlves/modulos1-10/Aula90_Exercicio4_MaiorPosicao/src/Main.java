import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quantos números você vai digitar? ");
        int total = sc.nextInt();

        double[] numeros = new double[total];
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Digite um número: ");
            sc.nextLine();
            numeros[i] = sc.nextInt();
        }

        double maiorValor = 0.0;
        for (int i = 0; i < numeros.length; i++){
            if( maiorValor < numeros[i] ){
                maiorValor = numeros[i];
            }
        }

        System.out.printf("MAIOR VALOR = %.2f\n", maiorValor);

        int posicao = 0;
        for (int i = 0; i < numeros.length; i++){
            if( maiorValor == numeros[i] ){
                posicao = i;
            }
        }

        System.out.println("POSIÇÃO DO MAIOR VALOR = " + posicao);

    }
}