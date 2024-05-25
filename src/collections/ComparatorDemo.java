package collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorDemo {

    public static void main(String[] args) {
        StudentDoubt st1 = new StudentDoubt("Aman", 6);
        StudentDoubt st2 = new StudentDoubt("Ram", 2);

        Comparator<StudentDoubt> anonymousComparator = new Comparator<StudentDoubt>() {
            @Override
            public int compare(StudentDoubt o1, StudentDoubt o2) {
                return Integer.compare(o2.noOfDoubtsAsked, o1.noOfDoubtsAsked);
            }
        };

//        Comparator<StudentDoubt> comparatorDoubts = new StudentComparator2();
//
//        Comparator<StudentDoubt> comparatorName = new StudentComparator();
//        Set<StudentDoubt> studentDoubtSet = new TreeSet<>(comparatorName);


        Set<StudentDoubt> studentDoubtSet = new TreeSet<>(anonymousComparator);
        studentDoubtSet.add(st1);
        studentDoubtSet.add(st2);

        System.out.println(studentDoubtSet);
    }
}
