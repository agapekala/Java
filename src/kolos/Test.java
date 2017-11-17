package kolos;

import java.util.Stack;

public class Test {
    public static void main(String []args) throws Exception{
        Stack<Operator> new_stack=new Stack<>();
        new_stack=WeWy.pobierzDzialanie();
        Operator wynik=new_stack.pop();
        double wynik_d=wynik.oblicz(new_stack);
        WeWy.zapiszWynik(wynik_d);
    }
}
