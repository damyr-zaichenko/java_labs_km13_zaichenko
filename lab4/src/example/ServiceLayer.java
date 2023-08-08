package example;

public class ServiceLayer {

    static float[] A, B, a, b;
    String lan;

    public String MathModel() {

        DataAccessLayer dataAccessLayer = new DataAccessLayer();

        float[] AB = {A[0]-B[0], A[1]-B[1], A[2]-B[2]};
        float det = AB[0]*a[1]*b[2]+AB[1]*a[2]*b[0]+a[0]*b[1]*AB[2]-b[0]*a[1]*AB[2]-a[0]*AB[1]*b[2]-a[2]*b[1]*AB[0];

        String position = "";

        if (lan.equals("en")) {
            if (det != 0) position = "lines are non-intersecting";
            else {
                if (!(a[0] / b[0] == a[1] / b[1] && a[1] / b[1] == a[2] / b[2])) position = "lines are crossing";
                else {
                    if ((AB[0] / b[0] == AB[1] / b[1] && AB[1] / b[1] == AB[2] / b[2]))
                        position = "lines are overlapping";
                    else position = "lines are parallel";
                }
            }
        } else {
            if (det != 0) position = "прямі мимобіжні";
            else {
                if (!(a[0] / b[0] == a[1] / b[1] && a[1] / b[1] == a[2] / b[2])) position = "прямі перетинаються";
                else {
                    if ((AB[0] / b[0] == AB[1] / b[1] && AB[1] / b[1] == AB[2] / b[2])) position = "прямі співпадають";
                    else position = "прямі паралельні";
                }
            }
        }

        dataAccessLayer.position = position;
        dataAccessLayer.A = A;
        dataAccessLayer.B = B;
        dataAccessLayer.a = a;
        dataAccessLayer.b = b;
        dataAccessLayer.lan = lan;

        return dataAccessLayer.DataInput();
    }
}
