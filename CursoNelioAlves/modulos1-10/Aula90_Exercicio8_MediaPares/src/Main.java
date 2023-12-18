import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        int[] vetor = new int[n];
        int contadorPares = 0;
        int somaPares = 0;

        for(int i = 0; i < vetor.length; i++){
            System.out.print("Digite um número: ");
            sc.nextLine();
            vetor[i] = sc.nextInt();

            if(vetor[i] % 2 == 0){
                somaPares += vetor[i];
                contadorPares++;
            }
        }

        if (contadorPares == 0){
            System.out.println("NENHUM NÚMERO PAR");
        } else {
            double media = ((double)somaPares)/contadorPares;

            System.out.printf("MÉDIA DOS PARES = %.1f\n", media);
        }


    }
}