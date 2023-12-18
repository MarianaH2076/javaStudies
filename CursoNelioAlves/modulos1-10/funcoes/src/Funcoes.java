import java.util.Scanner;

public class Funcoes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite 3 números: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int higher = max(a, b, c);

        showResult(higher);

        sc.close();
    }

    //public: para ser chamada em outras funções
    //static: para poder ser usada sem instanciar
    public static int max(int a, int b, int c){

        int aux;

        if(a > b && a > c) {
            aux = a;
        }
        else if ( b > c) {
            aux = b;
        }
        else {
            aux = c;
        }

        return aux;
    }

    public static void showResult(int value) {
        System.out.println("Higher: " + value);
    }

}
