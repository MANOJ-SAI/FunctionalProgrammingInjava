package external_exercises.lambda_exercises.excercise_2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4, 5};
        int key = 1;

        // we can write the try-catch here also like below, but it does not elegant to look as single line
//        process(someNumbers,key,(s,k)->{
//            try{
//                System.out.println(s/k);
//            }catch(ArithmeticException e){
//                System.out.println("Exception raises by lambda");
//            }
//        });


        // So we are using another lambda (wrapper lambda) for handling the exception.
        process(someNumbers, key, wrapperLambda((s, k) -> System.out.println(s / k)));
    }


    //In wrapper lambda, we can write any other required statement before execution of the main lambda.
    // It is like OAuth for the main lambda
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biconsumer) {
        return (s, k) -> {
            try {
                biconsumer.accept(s, k);
            } catch (ArithmeticException e) {
                System.out.println("Exception raises in wrapper lambda");
            }
        };
    }


    //This is similar to the above wrapperLambda. In wrapperLambda it accepts only the Integer.
    // The below genericWrapperLambda accepts any type.
    private static <T, U> BiConsumer<T, U> genericWrapperLambda(BiConsumer<T, U> biconsumer) {
        return (t, u) -> {
            try {
                biconsumer.accept(t, u);
            } catch (ArithmeticException e) {
                System.out.println("Exception raises in wrapper lambda");
            }
        };
    }


    // We can also write try-catch block in the process method So we don't know what is the input that passed
    // in biconsumer this might be a different operation and arithmetic exception doesn't apply. So when we use this,
    // it's catch to every specific to the operation. So it's not the right way to handle it.
    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biconsumer) {
        for (int i : someNumbers) {
            biconsumer.accept(i, key);
        }
    }


}
