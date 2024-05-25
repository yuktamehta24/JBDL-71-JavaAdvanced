package collections;

import java.util.Comparator;

public class StudentComparator2 implements Comparator<StudentDoubt> {

    //sort on the basis of noOfQuestionsAsked
    @Override
    public int compare(StudentDoubt o1, StudentDoubt o2) {
        return Integer.compare(o2.noOfDoubtsAsked, o1.noOfDoubtsAsked);

//        if (o1.getNoOfDoubtsAsked() < o2.getNoOfDoubtsAsked()) {
//            return -1;
//        } else {
//            return 1;
//        }
    }
}
