package collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MapOrderStudentDoubtAnalyserImpl implements StudentDoubtsAnalyser{

    Map<String, StudentDoubt> studentFrequencies;
    Queue<StudentDoubt> orderedQueue;

    Comparator<StudentDoubt> comparator = new Comparator<StudentDoubt>() {
        @Override
        public int compare(StudentDoubt o1, StudentDoubt o2) {
            if (o1.noOfDoubtsAsked == o2.noOfDoubtsAsked) {
                return o1.getName().compareTo(o2.getName());
            }
            return Integer.compare(o2.noOfDoubtsAsked, o1.noOfDoubtsAsked);
        }
    };

    MapOrderStudentDoubtAnalyserImpl() {
        orderedQueue = new PriorityQueue(comparator);
        studentFrequencies = new TreeMap<>();
    }

    @Override
    public void saveName(String name) {
        if (studentFrequencies.containsKey(name)) {
            //not asking the doubt for the first time
            StudentDoubt currentObject = studentFrequencies.get(name);
            //how to retrieve the object from the queue
            orderedQueue.remove(currentObject);
            currentObject.noOfDoubtsAsked++;
            orderedQueue.add(currentObject);
            //map
            //studentFrequencies.put(name, currentObject);
        } else {
            //asking the doubt for the first time
            StudentDoubt studentDoubt = new StudentDoubt(name, 1);
            orderedQueue.add(studentDoubt);
            studentFrequencies.put(name, studentDoubt);
        }
    }

    @Override
    public List<String> returnStudents() {
        return null;
    }

    @Override
    public Map<String, Integer> returnDoubtFrequencies() {
        Map<String, Integer> result = new LinkedHashMap<>();
        for(int i = 0; i< 5; i++) {
            StudentDoubt studentDoubt = orderedQueue.poll();
            result.put(studentDoubt.name, studentDoubt.noOfDoubtsAsked);
        }
        return result;
    }
}
