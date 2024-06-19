import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class switchList extends JFrame {
    private JPanel panel1;
    private JTextField CourseInput;
    private JButton AddButton;
    private JButton RemoveButton;
    private JLabel label1;
    private JTextArea AddText;
    private JList AddList;
    private JList RemoveList;
    private DefaultListModel model = new DefaultListModel();
    private DefaultListModel model2 = new DefaultListModel();

    public switchList() {
        AddList.setModel(model);
        RemoveList.setModel(model2);
        setTitle("JList App");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel1);
        setVisible(true);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = CourseInput.getText();
                model.addElement(courseName);
                CourseInput.setText("");
            }
        });

        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model2.addElement(AddList.getSelectedValue());
                model.removeElement(AddList.getSelectedValue());

                AddList.setBackground(Color.RED);
                RemoveList.setBackground(Color.GREEN);
            }
        });
    }

    public static void main(String[] args) {
        new switchList();
    }
}