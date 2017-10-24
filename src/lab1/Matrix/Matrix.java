package lab1.Matrix;

public class Matrix {
    private int col_;
    private int rows_;
    private double [][] matrix_;

    public Matrix(double [][] matrix) {
        this.col_ = matrix[0].length;
        this.rows_=matrix.length;
        this.matrix_=new double[rows_][col_];
        for (int i = 0; i < rows_; i++)
            for (int j = 0; j < col_; j++)
                this.matrix_[i][j] = matrix[i][j];
    }

    public Matrix(int rows, int col){
        this.rows_ = rows;
        this.col_ = col;
        matrix_ = new double[rows_][col_];
    }

    public Matrix add(Matrix matrix_b){
        if (matrix_b.rows_ != rows_ || matrix_b.col_ != col_) throw new IllegalArgumentException("Niewłaściwy rozmiar macierzy");
        Matrix matrix_c = new Matrix(rows_, col_);
        for (int i = 0; i < rows_; i++)
            for (int j = 0; j < col_; j++)
                matrix_c.matrix_[i][j] = matrix_[i][j] + matrix_b.matrix_[i][j];
        return matrix_c;
    }

    public Matrix mul(Matrix matrix_b){
        Matrix matrix_a=this;

        if (col_ != matrix_b.rows_) {
            throw new IllegalArgumentException("Złe wymiary macierzy");
        }

        Matrix matrix_c= new Matrix(rows_, matrix_b.col_);
        for (int i = 0; i < rows_; i++) {
            for (int j = 0; j < matrix_b.col_; j++) {
                for (int k = 0; k < col_; k++) {
                    matrix_c.matrix_[i][j] += matrix_a.matrix_[i][k] * matrix_b.matrix_[k][j];
                }
            }
        }
        return matrix_c;
    }

    public Matrix sub(Matrix matrix_b){
        if (matrix_b.rows_ != rows_ || matrix_b.col_ != col_) throw new IllegalArgumentException("Niewłaściwy rozmiar macierzy");
        Matrix matrix_c = new Matrix(rows_, col_);
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
