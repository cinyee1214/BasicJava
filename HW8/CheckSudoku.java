import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class CheckSudoku {
    private static boolean checkNumberRange(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] <= 0 || arr[i][j] > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku(int[][] arr) {
        for (int[] line : arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (set.contains(line[i])) {
                    return false;
                }
                set.add(line[i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            HashSet<Integer> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (set.contains(arr[row][col])) {
                    return false;
                }
                set.add(arr[row][col]);
            }
        }

        for (int row = 0; row <= 6; row += 3) {
            for (int col = 0; col <= 6; col += 3) {
                HashSet<Integer> set = new HashSet<>();
                for (int offset_row = 0; offset_row < 3; offset_row++) {
                    for (int offset_col = 0; offset_col < 3; offset_col++) {
                        int curr_row = row + offset_row;
                        int curr_col = col + offset_col;
                        if (set.contains(arr[curr_row][curr_col])) {
                            return false;
                        }
                        set.add(arr[curr_row][curr_col]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("This program will try to test whether sudoku answer is right!");
        File file = new File("sudoku.txt");
        Scanner sc;
        String line = null;
        int num = 1;
        try {
            sc = new Scanner(file);
        } catch (Exception ex) {
            System.out.println("The file is not existed.");
            return;
        }
        try {
            while (sc.hasNextLine()) {
                if (line != null && line.equals("end")) {
                    return;
                }
                line = sc.nextLine();
                int[][] arr = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    Scanner ls = new Scanner(line);
                    for (int j = 0; j < 9; j++) {
                        arr[i][j] = ls.nextInt();
                    }
                    line = sc.nextLine();
                }
                if (!checkNumberRange(arr)) {
                    System.out.println("The number should be between 1 - 9!");
                    return;
                }
                if (isValidSudoku(arr)) {
                    System.out.println("The " + num + " sudoku is correct!");
                } else {
                    System.out.println("The " + num + " sudoku is wrong!");
                }
                num += 1;
            }
        } catch (Exception ex) {
            System.out.println("The file format is not valid!");
        }
    }
}
