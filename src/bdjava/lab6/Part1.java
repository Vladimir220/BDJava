package bdjava.lab6;

import java.util.ArrayList;
import static java.lang.System.out;

public class Part1 {
    public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(3);
            list.add(-2);
            list.add(4);
            list.add(-1);
            list.add(-5);
            list.add(0);
            list.add(2);

            int size = list.size();
            int j = 0;
            for (int i = 0; i < size; i++) {
                int element = list.get(j);
                if (element < 0) {
                    list.remove(j);
                    list.add(element);
                } else {
                    j++;
                }
            }
            out.println(list);
    }
}
