package collections;

import java.util.List;
import java.util.Map;

public interface StudentDoubtsAnalyser {

    void saveName(String name);

    List<String> returnStudents();

    default Map<String, Integer> returnDoubtFrequencies() {
        return null;
    }
}
