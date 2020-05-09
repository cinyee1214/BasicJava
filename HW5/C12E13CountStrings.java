import javax.swing.*;
import java.io.*;

public class C12E13CountStrings {
    public static void main(String[] args) {
        /**
         * Exercise 12.13
         * Count characters, words, and lines in a file.
         * */

        C12E13CountStrings test = new C12E13CountStrings();

        try {
            test.countInFile();
            System.out.println("\nExercise 12.13 End!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "File not found!");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Count the number of characters, words, and lines in a file
     * */
    private void countInFile() throws IOException {
        int charsCount = 0; //Number of characters
        int wordsCount = 0; //Number of words
        int linesCount = 0; //Number of lines
        
        JFileChooser myFile = new JFileChooser();
        File currentFile = null; //The testing file
        BufferedReader inputStr = null;

        //Choose a testing file
        if (myFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentFile = myFile.getSelectedFile();
            inputStr = new BufferedReader(new FileReader(currentFile));
        }

        if(inputStr == null)
            throw new NullPointerException("Your file is empty!");

        //Read the first line into currentLine
        String currentLine = inputStr.readLine();
        while (currentLine != null) {
            linesCount++;

            //Get number of words in currentLine
            String[] words = currentLine.split(" ");
            wordsCount = wordsCount + words.length;

            //Iterate each word
            for (String word : words) {
                charsCount = charsCount + word.length();
            }

            //Read next line into currentLine
            currentLine = inputStr.readLine();
        }

        //Display the number of characters, words, and lines
        String charStr = "The number of characters in this file is " + charsCount;
        String wordStr = "The number of characters in this file is " + wordsCount;
        String lineStr = "The number of characters in this file is " + linesCount;
        JOptionPane.showMessageDialog(null,
                charStr + "\n" + wordStr + "\n" + lineStr);
    }
}
