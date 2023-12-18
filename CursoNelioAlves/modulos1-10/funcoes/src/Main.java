// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String original = "abc DEF ghi abc JLK     ";

        String lowerCase = original.toLowerCase();
        String trim = original.trim();
        String substring = original.substring(2);
        String substring2 = original.substring(2, 6);
        String replace = original.replace("a", "x");
        int index1 = original.indexOf("bc");
        int index2 = original.lastIndexOf("bc");

//        System.out.println("Original: " + original + "-");
//        System.out.println("lowerCase: " + lowerCase + "-");
//        System.out.println("trim: " + trim + "-");
//        System.out.println("substring: " + substring);
//        System.out.println("substring2: " + substring2);
//        System.out.println("replace: " + replace);
        System.out.println("index1: " + index1);
        System.out.println("index2: " + index2);

    }

}

