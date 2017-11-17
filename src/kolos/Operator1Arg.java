package kolos;

import java.util.Stack;

public abstract class Operator1Arg extends Operator{

    public Operator1Arg(char war) {
        super(war);
    }

    @Override
    public abstract double oblicz(Stack<Operator> s);
}
