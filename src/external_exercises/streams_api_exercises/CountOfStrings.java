package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.List;

//count the number of strings in a list that starts with a specific letter using streams.
public class CountOfStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Count");
        list.add("Of");
        list.add("No. of");
        list.add("Strings");
        list.add("In a List");

        System.out.println(list.stream().filter(p -> p.contains("s")).count());
    }
}
