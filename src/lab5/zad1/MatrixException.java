package lab5.zad1;


import java.io.File;
import java.util.Scanner;



public class MatrixException {
    private int col_;
    private int rows_;
    private double [][] matrix_;

    public MatrixException(double [][] matrix) {
        this.col_ = matrix[0].length;
        this.rows_=matrix.length;
        this.matrix_=new double[rows_][col_];
        for (int i = 0; i < rows_; i++)
            for (int j = 0; j < col_; j++)
                this.matrix_[i][j] = matrix[i][j];
    }

    public MatrixException(int rows, int col){
        this.rows_ = rows;
        this.col_ = col;
        matrix_ = new double[rows_][col_];
    }

    public MatrixException(String filepath) throws Exception {
        try {
            File file = new File(filepath);
            Scanner in = new Scanner(file);
            String help="";

            this.rows_ = Integer.parseInt(in.next());
            this.col_ = Integer.parseInt(in.next());

            this.matrix_=new double[rows_][col_];

            for (int i = 0; i < rows_; i++) {
                for (int j = 0; j < col_; j++) {
                    if(in.hasNext()) help=in.next();
                    else{ throw new NotEnoughData();}
                    if(isNumeric(help)){
                        this.matrix_[i][j] = Integer.parseInt(help);
                    }else{
                        System.out.println("złe dane");
                        throw new WrongDataException();
                    }

                }
            }
            if(in.hasNext()){
                throw new TooMuchData();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }


    public MatrixException add(MatrixException matrix_b) throws Exception{
        if (matrix_b.rows_ != rows_ || matrix_b.col_ != col_){
            System.out.println("Złe wymiary!");
            throw new MatrixDimensionsException();
        }
        MatrixException matrix_c = new MatrixException(rows_, col_);
        for (int i = 0; i < rows_; i++)
            for (int j = 0; j < col_; j++)
                matrix_c.matrix_[i][j] = matrix_[i][j] + matrix_b.matrix_[i][j];
        return matrix_c;
    }

    public MatrixException mul(MatrixException matrix_b) throws Exception{
        MatrixException matrix_a=this;

        if (col_ != matrix_b.rows_) {
            System.out.println("Złe wymiary!");
            throw new MatrixDimensionsException();
        }

        MatrixException matrix_c= new MatrixException(rows_, matrix_b.col_);
        for (int i = 0; i < rows_; i++) {
            for (int j = 0; j < matrix_b.col_; j++) {
                for (int k = 0; k < col_; k++) {
                    matrix_c.matrix_[i][j] += matrix_a.matrix_[i][k] * matrix_b.matrix_[k][j];
                }
            }
        }
        return matrix_c;
    }

    public MatrixException sub(MatrixException matrix_b) throws Exception{
        if (matrix_b.rows_ != rows_ || matrix_b.col_ != col_){
            System.out.println("Złe wymiary!");
            throw new MatrixDimensionsException();
        }
        MatrixException matrix_c = new MatrixException(rows_, col_);
        for (int i = 0; i < rows_; i++)
            for (int j = 0; j < col_; j++)
                matrix_c.matrix_[i][j] = matrix_[i][j] - matrix_b.matrix_[i][j];
        return matrix_c;
    }

    public void print() {
        for (int i = 0; i < rows_; i++) {
            for (int j = 0; j < col_; j++)
                System.out.format("%f ", matrix_[i][j]);
            System.out.println();
        }
    }
}
