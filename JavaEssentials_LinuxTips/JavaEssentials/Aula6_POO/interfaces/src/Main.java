// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Seja bem-vinde ao linux tips bank");
        ContaCorrente ccKamila = new ContaCorrente();

        ccKamila.consultarSaldo();
        ccKamila.fazerPix();

        ContaPoupanca cpKamila = new ContaPoupanca();

        cpKamila.consultarSaldo();
        cpKamila.fazerPix();

    }
}