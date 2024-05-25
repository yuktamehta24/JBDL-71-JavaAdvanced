package collections;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentDoubt> {

    //sort on the basis of name
    @Override
    public int compare(StudentDoubt o1, StudentDoubt o2) {

        //sort first on the basis of name, and then on noofdoubtsasked
        if (o1.getName().equals(o2.getName())) {
            return Integer.compare(o2.noOfDoubtsAsked, o1.noOfDoubtsAsked);
        }
        return o2.getName().compareTo(o1.getName());
    }
}
