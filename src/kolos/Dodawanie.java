package kolos;

import java.util.Stack;

public class Dodawanie extends Operator2Arg {
    public Dodawanie(char war) {
        super(war);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        Operator x=s.pop();
        Operator y=s.pop();
        double wynik=x.oblicz(s)+y.oblicz(s);
        return wynik;
    }
}
