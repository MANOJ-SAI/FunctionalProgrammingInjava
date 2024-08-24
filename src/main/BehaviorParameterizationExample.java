package main;

import java.util.List;
import java.util.function.Predicate;

// The Behavior Parametrization is nothing but passing the logic of the method as argument of the method.
// This will provide a lot of flexibility
public class BehaviorParameterizationExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("Even-Numbers:");
        filterAndPrint(numbers, x -> x % 2 == 0);
        System.out.println("\nOdd-Number:");
        filterAndPrint(numbers, x -> x % 2 != 0);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
