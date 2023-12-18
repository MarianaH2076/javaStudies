public class CondicionalTernaria {
    public static void main(String[] args) {

        //FORMA 1 (mais longa)
//        double preco = 34.5;
//        double desconto = null;
//
//        if (preco < 20.0) {
//            desconto = preco * 0.1;
//        }
//        else {
//            desconto = preco * 0.5;
//        }

        //FORMA 2 ( condicional ternária )
        double preco = 34.5;
        double desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.3;

        System.out.println(desconto);

    }
}
