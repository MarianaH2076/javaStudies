package application;

import entities.Product;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = sc.nextInt();

        Product[] produtos = new Product[numero];

        for (int i = 0; i < produtos.length; i++){
            System.out.println("Digite o nome do produto:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Digite o preço do produto:");
            double price = sc.nextDouble();
            produtos[i] = new Product(name, price);
        }

        double soma = 0.0;
        for (int i = 0; i < produtos.length; i++){
            soma += produtos[i].getPrice();
        }

        double media = soma/numero;

        System.out.printf("A média dos preços é de %.2f", media);

    }
}