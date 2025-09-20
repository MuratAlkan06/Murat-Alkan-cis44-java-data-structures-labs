import java.util.Random;
public class Matrix {
    private int [][] data;

    public Matrix (int rows, int cols) {
        data = new int [rows][cols];
    }

    public Matrix (int[][] data){
        int rows = data.length;
        int cols = data[0].length;
        this.data = new int [rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public void populateRandom(){
        Random rand = new Random();
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                data[i][j] = rand.nextInt(10) +1;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices dimensions do not match for addition.");
        }
        int rows = this.data.length;
        int cols = this.data[0].length;
        int [][] sum = new int [rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(sum);
    }

    public Matrix multiply(Matrix other) {
        int aRows = this.data.length;
        int aCols = this.data[0].length;
        int bRows = other.data.length;
        int bCols = other.data[0].length;

        if (aCols != bRows) {
            throw new IllegalArgumentException("columns and rows must match");
        }

        int [][] product = new int [aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                int acc = 0;
                for (int k = 0; k < aCols; k++) {
                    acc += data [i][k] * other.data[k][j];
                }
                product[i][j] = acc;
            }
        }
        return new Matrix(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                if (j > 0){
                    sb.append(" ");
                }
                sb.append(data[i][j]);
            }
            if (i < data.length-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

