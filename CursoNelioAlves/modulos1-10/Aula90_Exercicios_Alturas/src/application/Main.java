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

        System.out.print("Quantas pessoas serão digitadas? ");
        int numero = sc.nextInt();

        Pessoa[] pessoas = new Pessoa[numero];

        for(int i = 0; i < pessoas.length; i++){
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            sc.nextLine();
            double altura = sc.nextDouble();
            pessoas[i] = new Pessoa(nome, idade, altura);
        }

        int menores = 0;
        double somaAlturas = 0.0;
        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i].getIdade() < 16){
                menores++;
            }
            somaAlturas += pessoas[i].getAltura();
        }

        double mediaAlturas = somaAlturas/numero;
        double percentualMenores = ((double)menores /  numero) * 100.0;
        System.out.printf("Altura média: %.2f\n", mediaAlturas);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentualMenores);

        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i].getIdade() < 16){
                System.out.println(pessoas[i].getNome());
            }
        }

    }
}