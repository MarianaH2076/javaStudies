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

        int[] numeros = new int[total];
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Digite um número: ");
            sc.nextLine();
            numeros[i] = sc.nextInt();
        }

        int contador = 0;
        System.out.println("NÚMEROS PARES:");
        for (int i = 0; i < numeros.length; i++){

            if(numeros[i] % 2 == 0){
                System.out.print(numeros[i] + " ");
                contador++;
            }

        }

        System.out.println();
        System.out.print("QUANTIDADE DE PARES = " + contador);

    }
}