import entities.PessoaDesenvolvedoraBackEnd;
import entities.PessoaDesenvolvedoraFrontEnd;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        PessoaDesenvolvedoraBackEnd pessoaDevBack = new PessoaDesenvolvedoraBackEnd(
                "kamila",
                "java",
                40000.00);

        pessoaDevBack.codar();

        PessoaDesenvolvedoraFrontEnd pessoaDevFront = new PessoaDesenvolvedoraFrontEnd(
                "Júlia",
                "Javascript",
                20000.00);

        pessoaDevFront.codar();



    }
}