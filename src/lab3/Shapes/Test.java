package lab3.Shapes;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        Shape c = new Circle(2.1);
        c.draw();
        Shape r = new Rectangle(1.1);
        Shape s = new Square(13.0);
        r.draw();
        s.draw();

        LinkedList<Shape> lista = new LinkedList<>();
        lista.add(c);
        lista.add(r);
        lista.add(s);

        for(Shape m:lista){
            m.draw();
        }

        Collections.sort(lista, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.wymiar>o2.wymiar){
                    return 1;
                };
                if(o1.wymiar<o2.wymiar){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        for(Shape n:lista){
            System.out.println(n.wymiar);
        }
    }
}