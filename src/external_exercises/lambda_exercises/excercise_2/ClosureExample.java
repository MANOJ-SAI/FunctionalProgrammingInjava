package external_exercises.lambda_exercises.excercise_2;

interface Process {
    void process(int i);
}

public class ClosureExample {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        doProcess(a, p -> System.out.println(p + b));


    }

    public static void doProcess(int a, Process p) {
        p.process(a);
    }
}