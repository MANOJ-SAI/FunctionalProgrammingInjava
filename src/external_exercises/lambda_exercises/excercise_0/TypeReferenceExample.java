package external_exercises.lambda_exercises.excercise_0;

public class TypeReferenceExample {


    public static void main(String[] args) {
        printLambda(s -> s.length());
    }

    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength("HelloWorld"));

    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
