// Make the design below and create the code to perform four mathematical operations
// through this interface. (You must design the interface from the form panel, not with code!)
// Ensure code security to prevent division by zero error
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class question2 extends JFrame{
    private JPanel panel1;
    private JTextField num1Input;
    private JTextField num2Input;
    private JTextField operatorInput;
    private JTextField resultOutput;
    private JButton CALCULATEButton;

    public question2() {
        setTitle("Calculator");
        setSize(600, 400);
        add(panel1);

        CALCULATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(num1Input.getText());
                int num2 = Integer.parseInt(num2Input.getText());
                String sign = operatorInput.getText();

                int result = 0;
                String str;

                switch (sign){
                    case "+":
                        result = num1 + num2;
                        str = Integer.toString(result);
                        resultOutput.setText(str);
                        break;
                    case "-":
                        result = num1 - num2;
                        str = Integer.toString(result);
                        resultOutput.setText(str);
                        break;
                    case "*":
                        result = num1 * num2;
                        str = Integer.toString(result);
                        resultOutput.setText(str);
                        break;
                    case "/":
                        if (num2 != 0){
                            result = num1 / num2;
                            str = Integer.toString(result);
                            resultOutput.setText(str);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by 0", "Division Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            }
        });
    }
    public static void main(String[] args){
        question2 fm = new question2();
        fm.setVisible(true);
    }
}
