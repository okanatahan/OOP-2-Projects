import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTabbedP extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField username;
    private JPasswordField password;
    private JButton EnterButton;
    private JButton MenubarButton;

    public JTabbedP() {
        setTitle("JTabbedPane");
        setSize(675, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(new FlowLayout());
        add(panel1);
        setVisible(true);

        EnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usrname = username.getText();
                String psw = password.getText();

                if (usrname.equals("admin") && psw.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Redirecting to Home Page");
                    tabbedPane1.setSelectedIndex(0);
                }
            }
        });

        MenubarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menubar mb = new menubar();
                mb.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new JTabbedP();
    }
}
