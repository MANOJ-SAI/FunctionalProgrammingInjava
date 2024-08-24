package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.List;

//calculate the sum of all even, odd numbers in a list using streams
public class SumOfEvenOdd {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.stream().filter(p -> p % 2 == 0).mapToInt(Integer::intValue).sum());

        System.out.println(list.stream().filter(p -> p % 2 != 0).mapToInt(Integer::intValue).sum());
    }
}
