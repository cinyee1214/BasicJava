import javax.swing.*;

public class C6E23OccurrencesOfChar {
    public static void main(String[] args) {
        C6E23OccurrencesOfChar test = new C6E23OccurrencesOfChar();

        String inputStr = ""; //The input string in the first loop
        String strOneChar = ""; //The input string hte the nested loop
        char inputChar = '\u0000'; //The chosen character
        int occurrences = -1; //The number of occurrences of the character in the string

        //Flags
        int charIndex = -1; //Flag to check whether the input requirement is a char or not
        int option = -1; //Flag to check whether continue input password or not

        String invalidStrMessage = ": your string is invalid!\n" +
                "Do you want to try again?";
        String invalidCharMessage = ": your character is invalid!\n" +
                "Do you want to try again?";

        //Input a string
        do{
            try{
                inputStr = test.inputString(charIndex);

                //Input a character
                do{
                    try{
                        charIndex = 1;
                        strOneChar = test.inputString(charIndex);
                        inputChar = strOneChar.charAt(0);
                        occurrences = test.count(inputStr, inputChar);
                        String occurrencesMessage = "The occurrence of " + inputChar +
                                " in " + inputStr + " is " + occurrences;
                        //Ask users whether to try this search again or not
                        option = JOptionPane.showConfirmDialog(null, occurrencesMessage +
                                "\nDo you want to try other characters?");
                    }catch (Exception e){
                        option = JOptionPane.showConfirmDialog(null,
                                e.getMessage() + invalidCharMessage);
                    }
                } while (option == JOptionPane.YES_OPTION);
                charIndex = -1;

                //Ask users whether to do the process above again or not
                option = JOptionPane.showConfirmDialog(null,
                        "Do you want to try this process again?\n" +
                                "Click \"Yes\" to input a new string.");


            }catch (Exception e){
                option = JOptionPane.showConfirmDialog(null,
                        e.getMessage() + invalidStrMessage);
            }
        } while (option == JOptionPane.YES_OPTION);

    }

    /**
     * Ask users to input a string
     * Throw exceptions if their strings are invalid
     * @param length    a flag to check whether the input requirement is a char or not
     * */
    private String inputString(int length) throws Exception{
        String aString = ""; //Store the input string

        if(length != 1) {
            String message = "Exercise 6.23\n" +
                    "Please enter your String.\n" +
                    "(Notice: Only letters and digits are allowed! No spaces allowed!)";
            aString = JOptionPane.showInputDialog(message);

            if (!isNotEmpty(aString))
                throw new Exception("You have not enter any string yet");
            if (!isValidFormat(aString))
                throw new Exception("Your string must consists of only letters or digits");
        } else { //input a char
            String message = "Please enter a character searched in your string.\n" +
                    "We will find the number of occurrences of this character in your string.\n" +
                    "(Notice: 1. Only letters and digits are allowed! 2. Search is case sensitive! " +
                    "3. No spaces allowed!)";
            aString = JOptionPane.showInputDialog(message);

            if (!isNotEmpty(aString))
                throw new Exception("You have not enter the character yet");
            if (!isValidFormat(aString))
                throw new Exception("Your character can only be letters or digits");
            if (aString.length() != length)
                throw new Exception("You can only enter one character");
        }

        return aString;
    }

    /**
     * Find the number of occurrences of a specific character in a string
     * Both the string and character are inputted by users
     * Input the string first then following the character.
     * */
    private int count(String str, char a){
        int occurrences = 0;
        int i = 0;
        while(i < str.length()){
            //Find the occurrences
            if(a == str.charAt(i))
                occurrences++;
            i++;
        }
        return occurrences;
    }

    /**
     * Check whether an input password is valid or not following the rule:
     * A password must consists of only letters or digits
     * */
    private boolean isValidFormat(String password){
        boolean isValidFormat = false;
        if(password.matches("[a-zA-Z0-9]*"))
            isValidFormat = true;
        return isValidFormat;
    }

    /**
     * Check whether an input value is empty or not
     * */
    private boolean isNotEmpty(String input){
        boolean isEmpty = true;
        if(input == null || "".equals(input))
            isEmpty = false;
        return isEmpty;
    }

}
