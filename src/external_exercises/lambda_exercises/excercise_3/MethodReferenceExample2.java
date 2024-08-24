package external_exercises.lambda_exercises.excercise_3;

import external_exercises.lambda_exercises.excercise_1.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Siva", "Manda", 45),
                new Person("Sai", "Chodavarapu", 23),
                new Person("Naveen", "Marri", 60),
                new Person("Ravi", "Gaara", 30)
        );


        System.out.println("\nPrint All persons:");
        //method reference syntax: instance::static-method
        // In below one System.out is instance and println is static-method
        printConditionally(people, p -> true, System.out::println);

    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
