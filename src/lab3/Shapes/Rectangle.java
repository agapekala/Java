package lab3.Shapes;

public class Rectangle extends Shape {
    public Rectangle(double wymiar) {
        super(wymiar);
    }

    @Override
    public void draw() {
        System.out.println("trójkąt");
    }

    @Override
    public double pole() {
        return 0;
    }
}
