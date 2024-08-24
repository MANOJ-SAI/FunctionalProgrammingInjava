package main;

import java.util.List;

public class SumUsingReduceExample {
    public static void main(String[] args) {

        TraditionalApproachForSumExample.execute();
        FunctionalApproachForSumExample.execute();
    }
}

class TraditionalApproachForSumExample {

    private static void printSumOfTheNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    public static void execute() {
        System.out.println("Traditional Approach");
        printSumOfTheNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}


// Below one is the Functional Approach
class FunctionalApproachForSumExample {

    //Reduce is nothing but taking the list of value and produce one result which combine them into 1 result
    //reduce 1st parameter indicates the starting or initial value.
    // Another one is function behavior what we need to perform
    // In below a scenario we are adding the values in list so, initial it is 0
    private static void printSumOfTheNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .reduce(0, FunctionalApproachForSumExample::sum));
    }


//    private static void printSumOfTheNumbers(List<Integer> numbers) {
//            System.out.println(numbers.stream()
//                    .reduce(0, Integer::sum));
//        }

    private static int sum(int a, int b) {
        return a + b;
    }


    public static void execute() {
        System.out.println("Functional Approach");
        printSumOfTheNumbers(List.of(1, 2, 3, 4, 1, 5, 6, 2));
    }

}