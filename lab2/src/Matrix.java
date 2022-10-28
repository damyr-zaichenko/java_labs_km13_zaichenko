import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private int M, N;
    public float[][] content;

    public Matrix() {
        this.M = 0;
        this.N = 0;
        this.content = new float[][] {{}};
    }

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        this.content = new float[M][N];
    }

    public Matrix(Matrix m) {
        this.M = m.M;
        this.N = m.N;
        this.content = m.content;
    }

    public void setElement(float element, int i, int j) {
        this.content[i][j] = element;
    }

    public float getElement(int i, int j) {
        return this.content[i][j];
    }

    public float[] getRow(int i) {
        return this.content[i];
    }

    public float[] getColumn(int j) {
        float[] col = new float[M];
        for (int i = 0; i < M; i++) {
            col[i] = content[i][j];
        }
        return col;
    }

    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return getM() == matrix.getM() && getN() == matrix.getN() && Arrays.deepEquals(content, matrix.content);
    }

    public int hashCode() {
        int result = Objects.hash(getM(), getN());
        result = 31 * result + Arrays.deepHashCode(content);
        return result;
    }

    public static Matrix identity(int n) {
        Matrix result = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            result.setElement(1, i, i);
        }
        return result;
    }

    private void swap(int i, int j) {   //method that swaps two rows
        float[] temp = content[i];
        content[i]= content[j];
        content[j] = temp;
    }

    public void upperTriangle() {
        if (M != N) System.out.println("Error! Matrix must be square.");

        for (int k = 0; k < M; k++) {
            for (int i = k; i < M; i++) {
                if (content[i][k] != 0 && i != k && content[k][k] == 0) {
                    swap(k, i);
                    break;
                }
            }
            float f_elm = content[k][k];
            for (int i = k; i < N; i++) {
                if (f_elm != 0) {
                    content[k][i] /= f_elm;
                }
            }
            for (int i = k + 1; i < M; i++) {
                f_elm = content[i][k];
                for (int j = k; j < N; j++) {
                    content[i][j] -= content[k][j] * f_elm;
                }
            }
        }
    }

    public void lowerTriangle() {
        this.transpose();
        this.upperTriangle();
        this.transpose();
    }

    public void transpose() {
        float[][] transposed = new float[M][N];
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                transposed[j][i] = content[i][j];
            }
        }
        content = transposed;
    }

    public void show() {
        for (int i = 0; i < M; i++) {
            System.out.print("[ ");
            for (int j = 0; j < N; j++) {
                System.out.print(content[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}