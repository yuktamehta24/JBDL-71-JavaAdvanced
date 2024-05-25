package collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        Queue<String> names = new PriorityQueue<>(Comparator.reverseOrder());

        names.add("Pooja");
        names.add("Pooja");
        names.add("Aman");
        names.add("Naina");
        names.add("Ram");

        System.out.println(names);

        System.out.println(names.poll()); //Ram
        System.out.println(names.poll()); //Pooja
        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());

//
//        System.out.println(names.peek());
//        System.out.println(names.peek());
//        System.out.println(names.peek());
//        System.out.println(names.peek());
//        System.out.println(names.peek());


        Queue<Integer> numbers = new PriorityQueue<>();

        numbers.add(5);
        numbers.add(5);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        System.out.println(numbers.poll()); //1
        System.out.println(numbers.poll()); //2
        System.out.println(numbers.poll()); //4
        System.out.println(numbers.poll()); //5
        System.out.println(numbers.poll()); //5


        Queue<StudentDoubt> studentDoubts = new PriorityQueue<>();
        StudentDoubt st1 = new StudentDoubt("Aman", 6);
        StudentDoubt st2 = new StudentDoubt("Ram", 2);

        studentDoubts.add(st1);
        studentDoubts.add(st2);

        System.out.println(studentDoubts.poll());
        System.out.println(studentDoubts.poll());



    }
}
