package serialization;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObject();
        //readObject();
    }

    public static void writeObject() throws IOException {
        FileOutputStream fo = new FileOutputStream("abc.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        Student student = new Student(1, "Yukta");
        System.out.println("Before writing");
        System.out.println(student.rollno);
        System.out.println(student.name1);
        System.out.println(student.marks);
        oo.writeObject(student);
        Double b = 2d;
        oo.writeObject(b);

    }

    public static void readObject() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("/Users/mehtyukt/Documents/GFG/CodeProjects/JBDL-71-JavaAdvanced/abc.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        Student st = (Student)oi.readObject(); //name
        double e = (Double) oi.readObject();
        System.out.println("After writing");
        System.out.println(st.rollno); //
        System.out.println(st.name1); //
        System.out.println(st.marks);
        System.out.println("double is: "+ e);

    }

    public static void read() throws IOException {
        FileInputStream fi = new FileInputStream("/Users/mehtyukt/Documents/GFG/CodeProjects/JBDL-71-JavaAdvanced/abc.txt");

        int first = fi.read();  //97
        char a = (char) first;

        System.out.print(a); //a


        int second = fi.read();  //98
        char b = (char) second;

        System.out.print(b); //b

        int third = fi.read();  //99
        char c = (char) third;

        System.out.print(c); //c

        System.out.println(fi.read()); //

    }

    public static void write() throws IOException {
        String abc = "abc";
        FileOutputStream fo = new FileOutputStream("abc.txt");
        fo.write(abc.getBytes());
    }
}
