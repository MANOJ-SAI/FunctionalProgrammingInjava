package external_exercises.lambda_exercises.excercise_3;

import external_exercises.lambda_exercises.excercise_1.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Siva", "Manda", 45),
                new Person("Sai", "Chodavarapu", 23),
                new Person("Naveen", "Marri", 60),
                new Person("Ravi", "Gaara", 30)
        );

        System.out.println("Using for Loop:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println("\nUsing for each Loop before java 8:");
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nUsing lambda for each Loop after java 8:");
        people.forEach(System.out::println);


    }
}
