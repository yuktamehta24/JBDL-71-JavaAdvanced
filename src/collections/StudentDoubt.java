package collections;

public class StudentDoubt implements Comparable<StudentDoubt>{
//public class StudentDoubt extends Object{

    String name;

    int noOfDoubtsAsked;

    public StudentDoubt(String name, int noOfDoubtsAsked) {
        this.name = name;
        this.noOfDoubtsAsked = noOfDoubtsAsked;
    }

    @Override
    public String toString() {
        return "StudentDoubt{" +
                "name='" + name + '\'' +
                ", noOfDoubtsAsked=" + noOfDoubtsAsked +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfDoubtsAsked() {
        return noOfDoubtsAsked;
    }

    public void setNoOfDoubtsAsked(int noOfDoubtsAsked) {
        this.noOfDoubtsAsked = noOfDoubtsAsked;
    }

    @Override
    public int compareTo(StudentDoubt o) {
        return Integer.compare(o.noOfDoubtsAsked, this.noOfDoubtsAsked);
    }
}
