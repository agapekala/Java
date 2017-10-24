package lab1.Matrix;

import java.io.IOException;

public class MatrixProgram {

    public static void main(String[] args) {
        try {
            double[][] x = {{1, 2, 3}, {4, 5, 6}, {9, 1, 3}};
            double[][] y = {{12, 4, 6}, {1, 8, 28}, {5, 10, 23}};
            Matrix X = new Matrix(x);
            Matrix Y = new Matrix(y);
            X.print();
            System.out.println();

            Matrix Z = X.add(Y);
            Z.print();
            System.out.println();

            Z=X.sub(Y);
            Z.print();
            System.out.println();

            Z=X.mul(Y);
            Z.print();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}