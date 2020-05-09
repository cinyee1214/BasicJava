import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CS501 Assignment_06
 * @author Xinyi Zhao
 * */
public class TestMyRectangle2D {

    //Methods
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int inputIdx = 1; //A flag to check whether the user kept input or not
        boolean continueInput = true; //A flag to check whether uses' inputs were valid
        /**
         * Exercise 10.13
         * Geometry: the MyRectangle2D class
         * */
        double xTest, yTest; //x- and y- coordinates of the central point of a test rectangle
        double xBase, yBase; //x- and y- coordinates of the central point of a base rectangle
        double wTest, hTest; //the width and height of a test rectangle
        double wBase, hBase; //the width and height of a base rectangle
        C10E13MyRectangle2D rTest = new C10E13MyRectangle2D(); //A test rectangle
        C10E13MyRectangle2D rBase = new C10E13MyRectangle2D(); //A base rectangle

        System.out.println("Exercise 10.13");
        //Display an overview of this problem
        System.out.println("You will define two rectangles. The first is your test rectangle and the second one is a base.\n" +
                "\nWe will check test rectangle for all four of inclusion, overlap, abutment, and distinctions to the base rectangle.\n" +
                "\nNotice: A rectangle is structured by a central point (x, y) and its width and height.");

        while(inputIdx == 1){
            /** Enter a base rectangle*/
            System.out.println("\nDetermine your base rectangle first.");
            do{
                try{
                    System.out.print("\nPlease enter the x-coordinate of the central point of your base rectangle (a real number): ");
                    xBase = input.nextDouble();
                    rBase.setX(xBase);
                    continueInput = false;
                }catch (InputMismatchException e){
                    System.out.println("Your input type must be numeric! Try again\n");
                    input.nextLine();
                }
            }while (continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nPlease enter the y-coordinate of the central point of your base rectangle (a real number): ");
                    yBase = input.nextDouble();
                    rBase.setY(yBase);
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not numeric
                    System.out.println("Your input type must be numeric! Try again\n");
                    input.nextLine();
                }
            }while (continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nPlease enter the width " +
                            "of your base rectangle (a positive real number): ");
                    wBase = input.nextDouble();
                    rBase.setWidth(wBase);
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not numeric
                    System.out.println("Your input type must be numeric! Try again\n");
                    input.nextLine();
                }catch (NumberFormatException e){ //The input is non-positive
                    System.out.println(e.getMessage() + " Try again!\n");
                    input.nextLine();
                }
            }while (continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nPlease enter the height " +
                            "of your base rectangle (a positive real number): ");
                    hBase = input.nextDouble();
                    rBase.setHeight(hBase);
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not numeric
                    System.out.println("Your input type must be numeric! Try again\n");
                    input.nextLine();
                }catch (NumberFormatException e){ //The input is non-positive
                    System.out.println(e.getMessage() + " Try again!\n");
                    input.nextLine();
                }
            }while (continueInput); //End of do-while-loop
            continueInput = true; //Reset the flag
            /** The base rectangle is determined*/


            while(inputIdx == 1){
                /** Enter a test rectangle*/
                System.out.println("\nDetermine your test rectangle.");
                do{//Enter x-coordinate of the central point
                    try{
                        System.out.print("\nPlease enter the x-coordinate of the central point " +
                                "of your test rectangle (a real number): ");
                        xTest = input.nextDouble();
                        rTest.setX(xTest);
                        continueInput = false;
                    }catch (InputMismatchException e){ //The input is not numeric
                        System.out.println("Your input type must be numeric! Try again\n");
                        input.nextLine();
                    }
                }while (continueInput); //End of do-while-loop
                continueInput = true; //Reset the flag

                do{//Enter y-coordinate of the central point
                    try{
                        System.out.print("\nPlease enter the y-coordinate of the central point " +
                                "of your test rectangle (a real number): ");
                        yTest = input.nextDouble();
                        rTest.setY(yTest);
                        continueInput = false;
                    }catch (InputMismatchException e){ //The input is not numeric
                        System.out.println("Your input type must be numeric! Try again\n");
                        input.nextLine();
                    }
                }while (continueInput); //End of do-while-loop
                continueInput = true; //Reset the flag

                do{//Enter the width
                    try{
                        System.out.print("\nPlease enter the width " +
                                "of your test rectangle (a positive real number): ");
                        wTest = input.nextDouble();
                        rTest.setWidth(wTest);
                        continueInput = false;
                    }catch (InputMismatchException e){ //The input is not numeric
                        System.out.println("Your input type must be numeric! Try again\n");
                        input.nextLine();
                    }catch (NumberFormatException e){ //The input is non-positive
                        System.out.println(e.getMessage() + " Try again!\n");
                        input.nextLine();
                    }
                }while (continueInput); //End of do-while-loop
                continueInput = true; //Reset the flag

                do{//Enter the height
                    try{
                        System.out.print("\nPlease enter the height " +
                                "of your Test rectangle (a positive real number): ");
                        hTest = input.nextDouble();
                        rTest.setHeight(hTest);
                        continueInput = false;
                    }catch (InputMismatchException e){ //The input is not numeric
                        System.out.println("Your input type must be numeric! Try again\n");
                        input.nextLine();
                    }catch (NumberFormatException e){ //The input is non-positive
                        System.out.println(e.getMessage() + " Try again!\n");
                        input.nextLine();
                    }
                }while (continueInput);
                continueInput = true; //Reset the flag
                /** The test rectangle is determined*/


                /** Display two rectangles*/
                System.out.println("\nYour base rectangle is: " +
                        "central point (" + rBase.getX() + ", " + rBase.getY() + "), " +
                        "width is " + rBase.getWidth() + ", height is " + rBase.getHeight());
                System.out.println("Your test rectangle is: " +
                        "central point (" + rTest.getX() + ", " + rTest.getY() + "), " +
                        "width is " + rTest.getWidth() + ", height is " + rTest.getHeight());

                /** Display the test result*/
                System.out.println("\nThe geometric relations of these two rectangles are:");
                C10E13MyRectangle2D.displayRectanglesGeometricRelations(rBase, rTest);

                /** Check whether users wish to try another test rectangle or not*/
                do{
                    try{
                        System.out.print("\nWould you like to test a new rectangle" +
                                " with the same base?\n" +
                                "Repeat test (enter 1 for yes or 0 for no)?: ");
                        inputIdx = input.nextInt();
                        if(inputIdx != 0 && inputIdx != 1)
                            throw new NumberFormatException("The repeat index must be 1 or 0!");
                        continueInput = false;
                    }catch (InputMismatchException e){ //The input is not an integer
                        System.out.print("Your input type must be an integer! Try again\n");
                        input.nextLine();
                    }catch (NumberFormatException e){ //The input is not 1 or 0
                        System.out.print(e.getMessage() + " Try again\n");
                        input.nextLine();
                    }
                }while(continueInput); //End of do-while-loop
                continueInput = true; //Reset the flag
            }//End of while-loop
            inputIdx = 1; //Reset the flag
            /** A test process is finished*/


            /** Check whether users wish to repeat the whole process or not*/
            do{
                try{
                    System.out.print("\nWould you like to try this process again" +
                            " with a new base?\n" +
                            "Repeat program (enter 1 for yes or 0 for no)?: ");
                    inputIdx = input.nextInt();
                    if(inputIdx != 0 && inputIdx != 1)
                        throw new NumberFormatException("The repeat index must be 1 or 0!");
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not an integer
                    System.out.print("Your input type must be an integer! Try again\n");
                    input.nextLine();
                }catch (NumberFormatException e){ //The input is not 1 or 0
                    System.out.print(e.getMessage() + " Try again\n");
                    input.nextLine();
                }
            }while(continueInput);
            continueInput = true;
        }

    }
}
