package external_exercises.lambda_exercises.excercise_2;

public class ThisReferenceExample {

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        //using the internal class
        thisReferenceExample.doProcess(10, new Process() {

            @Override
            public void process(int i) {
                System.out.println(i);
                System.out.println(this);
            }

            public String toString() {
                return "This reference for the internal Process class instance";
            }
        });


        //Using the lambda expression. In lambda, we are unable to use the 'this' reference because it's not
        // creating any class.In the above one we're creating the Process class instance so that 'this' refers to
        // that class instance. In static method, we are unable to use the 'this' reference because it's not
        // using any class instance.
        thisReferenceExample.doProcess(20, i -> {
            System.out.println(i);
            //System.out.println(this);
        });


        thisReferenceExample.execute();
    }

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    // Here we can use 'this' method, because it's not in the static method and 'this' refers to the
    // instance which is call the executing
    public void execute() {
        doProcess(30, i -> {
            System.out.println(i);
            System.out.println(this);
        });
    }

    public String toString() {
        return "This reference for the main.Main class instance";
    }
}
