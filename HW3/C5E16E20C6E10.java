import java.util.ArrayList;
import java.util.Scanner;

public class C5E16E20C6E10 {

    public static void main(String[] args) {

        System.out.println("Please input an positive integer more than 1:");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        //C5E16
        ArrayList<Integer> list = new ArrayList<>();
        list = findFactor(num, list);
        System.out.println("C5E16_The smallest factors in increasing order for this input: " + list);

        //C5E20
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int i = 2; i < 1000; ++i) {
            if (findFactor(i, new ArrayList<Integer>()).size() == 1) {
                primeList.add(i);
            }
        }
        System.out.print("C5E20_All prime numbers between 2 and 1000: ");
        for (int j = 0; j < primeList.size(); ++j) {
            if (j % 8 == 0) {
                System.out.println();
            }
            System.out.print(primeList.get(j));
            System.out.print(" ");
        }
        System.out.println();


        //C6E10
        System.out.print("The first 50 prime numbers are");
        printPrimeNumbers(50);
    }

    //C5E16 The smallest factors in increasing order for an integer
    private static ArrayList<Integer> findFactor(int num, ArrayList<Integer> list) {
        for (int i = 2; i <= num; ++i) {
           if (num % i == 0) {
               list.add(i);
               num = num / i;
               list = findFactor(num, list);
               break;
           }
       }
        return list;
    }

    //C6E10 isPrime
    private static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; ++divisor) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
    //print first 50 prime numbers
    private  static void printPrimeNumbers(int numOfPrimes) {
        int count = 0, number = 2;
        while (count < numOfPrimes) {
            if (isPrime(number)) {
                if (count % 10 == 0) {
                    System.out.println();
                }
                System.out.print(number + " ");

                count++;
            }
            number ++;
        }
    }


}
