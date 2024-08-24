package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//sort a list of strings in alphabetical order, ascending and descending using streams
public class SortTheStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sort");
        list.add("The");
        list.add("List");
        list.add("Of");
        list.add("Strings");

        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
