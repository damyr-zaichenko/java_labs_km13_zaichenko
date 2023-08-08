package example;

import java.util.Scanner;

public class PresentationLayer {

    public void Layer() {
        ServiceLayer serviceLayer = new ServiceLayer();

        Scanner sc = new Scanner(System.in);

        float x1 = 0, y1 = 0, z1 = 0, m1 = 0, n1 = 0, p1 = 0;
        float x2 = 0, y2 = 0, z2 = 0, m2 = 0, n2 = 0, p2 = 0;
        boolean outPut = false;
        String language;

        String dataResult;

        String[] inputPattern = {"x", "y", "z", "m", "n", "p"};


        for(int i = 1; i < 3; i++){
            for(String el : inputPattern){
                String tempPattern = el + Integer.toString(i);

                if(i == 1) {
                    if(!outPut){
                        System.out.println("Канонічне рівняння прямої L1 має вигляд:\n" +
                                "(x - x1)/m1 = (y - y1)/n1 = (z - z1)/p1");
                        outPut = true;
                    }

                    switch (tempPattern) {
                        case "x1":
                            x1 = inputFunction(tempPattern);
                            break;
                        case "y1":
                            y1 = inputFunction(tempPattern);
                            break;
                        case "z1":
                            z1 = inputFunction(tempPattern);
                            break;
                        case "m1":
                            m1 = inputFunction(tempPattern);
                            break;
                        case "n1":
                            n1 = inputFunction(tempPattern);
                            break;
                        case "p1":
                            p1 = inputFunction(tempPattern);
                            break;
                    }
                }

                if(i == 2) {
                    if(outPut){
                        System.out.println("\nКанонічне рівняння прямої L2 має вигляд:\n" +
                                "(x - x2)/m2 = (y - y2)/n2 = (z - z2)/p2");
                        outPut = false;
                    }

                    switch (tempPattern) {
                        case "x2":
                            x2 = inputFunction(tempPattern);
                            break;
                        case "y2":
                            y2 = inputFunction(tempPattern);
                            break;
                        case "z2":
                            z2 = inputFunction(tempPattern);
                            break;
                        case "m2":
                            m2 = inputFunction(tempPattern);
                            break;
                        case "n2":
                            n2 = inputFunction(tempPattern);
                            break;
                        case "p2":
                            p2 = inputFunction(tempPattern);
                            break;
                    }
                }
            }
        }

        System.out.printf("\nКанонічне рівння прямої L1:\n" +
                "(x - %.3f)/%.3f = (y - %.3f)/%.3f = (z - %.3f)/%.3f", x1, m1, y1, n1, z1, p1);

        System.out.printf("\nКанонічне рівння прямої L2:\n" +
                "(x - %.3f)/%.3f = (y - %.3f)/%.3f = (z - %.3f)/%.3f", x2, m2, y2, n2, z2, p2);

        serviceLayer.x1 = x1;
        serviceLayer.y1 = y1;
        serviceLayer.z1 = z1;
        serviceLayer.m1 = m1;
        serviceLayer.n1 = n1;
        serviceLayer.p1 = p1;
        serviceLayer.x2 = x2;
        serviceLayer.y2 = y2;
        serviceLayer.z2 = z2;
        serviceLayer.m2 = m2;
        serviceLayer.n2 = n2;
        serviceLayer.p2 = p2;

        System.out.println("\n\nОберіть мову, якою хочете побачити результат (eng/ua): ");

        language = sc.next();

        serviceLayer.language = language;

        dataResult = serviceLayer.MathModel();

        System.out.println("\n\nПрямі L1, L2 та їхнє взаємне розміщення:");
        System.out.println(dataResult);
    }

    static float inputFunction(String variableName){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть " + variableName + ": ");

        return sc.nextFloat();
    }
}
