import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class UniversityApp extends JFrame{
    private JPanel panel1;
    private JTable tbl;
    private JRadioButton stdButton;
    private JRadioButton acadButton;
    private JTextField nameInput;
    private JTextField surnameInput;
    private JTextField courseInput;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton INSERTButton;

    private Connection connection = null;
    private int selectedId = -1;

    public UniversityApp() {
        add(panel1);
        setTitle("University App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        connectToDatabase();
        tbl.setModel(buildTableModel());
        tbl.setRowHeight(0, 20);

        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbl.getSelectedRow();
                if (row != -1) {
                    selectedId = Integer.parseInt(tbl.getValueAt(row, 0).toString());
                    nameInput.setText(tbl.getValueAt(row, 1).toString());
                    surnameInput.setText(tbl.getValueAt(row, 2).toString());
                    courseInput.setText(tbl.getValueAt(row, 3).toString());
                }
            }
        });

        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                String surname = surnameInput.getText();
                String courseCode = courseInput.getText();

                if (stdButton.isSelected()) {
                    String sql = "INSERT INTO Student (Name, Surname, CourseCode) VALUES (?, ?, ?)";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setString(2, surname);
                        stmt.setString(3, courseCode);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student inserted successfully");
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Insert failed: " + exception.getMessage());
                    }
                } else if (acadButton.isSelected()) {
                    String sql = "INSERT INTO Academician (Name, Surname, CourseCode) VALUES (?, ?, ?)";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setString(2, surname);
                        stmt.setString(3, courseCode);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Academician inserted successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Insert failed: " + ex.getMessage());
                    }
                }

                tbl.setModel(buildTableModel());
            }
        });

        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedId == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a record to update");
                    return;
                }

                String name = nameInput.getText();
                String surname = surnameInput.getText();
                String courseCode = courseInput.getText();

                if (stdButton.isSelected()) {
                    String sql = "UPDATE Student SET Name = ?, Surname = ?, CourseCode = ? WHERE StudentID = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setString(2, surname);
                        stmt.setString(3, courseCode);
                        stmt.setInt(4, selectedId);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student updated successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update failed: " + ex.getMessage());
                    }
                } else if (acadButton.isSelected()) {
                    String sql = "UPDATE Academician SET Name = ?, Surname = ?, CourseCode = ? WHERE AcademicianID = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setString(2, surname);
                        stmt.setString(3, courseCode);
                        stmt.setInt(4, selectedId);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Academician updated successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update failed: " + ex.getMessage());
                    }
                }

                selectedId = -1;
                tbl.setModel(buildTableModel());
            }
        });

        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedId == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a record to delete");
                    return;
                }

                if (stdButton.isSelected()) {
                    String sql = "DELETE FROM Student WHERE StudentID = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, selectedId);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student deleted successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Delete failed: " + ex.getMessage());
                    }
                } else if (acadButton.isSelected()) {
                    String sql = "DELETE FROM Academician WHERE AcademicianID = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, selectedId);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Academician deleted successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Delete failed: " + ex.getMessage());
                    }
                }

                selectedId = -1;
                tbl.setModel(buildTableModel());
            }
        });

        stdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbl.setModel(buildTableModel());
            }
        });

        acadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbl.setModel(buildTableModel());
            }
        });
    }

    public TableModel buildTableModel() {
        DefaultTableModel model = new DefaultTableModel();

        String[] columns = {"ID", "Name", "Surname", "Course"};
        for (String column : columns) {
            model.addColumn(column);
        }

        ArrayList<User> users = getUsers();
        for (User user : users) {
            Object[] row = { user.getId(), user.getName(), user.getSurname(), user.getCourseCode() };
            model.addRow(row);
        }

        return model;
    }

    public ArrayList<User> getUsers() {
        ResultSet resultSet;
        ArrayList<User> users = null;

        try {
            Statement statement = connection.createStatement();
            String sql = stdButton.isSelected() ? "SELECT * FROM Student" : "SELECT * FROM Academician";
            users = new ArrayList<>();
            resultSet = statement.executeQuery(sql);

            boolean isStd = stdButton.isSelected();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(isStd ? "StudentID" : "AcademicianID"), resultSet.getString("Name"), resultSet.getString("Surname"), resultSet.getString("CourseCode")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load the data: " + e.getMessage());
        }

        return users;
    }

    public class User {
        private int id;
        private String name;
        private String surname;
        private String courseCode;

        public User(int ID, String Name, String Surname, String CourseCode) {
            this.id = ID;
            this.name = Name;
            this.surname = Surname;
            this.courseCode = CourseCode;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getSurname() {
            return surname;
        }
        public String getCourseCode() {
            return courseCode;
        }
    }

    private void connectToDatabase() {
        try {
            final String userName = "root";
            final String password = "1234";
            final String dbURL = "jdbc:mysql://localhost:3306/university";
            connection = DriverManager.getConnection(dbURL ,userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new UniversityApp();
    }
}
