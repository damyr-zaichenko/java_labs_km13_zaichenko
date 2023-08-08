package example;
import org.json.JSONObject;

public class DataAccessLayer {
    static float[] A, B, a, b;
    String lan, position, result;


    public String DataInput(){

        JSONObject file = new JSONObject();

        String L1 = String.format("(x-%.1f)/%.1f=(y-%.1f)/%.1f=(z-%.1f)/%.1f%n", A[0], a[0], A[1], a[1], A[2], a[2]);
        String L2 = String.format("(x-%.1f)/%.1f=(y-%.1f)/%.1f=(z-%.1f)/%.1f%n", B[0], b[0], B[1], b[1], B[2], b[2]);

        file.put("L1", L1);
        file.put("L2", L2);
        file.put("position", position);

        System.out.println("");
        result = file.toString();

        return result;
    }
}
