package lab3.Shapes;

public abstract class Shape {

    public String name;
    public double wymiar;

    public Shape(double wymiar){
        this.wymiar=wymiar;
    }

    public abstract void draw();
    public abstract double pole();

}