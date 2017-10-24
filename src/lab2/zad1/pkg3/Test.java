package lab2.zad1.pkg3;

import lab2.zad1.pkg1.*;
import lab2.zad1.pkg2.*;

public class Test {
    public static void main(String[] args){
        A a=new A("imie", 10);
        B b=new B("imie1", 15);
        C c=new C("imie2", 20);

        a.callDecrement();
        System.out.println(a.getNumbers());
        b.callDecrement();
        System.out.println(b.getNumbers());
        c.callDecrement();
        System.out.println(c.getNumbers());
        a.callChangeName();
        System.out.println(a.getName());
        b.callChangeName();
        System.out.println(b.getName());
        c.callChangeName();
        System.out.println(c.getName());
        b.callIncrement();
        System.out.println(b.getNumbers());
        c.callIncrement();
        System.out.println(c.getNumbers());
    }
}
