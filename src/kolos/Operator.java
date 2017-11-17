package kolos;

import java.util.Stack;

public abstract class Operator implements Obliczanie{
    public char wartosc;
    public Operator(char war){
        wartosc=war;
    }
    public char getWartosc(){
        return wartosc;
    }
    @Override
    public abstract double oblicz(Stack<Operator> s);
}
