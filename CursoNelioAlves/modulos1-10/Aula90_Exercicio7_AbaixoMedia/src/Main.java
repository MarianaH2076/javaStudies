import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        double media = 0.0;
        double soma = 0.0;

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        double[] vetor = new double[n];
        for(int i = 0; i < vetor.length; i++){
            System.out.print("Digite um número: ");
            sc.nextLine();
            vetor[i] = sc.nextDouble();
            soma += vetor[i];
        }

        media = soma/n;
        System.out.printf("MÉDIA DO VETOR = %.3f\n", media);

        System.out.println("ELEMENTOS ABAIXO DA MÉDIA: ");
        for(int i = 0; i < vetor.length; i++){
            if( vetor[i] < media ){
                System.out.println(vetor[i]);
            }
        }








    }
}