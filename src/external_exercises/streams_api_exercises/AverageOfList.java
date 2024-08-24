package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.List;

// calculate the average of a list of integers using streams
public class AverageOfList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.stream()
                .mapToDouble(Integer::doubleValue)
                .average().orElse(0.0));

    }

}
