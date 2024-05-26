package serialization;

import java.io.Serializable;

public class Student implements Serializable {
    int rollno;

    transient String name1; //transient

    static int marks; //static

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name1 = name;
        this.marks = 20;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }
}
