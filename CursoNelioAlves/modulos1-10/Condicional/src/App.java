import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.println(nome);

        sc.close();

    }
}
