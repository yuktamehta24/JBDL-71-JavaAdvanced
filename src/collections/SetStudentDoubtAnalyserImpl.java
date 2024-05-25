package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetStudentDoubtAnalyserImpl implements StudentDoubtsAnalyser{

    Set<String> names;

    SetStudentDoubtAnalyserImpl() {
//        names = new HashSet<>();
//        names = new LinkedHashSet<>();
        names = new TreeSet<>(Comparator.reverseOrder());
    }


    @Override
    public void saveName(String name) {
        names.add(name);
    }

    @Override
    public List<String> returnStudents() {

        return new ArrayList<>(names);

//        Using Collections.sort
//        List<String> result = new ArrayList<>(names);
//        Collections.sort(result);
//        return result;

//        Using addAll
//        List<String> result = new ArrayList<>();
//        result.addAll(names);
//        return result;
//
    }
}
