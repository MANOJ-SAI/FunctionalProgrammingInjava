# Functional Interfaces:

1) **Function Interface:** <br>
   Taking an input and giving output is the Function Interface.
   ```
   Example:
   
        Function<Integer, Integer> squareFunction = new Function<>(){
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };
   
        numbers.stream()
               .map(squareFunction)
               .forEach(System.out::println);
   
   ```
   ```
   Example using Lambda:
   
     Function<Integer, Integer> squareFunction = x -> x*x;
   
     numbers.stream()
            .map(squareFunction)
            .forEach(System.out::println);
   ```
   In this Function interface, the interface has two generic types for an input and output type.
   The Example prints square of integers in the List numbers.
   <br>
   <br>
2) **Consumer Interface:**<br>
   Taking an input and no output is the Consumer Interface, which means output is a void return type.
   ```
   Example:

        Consumer<Integer> print = new Consumer<>(){

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
   

        numbers.stream()
               .map(x -> x*x)
               .forEach(print);
   ```
   ```
   Example using Lambda:
   
     Consumer<Integer> print = System.out::println;
     numbers.stream()
            .map(x -> x*x)
            .forEach(print);
   ```
   In this Consumer interface, the interface has only one generic type for input.
   The Example prints square of integers in the List numbers.
   <br>
   <br>
3) **Binary Operator Interface:**<br>
   Taking an input and giving output is the Binary Operator Interface with the same return type.
    ```
   Example:
   
            BinaryOperator<Integer> sum = new BinaryOperator<>(){
    
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer+integer2;
                }
            };
   
            System.out.println(numbers.stream()
                    .reduce(0, sum));
    ```
   ```
   Example using Lmbda:
   
         BinaryOperator<Integer> sum = (x,y) -> x+y;
         
         System.out.println(numbers.stream()
                    .reduce(0, sum));
   ```
   The Binary Operator interface is extending the BiFunction interface.
   simply it is using the abstract method of BiFunction method.
   but BiFunction and Binary Operator interfaces are different.
   The Example is returns the sum of all integers in the List numbers.<br><br>
4) **Supplier Interface:**<br>
   The Supplier Interface is used at when we have scenario like no input and returns output.
   ```
   Example:
   
        Supplier<Integer> randomIntegerSupplier= new Supplier<>(){

            @Override
            public Integer get() {
                Random random= new Random();
                return random.nextInt(1000);
            }
        };

        System.out.println("\nRandom Integer:"+randomIntegerSupplier.get());
    ```
   ```
   Example using Lambda:
            Supplier<Integer> randomIntegerSupplier= () -> {
                 Random random= new Random();
                 return random.nextInt(1000);
           };
   
           System.out.println("\nRandom Integer:"+randomIntegerSupplier.get());
   ```
   The Example returns the random integer which is less than 1000.
   <br><br>
5) **Unary Operator Interface:**<br>
   The Unary Operator takes input and gives the output, but it accepts only one argument(parameter).
   ```
   Example:
   
        UnaryOperator<Integer> multiplesOfThree= new UnaryOperator<>(){

            @Override
            public Integer apply(Integer integer) {
                return 3*integer;
            }
        };

        System.out.println("\n3 Multiple of Integer:"+multiplesOfThree.apply(10));
    ```
   ```
   Example using Lambda:
        UnaryOperator<Integer> multiplesOfThree= x -> x*3;
        
        System.out.println("\n3 Multiple of Integer:"+multiplesOfThree.apply(10));
   ```
   The BinaryOperator and UnaryOperator are a little bit similar
   like both are accepts the same return type of input and output,
   but Binary Operator Interface accepts the two inputs, in UnaryOperator Interface it accepts only one input.
   The Example the multiple of 3 for 10<br><br>
6) **Predicate Interface:** <br>
   Taking an input and giving boolean valued output is the Function Interface.
   ```
   Example:
   
        Predicate<Integer> isEvenPredicate = new Predicate<>(){
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
   
        numbers.stream()
               .filter(isEvenPredicate)
               .forEach(System.out::println);
   ```
   ```
   Example using Lambda:
   
     Predicate<Integer> isEvenPredicate = x -> x%2==0;
   
     numbers.stream()
            .filter(isEvenPredicate)
            .forEach(System.out::println);
   ```
   The Example prints only even numbers of the list numbers.<br><br>
7) **BiPredicate Interface:**<br>
   The BiPredicate interface is similar to the Predicate interface. In Predicate interface
   there is just one input and output type boolean. However, in BiPredicate there would be
   two inputs and output type boolean
   ```
   Example:
   
         BiPredicate<Integer,String> calculate= new BiPredicate<>(){

            @Override
            public boolean test(Integer integer, String s) {
                return integer>10 && s.length()>=3;
            }
        };

        System.out.println("\nBiPredicate Example :"+calculate.test(11,"AWS"));
   ```
   ```
   Example using Lambda:
   
        BiPredicate<Integer,String> calculate=(x,y)-> x>10 && y.length()>=3;
   
        System.out.println("\nBiPredicate Example :"+calculate.test(11,"AWS"));
   ```
   The Example returns boolean value as true when the integer value is greater than 10 and string length is greater
   than are equal to 3 otherwise false.<br><br>
8) **BiConsumer Interface:**<br>
   The BiConsumer interface is similar to the Consumer interface. In Consumer interface
   there is just one input and output type void. However, in BiConsumer there would be
   two inputs and output type void
   ```
   Example:

         BiConsumer<Integer,Integer> biConsumerPrint= new BiConsumer<>(){

         @Override
         public void accept(Integer integer, Integer integer2) {
             System.out.println(integer);
             System.out.println(integer2);
         }
     };

     biConsumerPrint.accept(11,12);
   ```
   ```
   Example Using Lambda:
   
      BiConsumer<Integer,Integer> biConsumerPrint=(x,y)->{
            System.out.println(x);
            System.out.println(y);
      };
   
      biConsumerPrint.accept(11,12);
   ```

+ We have all the above interfaces with primitive datatype that mean the above interfaces using the wrapper class
  not primitive type if we need a primitive type, then we have the below interfaces.
  <br> For an Int type:
    + IntBinaryOperator
    + IntConsumer
    + IntFunction
    + IntPredicate
    + IntSupplier
    + IntToDoubleFunction
    + IntToLongFunction
    + IntToUnaryFunction
      <br>Like that we have those types for Long and Double also
+ When we use Generic interfaces like BiPredicate, BinaryOperator, etc. here we need to do boxing and unboxing
  because we are using the wrapper classes. We don't do any auto-boxing and unboxing when using the primitive type
  interfaces like IntBinaryOperator, LongConsumer, DoublePredicate, etc. So it's better to use primitive approach.