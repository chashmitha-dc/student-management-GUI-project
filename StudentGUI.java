import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class StudentGUI extends JFrame implements ActionListener {

    JTextField idField, nameField, deptField, marksField;
    JTextArea outputArea;
    JButton addBtn, viewBtn, deleteBtn, clearBtn;

    StudentService service = new StudentService();

    public StudentGUI() {

        setTitle("Student Management System");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -------- HEADING TITLE --------
        JLabel titleLabel = new JLabel("STUDENT MANAGEMENT SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);


        // -------- TOP PANEL (INPUTS) --------
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        inputPanel.add(new JLabel("Marks:"));
        marksField = new JTextField();
        inputPanel.add(marksField);

       // -------- TOP CONTAINER (TITLE + INPUTS) --------
        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);



        // -------- CENTER PANEL (OUTPUT) --------
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // -------- BOTTOM PANEL (BUTTONS) --------
        JPanel buttonPanel = new JPanel();

        addBtn = new JButton("Add Student");
        viewBtn = new JButton("View Students");
        deleteBtn = new JButton("Delete Student");
        clearBtn = new JButton("Clear");

        addBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // -------- EVENT HANDLING --------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == addBtn) {

                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String dept = deptField.getText();
                int marks = Integer.parseInt(marksField.getText());

                service.addStudent(id, name, dept, marks);
                outputArea.setText("Student added successfully.\n");

            } else if (e.getSource() == viewBtn) {

                outputArea.setText(service.viewStudents());

            } else if (e.getSource() == deleteBtn) {

                int id = Integer.parseInt(idField.getText());
                service.deleteStudent(id);
                outputArea.setText("Student deleted successfully.\n");

            } else if (e.getSource() == clearBtn) {

                idField.setText("");
                nameField.setText("");
                deptField.setText("");
                marksField.setText("");
                outputArea.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}
