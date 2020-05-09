import java.util.Scanner;

public class C4E2GreatCircleDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input the latitude and longitude
        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");

        double x1 = Math.toRadians(input.nextDouble());
        double y1 = Math.toRadians(input.nextDouble());

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");

        double x2 = Math.toRadians(input.nextDouble());
        double y2 = Math.toRadians(input.nextDouble());

        double distance = 6371.01 * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        //output the distance result
        System.out.println("the distance between the two points is " + distance + " km.");
    }
}
