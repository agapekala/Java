package lab6.zad1;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Triangle extends Shape {
    public Triangle(double wymiar) {
        super(wymiar);
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

    @Override
    public void draw(Graphics g, int x, int y) {
        int a=(int)(x+wymiar);
        int b=(int)(x+wymiar/2);
        int height=(int)(wymiar*sqrt(3)/2);
        int c=(int)(y+wymiar);
        Graphics g2 = g;


        g2.setColor(Color.orange);
        g2.fillPolygon(new int[]{x,b,a}, new int[]{c,c-(int)wymiar,c}, 3 );
        g2.drawPolygon(new int[]{x,b,a}, new int[]{c,c-(int)wymiar,c}, 3 );
    }

    @Override
    public double pole() {
        return 0;
    }
}