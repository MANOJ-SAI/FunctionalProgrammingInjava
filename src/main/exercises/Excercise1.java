package main.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

// The operations which are return the stream type then it is intermediate operation
//Intermediate Operations like map,filter, distinct, sorted, etc. These return the stream type values.

// The operations which are return other than a stream type those are terminal operations.
//Terminal Operations like forEach(return void type),reduce(return specific return type), collect, etc.
public class Excercise1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tMenu");
        System.out.println("1. printOddNumbers");
        System.out.println("2. printAllCourseIndividually");
        System.out.println("3. printCourseContainingSpringWord");
        System.out.println("4. printCourseNameContainingLettersCountAtLeast4");
        System.out.println("5. printSquaresOfAllEvenNumbers");
        System.out.println("6. printCubeOfAllOddNumbers");
        System.out.println("7. NoOfCharactersInEachCourseName");
        System.out.println("8. printSumOfSquaresOfAllNumbers");
        System.out.println("9. printSumOfCubeOfAllNumbers");
        System.out.println("10. printSumOfAllOddNumbers");
        System.out.println("11. printUniqueNumbersInList");
        System.out.println("12. printSortedNumbersInList");
        System.out.println("13. printUniqueAndSortedNumbersInList");
        System.out.println("14. printReverseSortedElementsInList");
        System.out.println("15. printAscendingSortedElementsInList");
        System.out.println("16. printSortedByLengthOfElementsInList");
        System.out.println("17. creationOfListWithFilteredEvenNumbers");
        System.out.println("18. creationOfListWithLengthOfElementsInList");
        System.out.println("19. functionalInterfaceForReduceMethod");
        System.out.println("20. BehaviorParameterizationForMappingLogic");
        System.out.println("\nEnter the Choice:");
        int opt = sc.nextInt();

        List<Integer> numbers = List.of(1, 2, 3, 4, 1, 5, 6, 2);


        List<String> courses = List.of("Spring", "Spring Boot", "API",
                "Micro services", "AWS", "Azure", "Docker");

        switch (opt) {
            case 1:
                printOddNumbers(numbers);
                break;
            case 2:
                printAllCourseIndividually(courses);
                break;
            case 3:
                printCourseContainingSpringWord(courses);
                break;
            case 4:
                printCourseNameContainingLettersCountAtLeast4(courses);
                break;
            case 5:
                printSquaresOfAllEvenNumbers(numbers);
                break;
            case 6:
                printCubeOfAllOddNumbers(numbers);
                break;
            case 7:
                NoOfCharactersInEachCourseName(courses);
                break;
            case 8:
                printSumOfSquaresOfAllNumbers(numbers);
                break;
            case 9:
                printSumOfCubeOfAllNumbers(numbers);
                break;
            case 10:
                printSumOfAllOddNumbers(numbers);
                break;
            case 11:
                printUniqueNumbersInList(numbers);
                break;
            case 12:
                printSortedNumbersInList(numbers);
                break;
            case 13:
                printUniqueAndSortedNumbersInList(numbers);
                break;
            case 14:
                printReverseSortedElementsInList(courses);
                break;
            case 15:
                printAscendingSortedElementsInList(courses);
                break;
            case 16:
                printSortedByLengthOfElementsInList(courses);
                break;
            case 17:
                creationOfListWithFilteredEvenNumbers(numbers);
                break;
            case 18:
                creationOfListWithLengthOfElementsInList(courses);
                break;
            case 19:
                functionalInterfaceForReduceMethod(numbers);
                break;
            case 20:
                System.out.println("BehaviorParameterizationForMappingLogic:");
                System.out.println("squares:");
                BehaviorParameterizationForMappingLogic(numbers, x -> x * x);
                System.out.println("sum:");
                BehaviorParameterizationForMappingLogic(numbers, x -> x + x);
                System.out.println("cubes:");
                BehaviorParameterizationForMappingLogic(numbers, x -> x * x * x);
                break;

            default:
                System.out.println("Invalid Option");
        }

    }

    private static void BehaviorParameterizationForMappingLogic(List<Integer> numbers, Function<Integer, Integer> logic) {
        numbers.stream()
                .map(logic)
                .forEach(System.out::println);
    }

    private static void functionalInterfaceForReduceMethod(List<Integer> numbers) {
        System.out.println("functionalInterfaceForReduceMethod:");

        //We use the Binary Operator interface when the input and output return type as same and
        // which accepts 2 inputs and one output that why we didn't declare the different type generics
        // in the declaration of Binary Operator interface
        BinaryOperator<Integer> sum = new BinaryOperator<>() {

            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        System.out.println(numbers.stream()
                .reduce(0, sum));
    }

    private static void creationOfListWithLengthOfElementsInList(List<String> courses) {
        System.out.println("creationOfListWithLengthOfElementsInList:");
        System.out.println(courses.stream()
                .map(String::length)
                .collect(Collectors.toList()));
    }

    private static void creationOfListWithFilteredEvenNumbers(List<Integer> numbers) {
        System.out.println("creationOfWithFilteredEvenNumbers:");
        System.out.println(numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList()));
    }

    private static void printSortedByLengthOfElementsInList(List<String> courses) {
        System.out.println("printSortedByLengthOfElementsInList:");

        courses.stream()
                //here we are sorting the elements based on the length of the elements
                .sorted(Comparator.comparing(String::length)).forEach(System.out::println);

    }

    private static void printOddNumbers(List<Integer> numbers) {
        System.out.println("printOddNumbers:");
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printAllCourseIndividually(List<String> courses) {
        System.out.println("\nprintAllCourseIndividually:");

        courses.stream()
                .forEach(System.out::println);
    }

    private static void printCourseContainingSpringWord(List<String> courses) {
        System.out.println("\nprintCourseContainingSpringWord:");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCourseNameContainingLettersCountAtLeast4(List<String> courses) {
        System.out.println("\nprintCourseNameContainingLettersCountAtLeast4:");

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSquaresOfAllEvenNumbers(List<Integer> numbers) {
        System.out.println("\nprintSquaresOfAllEvenNumbers:");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                //In this scenario, the mapping is useful to perform operation on filtered stream generated value
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    private static void printCubeOfAllOddNumbers(List<Integer> numbers) {
        System.out.println("\nprintCubeOfAllOddNumbers:");

        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);

    }

    private static void NoOfCharactersInEachCourseName(List<String> courses) {
        System.out.println("\nNoOfCharactersInEachCourseName:");

        courses.stream()
                .map(course -> course + " : " + course.length())
                .forEach(System.out::println);


    }

    private static void printSumOfSquaresOfAllNumbers(List<Integer> numbers) {
        System.out.println("\nprintSumOfSquaresOfAllNumbers:");

        System.out.println(numbers.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum));
    }

    private static void printSumOfCubeOfAllNumbers(List<Integer> numbers) {
        System.out.println("\nprintSumOfCubeOfAllNumbers:");

        System.out.println(numbers.stream()
                .map(x -> x * x * x)
                .reduce(0, Integer::sum));

    }

    private static void printSumOfAllOddNumbers(List<Integer> numbers) {
        System.out.println("\nprintSumOfAllOddNumbers:");
        System.out.println(numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum));

    }

    private static void printUniqueNumbersInList(List<Integer> numbers) {
        System.out.println("\nprintUniqueNumbersInList:");
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void printSortedNumbersInList(List<Integer> numbers) {
        System.out.println("\nprintSortedNumbersInList:");

        numbers.stream()
                .sorted().forEach(System.out::println);
    }


    private static void printUniqueAndSortedNumbersInList(List<Integer> numbers) {
        System.out.println("\nprintUniqueAndSortedNumbersInList:");

        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    private static void printReverseSortedElementsInList(List<String> courses) {
        System.out.println("\nprintReverseSortedNumbersInList:");

        courses.stream()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }

    private static void printAscendingSortedElementsInList(List<String> courses) {

        System.out.println("\nprintAscendingSortedElementsInList:");

        courses.stream()
                .sorted(Comparator.naturalOrder()).forEach(System.out::println);

        // we also use the sorted() without comparator
    }
}
