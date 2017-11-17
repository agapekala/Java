package kolos;

import java.util.Stack;

public abstract class Operator0Arg extends Operator{
    public Operator0Arg(char war) {
        super(war);
    }

    @Override
    public abstract double oblicz(Stack<Operator> s);
}
