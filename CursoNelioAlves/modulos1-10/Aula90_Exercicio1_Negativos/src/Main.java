import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números você vai digitar?");
        int totalNumeros = sc.nextInt();

        int[] numeros =  new int[totalNumeros];

        for (int i = 0; i < numeros.length; i++){
            sc.nextLine();
            System.out.print("Digite um número: ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("NÚMEROS NEGATIVOS: ");
        for (int i = 0; i < numeros.length; i++){
            if(numeros[i] < 0) {
                System.out.println(numeros[i]);
            }
        }
    }
}