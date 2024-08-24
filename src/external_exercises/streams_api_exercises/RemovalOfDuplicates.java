package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//remove all duplicate elements from a list using streams.
public class RemovalOfDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }
}
