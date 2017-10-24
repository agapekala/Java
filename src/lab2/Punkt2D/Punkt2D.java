package lab2.Punkt2D;

import static java.lang.Math.*;


public class Punkt2D {
    private double x;
    private double y;

    public Punkt2D(double x, double y) {
        this.x = x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public double distance(Punkt2D pkt){
        double distance=Math.sqrt(pow((pkt.getX()-x),2)+pow((pkt.getY()-y),2));
        return distance;
    }
}

