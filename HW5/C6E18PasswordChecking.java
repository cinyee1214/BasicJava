import javax.swing.*;

public class C6E18PasswordChecking {
    /**
     * Exercise 6.18
     * Check password
     * */
    public static void main(String[] args) {
        C6E18PasswordChecking test = new C6E18PasswordChecking();

        String validMessage = "Valid Password\n" +
                "Do you want to try again?";
        String invalidMessage = ": Invalid Password\n" +
                "Do you want to try again?";
        int option = -1; //Flag to check whether continue input password or not

        do{
            try{
                //Input a password
                //Then check whether it was valid or not
                test.inputPassword(8);
                option = JOptionPane.showConfirmDialog(null, validMessage);
            }catch (Exception e){ //Invalid password
                option = JOptionPane.showConfirmDialog(null,
                        e.getMessage() + invalidMessage);
            }

        } while (option == JOptionPane.YES_OPTION);
    }

    private void inputPassword(int length) throws Exception {
        String password = ""; //Declare the input password
        String inputGuide = "Exercise 6.18\n" +
                " Please enter your password: Must be 8 or more letters or numerical digits and 2 of which must be digits.";
        password = JOptionPane.showInputDialog(inputGuide);

        if(!isNotEmpty(password))
            throw new Exception("You have not enter the password yet");
        if(!isValidLength(password, length))
            throw new Exception("Your password must have at least " + length +" characters");
        if(!isValidFormat(password))
            throw new Exception("Your password must consists of only letters or digits");
        if(!isValidDigitsNumber(password))
            throw new Exception("Your password must contain at least two digits");

    }


    /**
     * Check whether an input password is valid or not following the rule:
     * A password must have at least eight characters
     * A help method of inputPassword()
     * @param password    the input string to be checked
     * @param length     the shortest required length of a string to be valid
     * */
    private boolean isValidLength(String password, int length){
        boolean isValidLength = false;
        if(password.length() >= length)
            isValidLength = true;
        return isValidLength;
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
     * Check whether an input password is valid or not following the rule:
     * A password must contain at least two digits
     * */
    private boolean isValidDigitsNumber(String password){
        boolean isValidDigitsNumber = false;
        if(password.matches(".*[0-9].*[0-9].*"))
            isValidDigitsNumber = true;
        return isValidDigitsNumber;
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
