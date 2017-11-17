package kolos;

import java.util.Stack;

public abstract class Operator2Arg extends Operator {
    public Operator2Arg(char war) {
        super(war);
    }

    @Override
    public abstract double oblicz(Stack<Operator> s);
}
