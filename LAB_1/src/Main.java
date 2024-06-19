import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please, enter an integer for array size: ");
        int size = input.nextInt();
        double[] myArr = new double[size];
        for (int i = 0; i < size; i++){
            myArr[i] = rand.nextDouble(90) + 10;
        }
        System.out.print("Final Array: ");
        for (double values : myArr){
            System.out.print(values + " ");
        }
    }
}