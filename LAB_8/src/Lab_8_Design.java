import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_8_Design extends JFrame{
    private JPanel panel1;
    private JTextArea outputArea;
    private JRadioButton multiplesOption;
    private JRadioButton primeOption;
    private JButton showButton;

    public Lab_8_Design(){
        setTitle("Radio Box Design");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel1);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isMulti = multiplesOption.isSelected();
                boolean isPrime = primeOption.isSelected();

                if (isMulti) {
                    outputArea.setText("");
                    outputArea.append(multipleFind());
                } else if (isPrime) {
                    outputArea.setText("");
                    outputArea.append(primeFind());
                }
            }
        });
    }

    public static String multipleFind() {
        String multiples = "";

        for (int i = 0; i <= 100; i++) {
            if (i % 15 == 0) {
                multiples = multiples + i + ", ";
            }
        }
        return multiples.substring(0, multiples.length() - 2);
    }

    public static String primeFind() {
        String primeNumbers = "";

        for (int i = 0; i <= 100; i++){
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter += 1;
                }
            }
            if (counter == 2) {
                primeNumbers = primeNumbers + i + ", ";
            }
        }
        return primeNumbers.substring(0, primeNumbers.length() - 2);
    }

    public static void main(String[] args){
        Lab_8_Design ds = new Lab_8_Design();
    }
}