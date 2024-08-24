package external_exercises.lambda_exercises.excercise_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Condition {
    boolean test(Person p);
}

public class Excercise_1_Java_7Solution {
    public static void main() {
        List<Person> people = Arrays.asList(
                new Person("Siva", "Manda", 45),
                new Person("Sai", "Chodavarapu", 23),
                new Person("Naveen", "Marri", 60),
                new Person("Ravi", "Gaara", 30)
        );

        //step-1: sort list by name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println(people);

        printAll(people);


        printLastNameBeginningWithC(people);


        //using Condition interface for customized conditions without writing the code multiple times
        // In the printLastNameBeginningWithC method we are only using the lastName startsWith C condition.
        // if we need it for FirstName then we need to write a new method again then condition for firstName.
        //In the below printConditionally method we are passing the condition behaviour based on that it's print
        // the values
        printConditionally(people, new Condition() {

            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("S");
            }
        });

        printConditionally(people, new Condition() {

            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("N");
            }
        });


    }

    //step-2: create a method that prints all elements in the list
    private static void printAll(List<Person> people) {
        System.out.println("\nPrint all Persons\n");
        for (Person p : people) {
            System.out.println(p);
        }

    }

    //step-3: create a method that prints all people that have last name beginning with C
    private static void printLastNameBeginningWithC(List<Person> people) {
        System.out.println("\nprint LastName Beginning With C\n");
        for (Person p : people) {
            if (p.getLastName().startsWith("C")) {
                System.out.println(p);
            }
        }
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        System.out.println("\nprint Conditionally\n");
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }
        }
    }


}