package external_exercises.streams_api_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//convert a list of strings to uppercase or lowercase using streams.
public class ConvertStringToUpperAndLowerCase {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Convert");
        list.add("String");
        list.add("To");
        list.add("UpperCase");
        list.add("And");
        list.add("LowerCase");

        System.out.println(list.stream().map(String::toLowerCase).collect(Collectors.toList()));


        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
}
