package lab2.DoDomu;

import java.io.IOException;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) throws IOException {
        /*
        CwDB a = new CwDB("/home/agnieszka/IdeaProjects/Krzyżówka/src/pkg/test.txt");
        System.out.println(a.getSize());
        Entry b=a.get("tabaka");
        System.out.println(b.getClue());
        a.remove("tabaka");
        System.out.println();
        a.add("agnieszka","Pękala");
        System.out.println(a.getSize());
        InteliCwDB a1= new InteliCwDB("/home/agnieszka/IdeaProjects/Krzyżówka/src/pkg/test.txt");
        LinkedList<Entry> test=a1.findAll("ta....");
        System.out.println(test.size());
        b=a1.getRandom(5);
        System.out.println(b.getWord());
        System.out.println(b.getClue());
        System.out.println();
        b=a1.getRandom();
        System.out.println(b.getWord()+"\n"+b.getClue());
        System.out.println();
        b=a1.getRandom("ta....");
        System.out.println(b.getWord()+"\n"+b.getClue());
        a.saveDB("/home/agnieszka/IdeaProjects/Krzyżówka/src/pkg/test2");
        */
        InteliCwDB a1= new InteliCwDB("/home/agnieszka/IdeaProjects/Java/src/lab2/DoDomu/test.txt");
        a1.saveDB("/home/agnieszka/IdeaProjects/Java/src/lab2/DoDomu/test2");
    }
}
