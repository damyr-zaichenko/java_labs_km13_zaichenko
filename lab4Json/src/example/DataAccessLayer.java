package example;

import org.json.JSONObject;

public class DataAccessLayer {
    boolean parallel, intersect, fleeting, match;
    float x1, y1, z1, m1, n1, p1, x2, y2, z2, m2, n2, p2;

    String language;

    public String DataInput(){

        JSONObject file = new JSONObject();

        String L1 = String.format("(x - %.3f)/%.3f = (y - %.3f) / %.3f = (z - %.3f) / %.3f", x1, m1, y1, n1, z1, p1);
        String L2 = String.format("(x - %.3f)/%.3f = (y - %.3f) / %.3f = (z - %.3f) / %.3f", x2, m2, y2, n2, z2, p2);

        String result;

        file.put("L1", L1);
        file.put("L2", L2);
        if (parallel) {
            if (language.equalsIgnoreCase("eng"))
                file.put("Loc.", "Parallel");
            else if (language.equalsIgnoreCase("ua"))
                file.put("Loc.", "Паралельні");
        }
        else if (intersect) {
            if (language.equalsIgnoreCase("eng"))
                file.put("Loc.", "Intersect");
            else if (language.equalsIgnoreCase("ua"))
                file.put("Loc.", "Перетинаються");
        }
        else if (fleeting) {
            if (language.equalsIgnoreCase("eng"))
                file.put("Loc.", "Fleeting");
            else if (language.equalsIgnoreCase("ua"))
                file.put("Loc.", "Мимобіжні");
        }
        else if(match){
            if (language.equalsIgnoreCase("eng"))
                file.put("Loc.", "Matching");
            else if (language.equalsIgnoreCase("ua"))
                file.put("Loc.", "Співпадають");
        }

        result = "\n" + file;

        return result;
    }
}
