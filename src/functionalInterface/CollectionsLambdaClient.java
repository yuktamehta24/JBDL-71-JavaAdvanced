package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionsLambdaClient {

    public static void main(String[] args) {
        List<Integer> abc = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 1 3 5 7 9
        // 1 9 25 49 81
        // 165


        //find only the odd numbers
        //calculate the square of such numbers
        //sum all the squares and give me the result

        //iterative method of coding
        int sum = 0;
        for(int i =0; i<10; i++) {
            int curr = abc.get(i);
            if (curr%2 ==  1) { //checking/filtering
                int val = curr * curr; // mapping
                sum += val; //computing the final value
            }
        }

        System.out.println("Sum using iterative is: "+ sum);

        //calculate the square of each number
        //find the odd squares
        //sum all the squares and give me the result

        //declarative

//        abc.stream() // 10 //1 //2
//                .filter(new Predicate<Integer>() { //5
//                    @Override
//                    public boolean test(Integer integer) {
//                        System.out.println("Filter integer: "+ integer);
//                        return integer%2 == 1;
//                    }
//                }).map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) {
//                        System.out.println("Map integer: "+ integer);
//                        return integer * integer;
//                    }
//                });

        List<Integer> abc2 = Arrays.asList(3, 4);
        long start = System.currentTimeMillis();
        Optional<Integer> res = abc.stream() // 10 //1 //2
                .filter(new Predicate<Integer>() { //5
                    @Override
                    public boolean test(Integer integer) {
                        System.out.println("Filter integer: "+ integer);
                        return integer%2 == 1;
                    }
                }).map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        System.out.println("Map integer: "+ integer);
                        return integer * integer;
                    }
                }).reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        System.out.println("Reduce integer 1: "+ integer);
                        System.out.println("Reduce integer 2: "+ integer2);
                        return integer+ integer2;
                    }
                });
        long end = System.currentTimeMillis();
        System.out.println("Time taken is: "+ (end-start));

//
//                .reduce(0, new BinaryOperator<Integer>() {
//                    @Override
//                    public Integer apply(Integer integer, Integer integer2) {
//                        System.out.println("Reduce integer 1: "+ integer);
//                        System.out.println("Reduce integer 2: "+ integer2);
//                        return integer + integer2;
//                    }
//                });
        System.out.println("sum using declarative is : "+ res);

        // More readable
        int sum3 = abc.stream()
                .filter(a -> a%2 == 1)
                .map(a -> a*a)
                .reduce(0, (integer, integer2) -> integer+integer2);

        System.out.println("sum using declarative 2 is : "+ sum3);

        // Try for yourself
        // ist<String> abc = Arrays.asList("sadfghjkdfg", "shjs", "", "gsdfghjuikdfg");

        // input => "sadfghjkdfg", "shjs", "", "gsdfghjuikdfg"
        // 1st step => "sadfg", "shjs", "", "gsdfg"
        // 2nd step => "shjs", "gsdfg"
        // expected output -> List("shjs", "gsdfg")

        // calculate the substring of length 5 of each string if length is greater than 5, otherwise the streing as it is
        // only need the strings where the first and the last character is the same
        // return me that list

        List<String> input = Arrays.asList("sadfghjkdfg", "shjs", "", "gsdfghjuikdfg");

        List<String> output = input.stream()
                .map(in -> {
            if (in.length() > 5) {
                return in.substring(0, 5);
            } else {
                return in;
            }
        }).filter(in -> in.length() > 0 && in.charAt(0) == in.charAt(in.length()-1))
        .toList();

        System.out.println("list is: "+ output);

        System.out.println("Current thread is: "+ Thread.currentThread().getName());
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
