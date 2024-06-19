import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 6; i++){
            System.out.print("Please enter number " + i + ": ");
            int num = input.nextInt();
            list1.add(num);
        }
        System.out.print("Before HashSet: ");
        for (int values : list1){
            System.out.print(values + " ");
        }
        addListToHashSet(list1, set);
        System.out.print("\nAfter HashSet: ");
        for (int values : set){
            System.out.print(values + " ");
        }
    }
    private static void addListToHashSet(List<Integer> list, Set<Integer> mySet){
        for (int value : list){
            mySet.add(value);
        }
    }
}