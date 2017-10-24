package lab3.Shapes;

public class Circle extends Shape  {
    public Circle(double wymiar) {
        super(wymiar);
    }

    @Override
    public void draw() {
        System.out.println("Kółko");
    }

    @Override
    public double pole() {
        return Math.PI*this.wymiar;
    }
}
