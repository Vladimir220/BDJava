package bdjava.lab9;
import java.util.ArrayList;
//2. Задана коллекция строк.
// Вернуть первый элемент коллекции, а также существуют ли все совпадения с шаблоном. Шаблон можно выбрать произвольно.
public class Part1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("ahjjhe");
        strings.add("adrtyufxgte");

        String pattern = "a\\w+e";

        String firstElement = strings.stream().findFirst().orElse(null);
        boolean isAll = strings.stream().allMatch(s -> s.matches(pattern));

        System.out.println("First element: " + firstElement);
        System.out.println("All match: " + isAll);
    }
}
