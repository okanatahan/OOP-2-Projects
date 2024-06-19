// Question 1: Write a program that uses all JOptionPane showInputDialog, showConfirmDialog,
// showOptionDialog and showMessageDialog functions for four mathematical operations. Ensure code
// security by using a try-catch block in case the second number is entered as 0 in the division
// operation.
import javax.swing.*;

public class Question1{
    private static final String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};
    private static int result = 0, num1 = 0, num2 = 0;

    public static int selectionMethod(int num1, int num2){
        int selection = JOptionPane.showOptionDialog(null, "Select an operation: ", "Calculator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);
        int option = JOptionPane.showConfirmDialog(null, "Are you sure", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.NO_OPTION || option == JOptionPane.CLOSED_OPTION){
            return selectionMethod(num1, num2);
        }
        else if (option == JOptionPane.YES_OPTION){
            if (selection == 0){
                result = num1 + num2;
            }
            else if (selection == 1){
                result = num1 - num2;
            }
            else if (selection == 2){
                result = num1 * num2;
            }
            else if (selection == 3){
                if (num2 != 0){
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot Divide by 0, Please Type Again.", "Calculator", JOptionPane.ERROR_MESSAGE);
                    return function();
                }
            }
        }
        return result;
    }

    public static int function() {
        String first = JOptionPane.showInputDialog("Please enter the first number");
        String second = JOptionPane.showInputDialog("Please enter the second number");

        try {
            num1 = Integer.parseInt(first);
            num2 = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Number Format, Please Type Again.", "Calculator", JOptionPane.ERROR_MESSAGE);
            return function();
        }
        return selectionMethod(num1, num2);
    }

    public static void main(String[] args){
        int res = function();

        JOptionPane.showMessageDialog(null, "Result: " + res, "Calculator", JOptionPane.PLAIN_MESSAGE);
    }
}