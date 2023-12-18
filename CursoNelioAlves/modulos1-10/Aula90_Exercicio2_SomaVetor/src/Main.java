import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar?");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < numeros.length; i++){
            System.out.print("Digite um número: ");
            numeros[i] = sc.nextInt();
        }

        System.out.print("VALORES = ");
        for (int i = 0; i < numeros.length; i++){
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        int soma = 0;
        for (int i = 0; i < numeros.length; i++){
            soma += numeros[i];
        }

        System.out.print("SOMA = " + soma);
        System.out.println();

        int media = soma/n;

        System.out.print("MEDIA = " + media);



    }
}