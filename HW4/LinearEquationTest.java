import java.util.Scanner;

public class LinearEquationTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * C9E11
         */
        System.out.println("This is the test for LinearEquation class: ");
        System.out.println("Please input a, b, c, d, e, f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
        if (!linearEquation.isSolvable()) {
            System.out.println("The equation has no solution.");
        }

        try {
            System.out.println("The solution for this equation is: ");
            System.out.println("x = " + linearEquation.getX());
            System.out.println("y = " + linearEquation.getY());
        } catch (Exception e2) {
            System.out.println(e2);
        }

        /**
         * C9E12
         */

        System.out.println("This is the test for segments intersection: ");
        System.out.println("Please input four endpoints: ");
        System.out.print("x1, y1:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("x2, y2:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.print("x3, y3:");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        System.out.print("x4, y4:");
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        LinearEquation segmentIntersect = new LinearEquation(y2 - y1, x1 - x2, y4 - y3, x3- x4, x1 * y2 - x2 * y1, x3 * y4 - x4 * y3);
        if (segmentIntersect.isSolvable()) {
            System.out.println("These two lines are intersected. And the intersection point is: ");
            System.out.println("x = " + + segmentIntersect.getX());
            System.out.println("y = " + + segmentIntersect.getY());
        } else {
            System.out.println("These two lines do not intersect.");
        }


    }
}
