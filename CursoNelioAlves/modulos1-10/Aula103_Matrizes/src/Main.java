import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println("Main diagonal: ");
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                if (i == j){
//                    System.out.println(matriz[i][j]);
//                }
//            }
//        }

        for (int i = 0; i < n; i++){
            System.out.print(matriz[i][i] + " ");
        }


        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (matriz[i][j] < 0){
                    count++;
                }
            }
        }

        System.out.println();
        System.out.println("Negative numbers: " + count);


    }
}