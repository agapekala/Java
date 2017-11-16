package lab6;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {

    public String name;
    public double wymiar;
    public int x;
    public int y;

    public Shape(double wymiar){
        this.wymiar=wymiar;
    }

    public abstract void draw(Graphics g, int x, int y);
    public abstract double pole();

    public abstract int getX();
    public abstract int getY();

    public abstract void setX(int x);
    public abstract void setY(int y);
}