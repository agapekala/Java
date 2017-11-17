package kolos;

import java.util.Stack;

public class Silnia extends Operator1Arg {
    public Silnia(char war) {
        super(war);
    }
    public double fact(double i){
        double wart=i;
        if(wart<1){
            return 1;
        }else{
            return wart*fact(wart-1);
        }
    }
    @Override
    public double oblicz(Stack<Operator> s) {
        double i=s.pop().wartosc;
        return fact(i);
    }
}
