package external_exercises.lambda_exercises.excercise_3;

import external_exercises.lambda_exercises.excercise_1.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Siva", "Manda", 45),
                new Person("Sai", "Chodavarapu", 23),
                new Person("Naveen", "Marri", 60),
                new Person("Ravi", "Gaara", 30)
        );

        System.out.println("Using Stream for printing the firstName which has the lastName startsWith C");
        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));


        System.out.println("Using Stream for counting the lastName startsWith M");
        long count = people.stream()
                .filter(p -> p.getLastName().startsWith("M"))
                .count();
        System.out.println(count);


        System.out.println("Using Parallel Stream for counting the lastName startsWith M");
        long count1 = people.parallelStream()
                .filter(p -> p.getLastName().startsWith("M"))
                .count();
        System.out.println(count1);
    }
}
