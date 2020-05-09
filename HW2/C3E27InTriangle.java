import java.util.Scanner;

public class C3E27InTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input the point
        System.out.print("Enter a point's x- and y-coordinates: ");

        double x = input.nextDouble();
        double y = input.nextDouble();

        //determine whether the point is in the triangle
        if (x < 0 || x > 200 || y < 0 || y > 100 || 2 * y + x > 200) {
            System.out.println("The point is not in the triangle.");
        } else {
            System.out.println("The point is in the triangle.");
        }
    }
}
