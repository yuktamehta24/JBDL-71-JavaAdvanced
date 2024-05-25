package collections;

public class Client {

    public static void main(String[] args) {
        StudentDoubtsAnalyser analyser = new MapOrderStudentDoubtAnalyserImpl(); //RUNTIME POLYMORPHISM
        analyser.saveName("Pooja");
        analyser.saveName("Pooja");
        analyser.saveName("Aman");
        analyser.saveName("Naina");
        analyser.saveName("Ram");
        analyser.saveName("Aman");
        analyser.saveName("Pooja");
        analyser.saveName("Ram");
        analyser.saveName("Shyam");
        analyser.saveName("Kanika");
        analyser.saveName("Ram");
        analyser.saveName("Naina");
        analyser.saveName("Pooja");
        analyser.saveName("Kanika");


        System.out.println(analyser.returnDoubtFrequencies());


    }
}
