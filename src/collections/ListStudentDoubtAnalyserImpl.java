package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStudentDoubtAnalyserImpl implements StudentDoubtsAnalyser{

    List<String> studentNames;

    ListStudentDoubtAnalyserImpl() {
        studentNames = new ArrayList<>();
    }

    @Override
    public void saveName(String name) {
        studentNames.add(name);
    }

    @Override
    public List<String> returnStudents() {
        return studentNames;
    }
}
