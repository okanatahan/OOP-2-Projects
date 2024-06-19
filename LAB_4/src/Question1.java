import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rand = new Random();
        int sum = 0;
        for (int k = 0; k < 10; k++){
            numbers.add(rand.nextInt(90) + 10);
        }
        for (int values : numbers){
            sum += values;
        }
        double average = (double) sum / 10;
        System.out.println("The Sum is: " + sum);
        System.out.println("The Average is: " + average);
    }
}