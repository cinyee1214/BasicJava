import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTriangle {
    //Methods
    public static void main(String[] args) {
        //Local fields
        Scanner inputNum = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        int inputIdx = 1;
        boolean continueInput = true;
        /**
         * Exercise 11.1
         * The Triangle Class
         * */
        double side1 = -1, side2 = -1, side3 = -1;
        double area, perimeter;
        String color = "white";
        String[] colors = {"white", "black", "red", "green", "blue"};
        boolean isFilled = false;

        System.out.println("Exercise 11.1");
        System.out.println("You will define a triangle by enter the length of each sides.\n" +
                "You also need to determine the triangle's color and whether to fill the color.\n" +
                "We will display the result of your triangle.");

        while(inputIdx == 1){
            /** Enter three sides*/
            System.out.println("\nDetermine your three sides first.");
            do{
                try{
                    System.out.print("\nPlease enter your first side: ");
                    side1 = inputNum.nextDouble();
                    if(side1 <= 0)
                        throw new NumberFormatException("Your side must be positive!");
                    continueInput = false;
                }catch (InputMismatchException e){
                    System.out.println("Your input type must be numeric! Try again\n");
                    inputNum.nextLine();
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }
            }while(continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nPlease enter your second side: ");
                    side2 = inputNum.nextDouble();
                    if(side2 <= 0)
                        throw new NumberFormatException("Your side must be positive!");
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not numeric
                    System.out.println("Your input type must be numeric! Try again\n");
                    inputNum.nextLine();
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }
            }while(continueInput); //End of do-while-loop
            continueInput = true; //Reset the flag

            do{//Enter the third side
                try{
                    System.out.print("\nPlease enter your third side: ");
                    side3 = inputNum.nextDouble();
                    if(side3 <= 0)
                        throw new NumberFormatException("Your side must be positive!");
                    if(side1 + side2 <= side3 ||
                            side1 + side3 <= side2 ||
                            side2 + side3 <= side1)
                        throw new IllegalTriangleException("Invalid triangle!\n" +
                                "In a triangle, the sum of any two sides is greater than the other side. ");
                    continueInput = false;
                }catch (InputMismatchException e){ //The input is not numeric
                    System.out.println("Your input type must be numeric! Try again\n");
                    inputNum.nextLine();
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }catch (IllegalTriangleException e){
                    System.out.println(e.getMessage() + "Try again\n");
                    inputNum.nextLine();
                }
            }while(continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nChoose a color we mentioned here: " +
                            "white, black, red, green, or blue\n" +
                            "Please enter your color " +
                            "(type the color's word; no spaces between alphabets; case sensitive): ");
                    color = inputStr.nextLine();
                    System.out.println("Your chosen color is " + color);
                    boolean getColor = false;
                    for(String tempColor : colors){
                        if(tempColor.equals(color)){
                            getColor = true;
                            break;
                        }
                    }
                    if(!getColor)
                        throw new InputMismatchException("You must choose a color mentioned above!");
                    continueInput = false;
                }catch (InputMismatchException e){
                    System.out.println(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }
            }while (continueInput);
            continueInput = true;

            do{
                try{
                    System.out.print("\nPlease determine to fill in the color or not " +
                            "(enter 1 for yes or 0 for no): ");
                    int fillFlag = inputNum.nextInt();
                    if(fillFlag != 0 && fillFlag != 1)
                        throw new NumberFormatException("The fill-flag must be 1 or 0!");
                    if(fillFlag == 1){
                        isFilled = true;
                    }else{
                        isFilled = false;
                    }
                    continueInput = false;
                }catch (InputMismatchException e){
                    System.out.println("Your input type must be numeric! Try again\n");
                    inputNum.nextLine();
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }
            }while(continueInput);
            continueInput = true;

            C11E1Triangle myTriangle = new C11E1Triangle(side1, side2, side3); //Create a new triangle
            myTriangle.myGeometric.setColor(color); //Set the color of the triangle
            myTriangle.myGeometric.setFilled(isFilled); //Set the fill-in status of the triangle
            area = myTriangle.getArea();
            perimeter = myTriangle.getPerimeter();

            /** Display the properties of the triangle*/
            System.out.println(myTriangle.myGeometric.toString());
            System.out.println("The area is " + area + ", and the perimeter is " + perimeter);


            /** Check whether users wish to repeat the whole process or not*/
            do{
                try{
                    System.out.print("\nWould you like to try this process again?\n" +
                            "Repeat program (enter 1 for yes or 0 for no)?: ");
                    inputIdx = inputNum.nextInt();
                    if(inputIdx != 0 && inputIdx != 1)
                        throw new NumberFormatException("The repeat index must be 1 or 0!");
                    continueInput = false;
                }catch (InputMismatchException e){
                    System.out.print("Your input type must be an integer! Try again\n");
                    inputNum.nextLine();
                }catch (NumberFormatException e){
                    System.out.print(e.getMessage() + " Try again\n");
                    inputNum.nextLine();
                }
            }while(continueInput);
            continueInput = true;
        }

    }
}
