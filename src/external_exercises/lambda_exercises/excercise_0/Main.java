package external_exercises.lambda_exercises.excercise_0;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //using the class instance
        Main main = new Main();
        Test t = new Test();
        main.test(t);


        //using the lambda function without creating lambda_exercises.excercise_0.Test class and without instance that why we call it as
        // anonymous function. Here we are using the Interface which consists only one function
        Temp temp = () -> System.out.println("lamba-run");
        main.test(temp);


        // It is also an anonymous function, but it is different compare to lambda expression
        // It uses different internal class (using inner class)
        Temp otherTemp = new Temp() {
            public void run() {
                System.out.println("Different_class-run");
            }
        };
        main.test(otherTemp);
    }

    public void test(Temp t) {
        t.run();
    }
}