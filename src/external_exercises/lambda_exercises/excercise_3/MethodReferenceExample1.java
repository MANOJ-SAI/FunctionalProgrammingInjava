package external_exercises.lambda_exercises.excercise_3;

public class MethodReferenceExample1 {
    public static void main(String[] args) {

        //using normal lambda expression
        Thread t = new Thread(() -> execute());
        t.run();


        //Method Reference
        // We use the method reference for when the both the input and passing parameters to the method is same
        //()->execute() == MethodReferenceExample1::execute
        Thread t1 = new Thread(MethodReferenceExample1::execute);
        t1.run();

    }

    public static void execute() {
        System.out.println("Hello World");
    }
}
