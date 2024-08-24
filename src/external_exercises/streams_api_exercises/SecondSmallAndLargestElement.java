package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//find the second smallest and largest elements in a list of integers using streams.
public class SecondSmallAndLargestElement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.stream().distinct().sorted().skip(1).findFirst().orElse(null));
        System.out.println(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));
    }
}
