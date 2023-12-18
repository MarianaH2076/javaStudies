import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //forma mais comum de declarar arrays:
        int[] arrayDeInt;

        //forma menos comum:
        int arrayDeInt2[];

        //inicialização com tamanho:
        int[] arrayDeInt3 = new int[5];

        //inicialização com preenchimento dos elementos:
        Integer[] arrayDeInt4 = {1, 2, 3, 4, 5};

        //descobrindo o tamanho do array:
        int arraySize = arrayDeInt4.length;

        //percorrendo um array:
        List<Integer> itens = Arrays.asList(arrayDeInt4);

//        System.out.println(itens);
//        itens.forEach(System.out::println);

        //fazendo cópias para percorrer apenas partes dos arrays:
        //copyOfRange
        String[] treinamento = new String[]{
                "treinamento",
                "descomplicando",
                "java",
                "e",
                "spring",
                "da",
                "linux",
                "tips"
        };

        String[] treinamentoNome = Arrays.copyOfRange(treinamento, 1, 8);
        String[] linuxTipsNome = Arrays.copyOfRange(treinamento, 6, 8);
//        List<String> treinamentoNomeList = List.of(treinamentoNome);
//        treinamentoNomeList.forEach(System.out::println);
//        System.out.println(treinamentoNomeList);
//        List<String> linuxTipsNomeList = List.of(linuxTipsNome);
//        linuxTipsNomeList.forEach(System.out::println);

//        String[] arrayCom2 = Arrays.copyOf(treinamento, 2);
//        List<String> arrayCom2List = List.of(arrayCom2);
//        arrayCom2List.forEach(System.out::println);

        //preenchendo um array:
        String[] java = new String[10];

        Arrays.fill(java, "java");
        List<String> javaList = List.of(java);

//        javaList.forEach(System.out::println);

        //operadores lógicos
        int[] arrayDeInt1 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        int[] arrayDeIntDois = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

//        System.out.println("Os arrays são iguais? " + Arrays.equals(arrayDeInt1, arrayDeIntDois));


        //sorted
        String[] sorted = Arrays.copyOf(treinamento, 8);
        Arrays.sort(sorted);
        List<String> sortedList = List.of(sorted);

        sortedList.forEach(System.out::println);


    }
}