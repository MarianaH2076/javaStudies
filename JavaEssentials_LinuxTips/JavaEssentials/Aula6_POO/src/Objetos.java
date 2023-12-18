import entities.Estudante;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Objetos {
    public static void main(String[] args) {

        Estudante kamilaCode = new Estudante();

        kamilaCode.setName("Kamila");
        kamilaCode.setStack("Java e Spring");
        kamilaCode.estudar();
        kamilaCode.dormir();
        System.out.println(kamilaCode.getName());
        System.out.println(kamilaCode.getStack());




    }
}