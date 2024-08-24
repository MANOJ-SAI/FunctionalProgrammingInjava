package main;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {

        TraditionalApproachForStreamExample.execute();

        FunctionalApproachForStreamExample.execute();

    }
}

// The Traditional Approach is structured approach what we are we using commonly.
class TraditionalApproachForStreamExample {

    // We are using the for loop to iterate the List of Integers
    private static void printAllTheNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    //List.of() is function which is introduced in the java 9.
    public static void execute() {
        System.out.println("Traditional Approach");
        printAllTheNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}


// Below one is the Functional Approach
class FunctionalApproachForStreamExample {

    // Here we are using the stream() which gives the sequence of values.
    // In the below instance, it gives the values like 1,2,3,4... like that.
    // stream() is just giving the sequence of values then we need to tell them what to do
    // in the below we need to print the values. So we use the print method through the
    // forEach because we need to each value that is generated from stream().
    private static void printAllTheNumbers(List<Integer> numbers) {
        numbers.stream()
                .forEach(FunctionalApproachForStreamExample::print);
        //In forEach we used the method reference FunctionalApproach::print which means
        // it referencing to the method called print which is in the FunctionalApproach class
        // print method must be static otherwise it won't work because method reference only work
        // for static methods.

        /// we can also print like below with print method
        // numbers.stream().forEach(System.out::println);
        // here println is the static method
    }

    private static void print(int number) {
        System.out.println(number);
    }

    public static void execute() {
        System.out.println("Functional Approach");
        printAllTheNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}