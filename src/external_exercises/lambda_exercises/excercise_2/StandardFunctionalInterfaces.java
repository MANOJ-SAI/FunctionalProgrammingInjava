package external_exercises.lambda_exercises.excercise_2;

import external_exercises.lambda_exercises.excercise_1.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfaces {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Siva", "Manda", 45),
                new Person("Sai", "Chodavarapu", 23),
                new Person("Naveen", "Marri", 60),
                new Person("Ravi", "Gaara", 30)
        );

        //step-1: sort list by name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        System.out.println("Sorted people:\n" + people);

        System.out.println("\nPrint All persons:");
        printConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println("\nlastName beginning with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));
        System.out.println("\nFirstName beginning with N");
        printConditionally(people, p -> p.getFirstName().startsWith("N"), p -> System.out.println(p.getFirstName()));


    }

    //step-2: create a method that prints all elements in the list
    private static void printAll(List<Person> people) {
        System.out.println("\nPrint all Persons\n");
        for (Person p : people) {
            System.out.println(p);
        }

    }

    //step-3: create a method that prints all people that have condition
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
