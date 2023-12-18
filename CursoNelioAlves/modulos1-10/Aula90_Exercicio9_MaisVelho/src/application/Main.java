package application;

import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quantas pessoas você vai digitar? ");
        int n = sc.nextInt();

        Pessoa[] nomes = new Pessoa[n];
        Pessoa[] idades = new Pessoa[n];

        for(int i = 0; i < n; i++){
            System.out.printf("Dados da %dª pessoa: ", i + 1);
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();
            nomes[i] = new Pessoa(nome);
            idades[i] = new Pessoa(idade);
        }



    }
}