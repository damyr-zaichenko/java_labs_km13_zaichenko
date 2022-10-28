import java.util.Arrays;
import java.util.Objects;

final public class ImmutableMatrix {
    private final int M, N;
    private final float[][] content;

    public ImmutableMatrix() {
        this.M = 0;
        this.N = 0;
        this.content = new float[][] {{}};
    }

    public ImmutableMatrix(int M, int N) {
        this.M = M;
        this.N = N;
        this.content = new float[M][N];
    }

    public ImmutableMatrix(ImmutableMatrix m) {
        this.M = m.M;
        this.N = m.N;
        this.content = m.content;
    }


    float getElement(int i, int j) {
        return this.content[i][j];
    }

    float[] getRow(int i) {
        return this.content[i];
    }

    float[] getColumn(int j) {
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
        ImmutableMatrix matrix = (ImmutableMatrix) o;
        return getM() == matrix.getM() && getN() == matrix.getN() && Arrays.deepEquals(content, matrix.content);
    }

    public int hashCode() {
        int result = Objects.hash(getM(), getN());
        result = 31 * result + Arrays.deepHashCode(content);
        return result;
    }

    void show() {
        for (int i = 0; i < M; i++) {
            System.out.print("[ ");
            for (int j = 0; j < N; j++) {
                System.out.print(content[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
