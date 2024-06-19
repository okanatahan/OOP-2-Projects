import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter a number to search for: ");

        int num = input.nextInt();
        int numCounter = 0, oddCounter = 0, evenCounter = 0;

        ArrayList<Integer> myArrList = new ArrayList<Integer>();

        int m = 100;

        while (m > 0){
            int r = rand.nextInt(99) + 1;
            myArrList.add(r);
            m--;
        }

        System.out.println("ArrayList with 100 random integer numbers between 1-100 before sorting: ");

        for (int value : myArrList){
            if (value == num){
                numCounter++;
            }
            System.out.print(value + " ");
        }

        System.out.println("\nArrayList with 100 random integer numbers between 1-100 after sorting: ");
        Collections.sort(myArrList);

        for (int value : myArrList){
            if (value % 2 == 0){
                evenCounter++;
            } else {
                oddCounter++;
            }
            System.out.print(value + " ");
        }
        
        System.out.println("\nThe number (" + num + ") occurred " + numCounter + " times in your ArrayList.");
        System.out.println("Odd Number occurrences: " + oddCounter);
        System.out.println("Even Number occurrences: " + evenCounter);
    }
}