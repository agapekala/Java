package kolos;

import java.util.Stack;

public class Dzielenie extends Operator2Arg {
    public Dzielenie(char war) {
        super(war);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        Operator x=s.pop();
        Operator y=s.pop();
        double wynik=x.oblicz(s)/y.oblicz(s);
        return wynik;
    }
}
