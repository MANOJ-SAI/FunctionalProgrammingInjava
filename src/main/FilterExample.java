package main;

import java.util.List;

public class FilterExample {
    public static void main(String[] args) {

        TraditionalApproachForFilterExample.execute();

        FunctionalApproachForFilterExample.execute();

    }
}

class TraditionalApproachForFilterExample {

    private static void printEvenNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0)
                System.out.println(number);
        }
    }

    public static void execute() {
        System.out.println("Traditional Approach");
        printEvenNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}


// Below one is the Functional Approach
class FunctionalApproachForFilterExample {

    private static void printEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                // In filter, we are using the lambda expression.
                // We can write without the lambda expression also, but we need to define new method and
                //use the method reference
                // example: .filter(FunctionalApproachForFilterExample::<newly created static method>
                .forEach(System.out::println);
    }


    public static void execute() {
        System.out.println("Functional Approach");
        printEvenNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}