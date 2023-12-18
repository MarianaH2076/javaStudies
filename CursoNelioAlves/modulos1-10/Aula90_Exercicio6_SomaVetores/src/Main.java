import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quantos valores vai ter cada vetor? ");
        int n = sc.nextInt();

        int[] vetorA = new int[n];
        int[] vetorB = new int[n];
        int[] vetorC = new int[n];

        System.out.println("Digite os valores do vetor A:");
        for(int i = 0; i < vetorA.length; i++){
            sc.nextLine();
            vetorA[i] = sc.nextInt();
        }

        System.out.println("Digite os valores do vetor B:");
        for(int i = 0; i < vetorA.length; i++){
            sc.nextLine();
            vetorB[i] = sc.nextInt();
        }

        System.out.println("VETOR RESULTANTE: ");
        for(int i = 0; i < vetorA.length; i++){
            vetorC[i] = vetorA[i] + vetorB[i];
            System.out.println(vetorC[i]);

        }



    }
}