package example;

import java.util.Scanner;

public class PresentationLayer {

    public void Layer() {
        ServiceLayer serviceLayer = new ServiceLayer();

        System.out.println("Введіть координати точки, що лежить на першій прямій: ");
        float[] A = getArray();
        System.out.println("Введіть координати напрямного вектора першої прямої: ");
        float[] a = getArray();
        System.out.println("Введіть координати точки, що лежить на другій прямій: ");
        float[] B = getArray();
        System.out.println("Введіть координати напрямного вектора другої прямої: ");
        float[] b = getArray();

        System.out.println("\nen/ua?");
        Scanner sc = new Scanner(System.in);
        String lan = sc.nextLine();
        serviceLayer.lan = lan;

        ServiceLayer.A = A;
        ServiceLayer.B = B;
        ServiceLayer.a = a;
        ServiceLayer.b = b;

        String dataResult = serviceLayer.MathModel();

        System.out.println(dataResult);
    }

    static float[] getArray() {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        float[] result = new float[3];
        for (int i = 0; i < 3; i++) {
            result[i] = Float.parseFloat(a[i]);
        }
        return result;
    }
}
