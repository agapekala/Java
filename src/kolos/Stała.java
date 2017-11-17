package kolos;

import java.util.Stack;

public class Stała extends Operator0Arg {
    public Stała(char war) {
        super(war);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        int wynik= (int)(wartosc);
        double wynik_double=(double)wynik-48;
        return wynik_double;
    }
}
