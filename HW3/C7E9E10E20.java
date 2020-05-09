import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C7E9E10E20 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 10 double numbers:");

        double[] array = new double[10];
        for (int i = 0; i < 10; ++i) {
            array[i] = input.nextDouble();
        }

        //C7E9
        System.out.println("The minimum number is " + min(array));

        //C7E10
        System.out.println("The index of the smallest element is " + indexOfSmallestElement(array));

        //C7E20 test the sorted method
        System.out.println("The sorted array is: ");
        double[] sortedArray = selectionSort(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(sortedArray[i] + " ");
        }


    }

    //C7E9
    public static double min(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    //C7E10
    public static int indexOfSmallestElement(double[] array) {
        int index = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[index] > array[i]) {
                index = i;
            }
        }

        return index;
    }

    //C7E20
    private static double[] selectionSort(double[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            int j = i - 1;
            while (j >= 0) {
                if (array[j] > array[i]) {
                    double tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
                j--;
            }
        }
        return array;
    }
}
