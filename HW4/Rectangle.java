public class Rectangle {

    private double width = 1, height = 1;

    //no-arg constructor
    public Rectangle() {

    }

    //constructor with two args
   public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void setWidth(double width) throws Exception {
        if (isValid(width)) {
            this.width = width;
        } else {
            Exception e = new Exception("The width must be greater than 0.");
            throw e;
        }
    }

    public double getWidth() {
        return this.width;
    }

    public void setHeight(double height) throws Exception {
        if (isValid(height)) {
            this.height = height;
        } else {
            Exception e = new Exception("The height must be greater than 0.");
            throw e;
        }
    }

    public double getHeight() {
        return this.height;
    }

    private boolean isValid(double num) {
        if (num <= 0) {
            return false;
        }
        return true;
    }

    /** toString()
     * method to allow meaningful text to be printed when an object handle
     * is given in a println() statement - if not present then the object
     * handle is printed which is usually meaningless to the reader
     */
    public String toString() {
        return "For this rectangle: the width is " + width + ", the height is " + height + ".";
    } // end toString()

    /** equals()
     * method to determine is two Building objects are equal - requires both
     * to be Building objects and have parameters with equal values
     * input argument is an unspecified object o
     */
    public boolean equals(Object o) {
        // check for null parameter
        if( o == null) return false;

        // check for object type
        String s = o.getClass().getName(); // method to get class name
        if( !s.equals("Rectangle")) return false;

        // check for equivalent parameter values
        Rectangle b = (Rectangle) o;	// cast unspecified object to
        // Building object in order to be able
        // to use Building get() functions
        if( width != b.getWidth()) return false;
        if( height != b.getHeight()) return false;

        return true;

    } // end equals

    /** print function used primarily for debugging - often not included when class
     * is embedded in a larger application
     */
    public void print() {
        System.out.println("For this rectangle: ");
        System.out.println("width: " + width + ", height: " + height + ", area:" + this.getArea() + ", perimeter: " + this.getPerimeter());
    } // end print()
}
