import java.net.SocketOption;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String myStr = null;
        boolean cond = true;
        System.out.println("Please enter 100 characters: ");
        while (cond){
            myStr = input.nextLine();
            if (myStr.length() != 100)
                System.out.println("Please enter exactly 100 characters: ");
            else {
                cond = false;
            }
        }
        System.out.println("Char at index 7: " + myStr.charAt(7));
        System.out.println("Concatenated String: " + myStr.concat("This is concatenated part."));
        String myStr2 = myStr;
        System.out.println(myStr.equals(myStr2));
        System.out.println("Index of \"h\": " + myStr.indexOf('h'));
        System.out.println("Last index of \"h\": " + myStr.lastIndexOf('h'));
        System.out.println("Last index of \"w\": " + myStr.lastIndexOf('w'));
        System.out.println("Length of the string: " + myStr.length());
        System.out.println("Substring with only beginning index: " + myStr.substring(5));
        System.out.println("Substring with beginning and ending index: " + myStr.substring(5,12));
        System.out.println("Split String with comma (,): ");
        String[] split;
        split = myStr.split(" ");
        for (String each : split){
            System.out.print(each + ", ");
        }
        System.out.println("\nTo Lower Case: " + myStr.toLowerCase());
        System.out.println("To Upper Case: " + myStr.toUpperCase());
        String trimStr = "     Trim String     ";
        System.out.println("Trimmed String: " + trimStr.trim());
        }
    }