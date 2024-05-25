package collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapStudentDoubtAnalyserImpl implements StudentDoubtsAnalyser{

    Map<String, Integer> studentFrequencies;

    MapStudentDoubtAnalyserImpl() {
        studentFrequencies = new TreeMap<>(Comparator.reverseOrder());
    }

    @Override
    public void saveName(String name) {
        if(studentFrequencies.containsKey(name)) {
            //not asking the doubt for the first time
            int currentCount = studentFrequencies.get(name);
            studentFrequencies.put(name, currentCount+1);
        } else {
            //asking the doubt for the first time
            studentFrequencies.put(name, 1);
        }
    }

    @Override
    public List<String> returnStudents() {
        return null;
    }

    @Override
    public Map<String, Integer> returnDoubtFrequencies() {
        return studentFrequencies;
    }
}
