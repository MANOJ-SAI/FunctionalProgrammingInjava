package main;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.function.*;


// The Functional Interface has only abstract method, if an interface more than one abstract method then it
// not consider as functional interface, and it won't work for lambda.
// Typically, the one abstract method we called it as the functional descriptor
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> isEvenPredicate = new Predicate<>() {

            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        //In this Function interface has 2 generic types. For input and another one for output type
        Function<Integer, Integer> squareFunction = new Function<>() {

            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Consumer<Integer> print = new Consumer<>() {

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(print);


        //Supplier Interface which gives output without taking input
        Supplier<Integer> randomIntegerSupplier = new Supplier<>() {

            @Override
            public Integer get() {
                Random random = new SecureRandom();
                return random.nextInt(1000);
            }
        };

        System.out.println("\nRandom Integer:" + randomIntegerSupplier.get());


        //UnaryOperator interface takes input and gives the output, but it accepts only one argument(parameter).
        UnaryOperator<Integer> multiplesOfThree = new UnaryOperator<>() {

            @Override
            public Integer apply(Integer integer) {
                return 3 * integer;
            }
        };

        System.out.println("\n3 Multiple of Integer:" + multiplesOfThree.apply(10));


        //BiPredicate Interface is similar to the Predicate interface. In the Predicate interface,
        //   there is just one input and output type boolean. However, in BiPredicate there would be
        //   two inputs and output type boolean
        BiPredicate<Integer, String> calculate = new BiPredicate<>() {

            @Override
            public boolean test(Integer integer, String s) {
                return integer > 10 && s.length() >= 3;
            }
        };
        System.out.println("\nBiPredicate Example :" + calculate.test(11, "AWS"));

        //The BiConsumer interface is similar to the Consumer interface. In the Consumer interface,
        //   there is just one input and output type void. However, in BiConsumer there would be
        //   two inputs and output type void
        BiConsumer<Integer, Integer> biConsumerPrint = new BiConsumer<>() {

            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer);
                System.out.println(integer2);
            }
        };
        System.out.println("\nBiConsumer Example :");
        biConsumerPrint.accept(11, 12);


    }
}
