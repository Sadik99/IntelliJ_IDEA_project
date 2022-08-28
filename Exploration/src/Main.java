import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList(
                "flour", "salt", "baking powder", "butter", "eggs", "milk"
        );

//        ingredients.forEach(ingredient -> System.out.println(ingredient));

//        if (ingredients.contains("eggs")) {
//            System.out.println("Dim veje khao!");
//        } else {
//            System.out.println("No eggs. please order foods from outsides..!!");
//        }

        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> printer = sap -> System.out.println(sap);
        array.forEach(printer);
        List<Integer> arrays = Arrays.asList(11, 13, 17, 19);
        arrays.forEach(printer);
        ingredients.forEach(Main::out);
        arrays.forEach(Main::out);
    }
    public static void out(String words){
        System.out.println(words.toUpperCase());
    }

    public static void out(Integer values) {
        System.out.println(values);
    }
}
