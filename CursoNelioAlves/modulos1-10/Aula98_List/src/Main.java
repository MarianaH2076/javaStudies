import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //iniciação (falta instanciar)
        //List<Integer> list;

        //iniciação e instanciação da forma otimizada do List, com ArrayList
        List<String> list = new ArrayList<>();

        //adição de elementos à lista
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");

        //adição de elementos em uma posição específica da lista
        list.add(2, "Marco");

        for ( String x : list ) {
            System.out.println(x);
        }

        System.out.println("------------------------------");

        //remoção de um elemento específico da lista
        list.remove("Anna");
        //remoção de um elemento específico da lista com seu index
        list.remove(1);

        for ( String x : list ) {
            System.out.println(x);
        }

        System.out.println("------------------------------");

        //função lambda - essa em particular, se chama predicado
        // retorna true or false

        //remoção de elementos específicos da lista, com uma condição
        list.removeIf(x -> x.charAt(0) == 'M');

        for ( String x : list ) {
            System.out.println(x);
        }

        System.out.println("------------------------------");

        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        System.out.println("Index of Marco: " + list.indexOf("Marco"));

        System.out.println("------------------------------");

        list.add("Maria");
        list.add("Alex");
        list.add("Anna");
        list.add(2, "Marco");

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        for ( String x : result ) {
            System.out.println(x);
        }

        System.out.println("------------------------------");

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);

        System.out.println(name);

        String nameJ = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);

        System.out.println(nameJ);

    }
}