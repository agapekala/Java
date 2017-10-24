package lab2.Punkt2D;

import static java.lang.Math.*;
public class Punkt3D extends Punkt2D {
    private double z;
    public Punkt3D( int x, int y, int z ) {
        super(x, y);
        this.z = z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getZ() {

        return z;
    }

    public double distance(Punkt3D pkt){
        double distance=Math.sqrt(pow((pkt.getX()-getX()),2)+pow((pkt.getY()-getY()),2)+pow((pkt.getZ()-getZ()),2));
        return distance;
    }
}