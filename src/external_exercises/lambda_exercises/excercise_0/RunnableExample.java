package external_exercises.lambda_exercises.excercise_0;

public class RunnableExample {
    public static void main(String[] args) {

        Thread nrmlThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Printed Runnable without using lambda");
            }
        });
        nrmlThread.run();

        Thread myThread = new Thread(() -> System.out.println("Printed Runnable using Lambda"));
        myThread.run();
    }
}
