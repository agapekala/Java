package lab6.zad1;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape  {
    public Circle(double wymiar) {
        super(wymiar);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2 =(Graphics2D) g;
        Ellipse2D e=new Ellipse2D.Double(x,y, this.wymiar,this.wymiar);

        g2.setColor(Color.blue);
        g2.fill(e);
        g2.draw(e);
    }

    @Override
    public double pole() {
        return Math.PI*this.wymiar;
    }

    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public void setY(int y) {
        this.y=y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
