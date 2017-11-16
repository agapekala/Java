package lab6;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShapeProgram extends java.awt.Frame  {
    public ShapeProgram(){
        super("Shapes");
    }
    public static void main(String [] argv){
        Shape c=new Circle(200);
        c.setY(100);
        c.setX(100);
        Shape r=new Triangle(200);
        r.setX(300);
        r.setY(100);
        Shape s=new Square(200);
        s.setX(500);
        s.setY(100);
        Shape s1=new Circle(100);
        s1.setY(300);
        s1.setX(300);
        ShapeProgram sp=new ShapeProgram();
        MyPanel mp= new MyPanel();
        mp.addShape(c);
        mp.addShape(r);
        mp.addShape(s);
        mp.addShape(s1);
        sp.setSize(1000,500);
        sp.setVisible(true);
        sp.add(mp);

        sp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        ;

    }
}