package example;

public class ServiceLayer {

    float x1, y1, z1, m1, n1, p1, x2, y2, z2, m2, n2, p2;
    String language;

    public String MathModel(){

        DataAccessLayer dataAccessLayer = new DataAccessLayer();

        boolean parallel = false, intersect = false, fleeting = false, match = false;

        float det;

        det = (x1 - x2) * (n1 * p2 - p1 * n2) - (y1 - y2) * (m1 * p2 - p1 * m2) + (z1 - z2) * (m1 * n2 - n1 * m2);

        if(det == 0){
            if(m1 / m2 != n1 / n2 || n1 / n2 != p1 / p2){
                intersect = true;
            }
            else{
                parallel = true;
                match = true;

                if((x1 - x2) / m2 == (y1 - y2) / n2 && (y1 - y2) / n2 == (z1 - z2) / p2){
                    parallel = false;
                }
                else{
                    match = false;
                }
            }
        }
        else{
            fleeting = true;
        }

//        if((m1 / m2 == n1 / n2 && n1 / n2 == p1 / p2) && det == 0){
//            match = true;
//        } else if (det == 0 && ((x1 - x2) / m2 == (y1 - y2) / n2 && (y1 - y2) / n2 == (z1 - z2) / p2)) {
//            intersect = true;
//        }
//        else if (m1 / m2 == n1 / n2 && n1 / n2 == p1 / p2){
//            parallel = true;
//        }
//        else{
//            fleeting = true;
//        }

        dataAccessLayer.parallel = parallel;
        dataAccessLayer.intersect = intersect;
        dataAccessLayer.fleeting = fleeting;
        dataAccessLayer.match = match;
        dataAccessLayer.x1 = x1;
        dataAccessLayer.y1 = y1;
        dataAccessLayer.z1 = z1;
        dataAccessLayer.m1 = m1;
        dataAccessLayer.n1 = n1;
        dataAccessLayer.p1 = p1;
        dataAccessLayer.x2 = x2;
        dataAccessLayer.y2 = y2;
        dataAccessLayer.z2 = z2;
        dataAccessLayer.m2 = m2;
        dataAccessLayer.n2 = n2;
        dataAccessLayer.p2 = p2;

        dataAccessLayer.language = language;

        return dataAccessLayer.DataInput();
    }
}
