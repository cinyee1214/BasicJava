/**
 * Exercise 11.1 w/ 12.5 illegal triangle exception
 * @author Xinyi Zhao
 * */
public class C11E1Triangle extends GeometricObject {

    //Fields
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    //Constructors
    public C11E1Triangle(){
    }

    //Create a new triangle with specific sides
    public C11E1Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    GeometricObject myGeometric = new GeometricObject() {
        @Override
        public double getArea() {
            //Using Heron's formula: area = square(s * (s-a) * (s-b) * (s-c))
            //where s is the semi-perimeter and a, b, and c are each side length
            double s = 0.5 * (side1 + side2 + side3); //The semi-perimeter of a triangle
            double tempArea = s * (s - side1) * (s - side2) * (s - side3);
            return Math.pow(tempArea, 0.5);
        }

        @Override
        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        @Override
        public String toString(){
            return "Triangle: side1 = " + side1 + " side2 = " + side2 +
                    " side3 = " + side3 +
                    "\n" + super.toString();
        }

    };


    //Methods
    /**
     * Get methods
     * */
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }

    @Override
    public double getArea() {

        double s = 0.5 * (side1 + side2 + side3); //The semi-perimeter of a triangle
        double tempArea = s * (s - side1) * (s - side2) * (s - side3);
        return Math.pow(tempArea, 0.5);
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }


}
