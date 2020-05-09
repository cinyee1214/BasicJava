import java.util.Scanner;

public class RectangleTest {

    public RectangleTest() {
    } // end default constructor - not used - left here from Class
    // creation by JDeveloper

    public static void main(String[] args) {
//		TestBuilding testBuilding = new TestBuilding();
        run();  // this line runs the test function if this object is
    } // end main()

    public static void run() {
        /**
         * C9E1
         */
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        System.out.println("This is the test of Rectangle class:");
        System.out.println("For Rectangle1: ");
        System.out.println("width: " + rectangle1.getWidth() + ", height: " + rectangle1.getHeight() + ", area:" + rectangle1.getArea() + ", perimeter: " + rectangle1.getPerimeter());

        System.out.println("For Rectangle2: ");
        System.out.println(rectangle2.toString());
        rectangle2.print();

        Scanner input = new Scanner(System.in);

        System.out.println("Please input the width and height of the rectangle: ");
        double width = input.nextDouble();
        double height = input.nextDouble();
        Rectangle rectangle3 = new Rectangle();
        try {
            rectangle3.setWidth(width);
            rectangle3.setHeight(height);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("For this new rectangle: ");
        System.out.println("width: " + rectangle3.getWidth() + ", height: " + rectangle3.getHeight() + ", area:" + rectangle3.getArea() + ", perimeter: " + rectangle3.getPerimeter());

    }


}
