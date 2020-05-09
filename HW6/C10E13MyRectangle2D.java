/**
 * Exercise 10.13
 * @author Xinyi Zhao
 * */

public class C10E13MyRectangle2D {
    //Fields
    private double x, y;
    private double width, height;



    //Constructor
    public C10E13MyRectangle2D(){
        //Default rectangle
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public C10E13MyRectangle2D(double x, double y, double width, double height) throws NumberFormatException{
        //Check whether the input rectangle was valid or not
        if(width <= 0 || height <= 0)
            throw new NumberFormatException("Your width and height must be positive!");
        //If valid, specific a rectangle
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    //Methods
    /**
     * Get methods
     * */
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }

    /**
     * Set methods
     * */
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setWidth(double width){
        //Check whether the input width was valid or not
        if(width <= 0)
            throw new NumberFormatException("Your width have to be positive!");

        this.width = width;
    }
    public void setHeight(double height){
        //Check whether the input height was valid or not
        if(height <= 0)
            throw new NumberFormatException("Your height have to be positive!");

        this.height = height;
    }

    /**
     * Get the area of a rectangle
     * */
    public double getArea(){
        return width * height;
    }

    /**
     * Get the perimeter of a rectangle
     * */
    public double getPerimeter(){
        return 2 * (width + height);
    }

    /**
     * Check whether a specific point is in a rectangle or not
     * A help method
     * @param x    the x-coordinate of a check point
     * @param y    the y-coordinate of a check point
     * @return true    if this point is inside or located on the sides
     *         false    otherwise
     * */
   public boolean contains(double x, double y){
        double x1, x2, y1, y2; //Coordinates of vertexes of the base rectangle
        double[] vertexCoordinate = this.getVertexCoordinate();
        x1 = vertexCoordinate[0];
        x2 = vertexCoordinate[1];
        y1 = vertexCoordinate[2];
        y2 = vertexCoordinate[3];

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    /**
     * Check whether a specific rectangle is inside a default rectangle or not
     * A help method
     * @param r    an input rectangle
     * @return true    if inside the default rectangle
     *         false    otherwise
     * */
    public boolean contains(C10E13MyRectangle2D r){
        //Determine if contains by comparing values of vertexes' coordinates
        boolean[] vertexR = this.isVertexInside(r);
        return vertexR[0] && vertexR[1] && vertexR[2] && vertexR[3];
    }

    /**
     * Check whether each vertex of an input rectangle is in the compared rectangle or not
     * A help method
     * @param r    an input rectangle
     * */
    private boolean[] isVertexInside(C10E13MyRectangle2D r){
        double[] vertexCoordinatesR = r.getVertexCoordinate(); //Coordinates of the input rectangle
        //Declare an array of boolean values
        //to check whether vertexes of the input rectangle are in the compared rectangle or not
        //Points can locate on the sides
        //values equal true if in, equal false otherwise
        boolean[] isVertexInside = new boolean[4];
        isVertexInside[0] = this.contains(vertexCoordinatesR[0], vertexCoordinatesR[2]);
        isVertexInside[1] = this.contains(vertexCoordinatesR[0], vertexCoordinatesR[3]);
        isVertexInside[2] = this.contains(vertexCoordinatesR[1], vertexCoordinatesR[2]);
        isVertexInside[3] = this.contains(vertexCoordinatesR[1], vertexCoordinatesR[3]);
        return isVertexInside;
    }

    /**
     * Check whether a specific rectangle overlaps a default rectangle or not
     * A help method
     * @param r    an input rectangle
     * @return true    if overlaps the default rectangle
     *         false    otherwise
     * */
    public boolean overlaps(C10E13MyRectangle2D r){
        if(r.contains(this) || this.contains(r) || this.abutments(r)){
            //One rectangles is contained inside another
            //Or two rectangles are abutment with each other
            return false;
        }

        //When Not Contained and Not Abutment,
        //determine if overlaps by comparing values of vertexes' coordinates
        boolean[] vertexRS = this.isVertexInside(r);
        return vertexRS[0] || vertexRS[1] || vertexRS[2] || vertexRS[3];
    }

    /**
     * Get all x- and y- coordinates of vertex of a rectangle
     * A help method
     * */
    private double[] getVertexCoordinate(){

        double[] vertexCoordinate = new double[4];

        double x1, x2, y1, y2;
        //Initialize all coordinates of vertexes
        x1 = this.x - 0.5 * this.height;
        x2 = this.x + 0.5 * this.height;
        y1 = this.y - 0.5 * this.width;
        y2 = this.y + 0.5 * this.height;

        vertexCoordinate[0] = x1;
        vertexCoordinate[1] = x2;
        vertexCoordinate[2] = y1;
        vertexCoordinate[3] = y2;

        return vertexCoordinate;
    }

    /**
     * Check whether each vertex of an input rectangle
     * is on the sides of the compared rectangle or not
     * A help method
     * @param r    an input rectangle
     * */
    private boolean[] isVertexOnSide(C10E13MyRectangle2D r){
        double[] vertexCoordinatesR = r.getVertexCoordinate(); //Coordinates of the input rectangle
        //Declare an array of boolean values
        //to check whether vertexes of the input rectangle
        //are located on the sides of the compared rectangle or not
        //values equal true if in, equal false otherwise
        boolean[] isVertexOnSide = new boolean[4];
        isVertexOnSide[0] = this.pointOnSide(vertexCoordinatesR[0], vertexCoordinatesR[2]);
        isVertexOnSide[1] = this.pointOnSide(vertexCoordinatesR[0], vertexCoordinatesR[3]);
        isVertexOnSide[2] = this.pointOnSide(vertexCoordinatesR[1], vertexCoordinatesR[2]);
        isVertexOnSide[3] = this.pointOnSide(vertexCoordinatesR[1], vertexCoordinatesR[3]);
        return isVertexOnSide;
    }

    /**
     * Check whether a specific point is on a rectangle's side or not
     * A help method
     * @param x    the x-coordinate of a check point
     * @param y    the y-coordinate of a check point
     * @return true    if the point is on a side
     *         false    otherwise
     * */
    private boolean pointOnSide(double x, double y){
        double x1, x2, y1, y2; //Coordinates of vertexes of the base rectangle
        double[] vertexCoordinate = this.getVertexCoordinate();
        x1 = vertexCoordinate[0];
        x2 = vertexCoordinate[1];
        y1 = vertexCoordinate[2];
        y2 = vertexCoordinate[3];

        //Point on one of the sides
        if( (x == x1 || x == x2) && (y >= y1 && y <= y2))
            return true;
        if( (y == y1 || y == y2) && (x >= x1 && x <= x2))
            return true;

        return false;
    }

    /**
     * Check whether a specific rectangle abutments a default rectangle or not
     * A help method
     * @param r    an input rectangle
     * @return true    if abutments the default rectangle
     *         false    otherwise
     * */
    private boolean abutments(C10E13MyRectangle2D r){
        //Determine if abutments by comparing values of vertexes' coordinates
        boolean[] vertexTest = this.isVertexOnSide(r);
        boolean[] vertexBase = r.isVertexOnSide(this);

        if(this.contains(r)){
            //The test rectangle is contained inside the base rectangle
            return vertexTest[0] || vertexTest[1] ||
                    vertexTest[2] || vertexTest[3];
        }else if(r.contains(this)){
            //The base rectangle is contained inside the test rectangle
            return vertexBase[0] || vertexBase[1] ||
                    vertexBase[2] || vertexBase[3];
        }else if(vertexTest[0] || vertexTest[1]
                || vertexTest[2] || vertexTest[3]){

            double distanceX = Math.abs(this.getX() - r.getX());
            double distanceY = Math.abs(this.getY() - r.getY());
            double widthBase = this.getWidth();
            double widthTest = r.getWidth();
            double heightBase = this.getHeight();
            double heightTest = r.getHeight();
            double widthHalfSum = 0.5 * (widthBase + widthTest);
            double heightHalfSum = 0.5 * (heightBase + heightTest);
            return (distanceX == widthHalfSum) || (distanceY == heightHalfSum);
        }else{
            //Otherwise, Not Abutment
            return false;
        }
    }

    /**
     * Check whether two rectangles are distinct of not
     * A help method
     * */
    private boolean distinct(C10E13MyRectangle2D r){
        double distanceX = Math.abs(this.getX() - r.getX());
        double distanceY = Math.abs(this.getY() - r.getY());
        double widthBase = this.getWidth();
        double widthTest = r.getWidth();
        double heightBase = this.getHeight();
        double heightTest = r.getHeight();
        double widthHalfSum = 0.5 * (widthBase + widthTest);
        double heightHalfSum = 0.5 * (heightBase + heightTest);

        return (distanceX > widthHalfSum) || (distanceY > heightHalfSum);
    }

    /**
     * Display the geometric relations of two rectangles
     * */
    public static void displayRectanglesGeometricRelations(C10E13MyRectangle2D rBase, C10E13MyRectangle2D rTest){
        //Check whether one rectangle is contained by another
        boolean containRelationB = rBase.contains(rTest);
        boolean containRelationT = rTest.contains(rBase);
        //Check whether two rectangles overlaps with each other
        boolean overlapRelation = rBase.overlaps(rTest);
        //Check whether two rectangles abutment with each other
        boolean abutmentRelation = rBase.abutments(rTest);
        //Check whether two rectangles distinct with each other
        boolean distinctRelation = rBase.distinct(rTest);

        //Display the relations
        if(containRelationB){
            System.out.println("The test rectangle is Contained inside the base rectangle!");
        }else if(containRelationT){
            System.out.println("The base rectangle is Contained inside the test rectangle!");
        }else{
            System.out.println("Not Contained!");
        }

        if(overlapRelation){
            System.out.println("Overlap!");
        }else{
            System.out.println("Not Overlap!");
        }


        if(abutmentRelation){
            System.out.println("Abutment!");
        }else{
            System.out.println("Not Abutment!");
        }

        if(distinctRelation){
            System.out.println("Distinct!");
        }else{
            System.out.println("Not Distinct!");
        }
    }

}
