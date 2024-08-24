package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;


    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

// The intermediate Stream operations like map,filter, etc. are lazy.
// So we use the terminal operations to get the result
public class CustomClass {

    public static void main(String[] args) {

        // List.of() is immutable collection, we didn't replace the values
        List<Course> courses = List.of(
                new Course("Spring", "FrameWork", 98, 20000),
                new Course("SpringBoot", "FrameWork", 95, 18000),
                new Course("API", "MicroServices", 97, 22000),
                new Course("MicroServices", "MicroServices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );


        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        // allMatch: if all review scores of the courses list greater than 95 then return true otherwise false
        System.out.println("allMatch: " + courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        // noneMatch: if any one of the review scores of courses list less than 90 then return false otherwise true
        System.out.println("noneMatch: " + courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        // anyMatch: if any one of the review scores of courses list greater than 90 then return true otherwise false
        System.out.println("anyMatch: " + courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));


        // comparing the courses by using the NoOfStudents in Ascending Order
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        System.out.println("\ncomparing the courses by using the NoOfStudents in Ascending Order: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList())
        );

        // comparing the courses by using the NoOfStudents in Descending Order
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println("\ncomparing the courses by using the NoOfStudents in Descending Order: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList())
        );


        // comparing the courses by using the NoOfStudents and NoOfReviews in Descending Order
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews =
                Comparator.comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();
        System.out.println("\ncomparing the courses by using the NoOfStudents and NoOfReviews in Descending Order: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList())
        );

        System.out.println("\nCourses:\n" + courses);

        // limit: It is used to limit the values in a result
        System.out.println("\nlimit:\n" +
                courses.stream()
                        .limit(5)
                        .collect(Collectors.toList())
        );


        // skip: It is used to skip the values in a result
        System.out.println("\nskip:\n" +
                courses.stream()
                        .skip(5)
                        .limit(2)
                        .collect(Collectors.toList())
        );

        // takeWhile: It gives the result until the given predicate function condition is failed and
        // skip all the after the predicate function condition is failed
        System.out.println("\ntakeWhile:\n" +
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );


        // dropWhile: It gives the result after the given predicate function condition is failed and
        // skip all the before the predicate function condition is failed
        // It is opposite to the takeWhile
        System.out.println("\ndropWhile:\n" +
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );


        // max: returns the last element of the list
        System.out.println("\nmax:\n" +
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(null)
        );

        // min: returns the first element of the list
        System.out.println("\nmin:\n" +
                courses.stream()
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        // if didn't use the orElse, it returns the Optional value.
                        .orElse(null)
        );


        // findFirst: returns the first element
        System.out.println("\nfindFirst:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .findFirst()
                        .orElse(null)
        );

        // findAny: returns the first element
        System.out.println("\nfindAny:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
                        .orElse(null)
        );


        // sum: sum of the elements
        System.out.println("\nsum:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );

        // average: average of the elements
        System.out.println("\naverage:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        // count: count of the elements
        System.out.println("\ncount:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );

        // max: get the maximum value in the result
        System.out.println("\nmapInt-max:\n" +
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );

        // Collectors.groupingBy: grouping the elements
        System.out.println("\nCollectors.groupingBy:\n" +
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );


        // Collectors.counting(): counting the grouping elements
        System.out.println("\nCollectors.counting:\n" +
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        //Collectors.mapping(): It is used to mapping the values to groupingBy
        //  In the below example it collects the courseName as a List and assign it to the groupingBy course Category
        // output:
        // {MicroServices=[API, MicroServices], Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], FrameWork=[Spring, SpringBoot]}
        System.out.println("\nCollectors.mapping:\n" +
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );


        System.out.println("\nCollectors.joining:\n" +
                courses.stream().map(Course::getName)
                        .collect(Collectors.joining(","))
        );

        System.out.println("\nSplit:\n" +
                        courses.stream().map(course -> course.getName().split(""))
                                .collect(Collectors.toList())

                // The map operation of above code is stream the String arrays
                // Generally map function are stream of characters
                // the above code returns the object So we use the flatmap to flatten the stream
        );


        System.out.println("\nflatMap:\n" +
                courses.stream()
                        .map(course -> course.getName().split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList())
        );


        List<Course> courses2 = List.of(
                new Course("Spring", "FrameWork", 98, 20000),
                new Course("SpringBoot", "FrameWork", 95, 18000),
                new Course("API", "MicroServices", 97, 22000),
                new Course("MicroServices", "MicroServices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );


        System.out.println("\nExercise:\n" +
                courses.stream().flatMap(course -> courses2.stream()
                                .filter(course2 -> course2.getName().length() == course.getName().length())
                                .map(course2 -> List.of(course.getName(), course2.getName())))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );


        //Higher Order Function: It is a function that returns the function.
        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutOffReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutOffReviewScore(90);


        //Improving performance with Parallelization of Streams
        long time = System.currentTimeMillis();

        System.out.println("\nParallel: ");
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());

        System.out.println(System.currentTimeMillis() - time);


        List<String> course3 = courses.stream().map(Course::getName).collect(Collectors.toList());

        //replaceAll
        course3.replaceAll(String::toUpperCase);
        System.out.println("\nreplaceAll:" + course3);

        //removeIf
        course3.removeIf(str -> str.length() < 6);
        System.out.println("\nremoveIf:" + course3);

    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }
}
