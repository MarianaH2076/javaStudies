import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Minutos consumidos: ");
        int minutosConsumidos = sc.nextInt();

        double valorConta = 50.0;

        //se os minutos consumidos forem acima de 100, então a conta muda

        if(minutosConsumidos > 100) {
            valorConta = valorConta + ((minutosConsumidos - 100) * 2);
        } else {
            valorConta = valorConta;
        }

        System.out.printf("Valor a pagar: R$ %.2f%n", valorConta);

        sc.close();

    }
}