package lab3.Shapes;

public class Square extends Shape {
    public Square(double wymiar) {
        super(wymiar);
    }

    @Override
    public void draw() {
        System.out.println("kwadrat");
    }

    @Override
    public double pole() {
        return 0;
    }
}
