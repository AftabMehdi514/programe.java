import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogInForm implements ActionListener {
    private static ArrayList<Student> students;
    private static ArrayList<Teacher> teachers;
    private static ArrayList<Admin> admins;
    private String role;
    JLabel nameL, pwdL;
    JTextField nameTF, pwdTF;
    JButton logInButton, departmentBtn;
    JComboBox<String> departmentsComboBox;
    public static JFrame loginFrame;
    JPasswordField pwdTf;

    LogInForm() {
    }

    LogInForm(ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Admin> admins, String role) {
        this.students = students;
        this.teachers = teachers;
        this.admins = admins;
        this.role = role;
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints Gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 20);
        loginFrame = new JFrame("Log In Page");
        loginFrame.setSize(App.width, App.height);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Log In yourself here!"));
        nameL = new JLabel("Enter Your Name : ");
        nameL.setFont(App.boldFont);
        pwdL = new JLabel("Enter your Password: ");
        pwdL.setFont(App.boldFont);
        nameTF = new JTextField(20);
        nameTF.setFont(App.boldFont);
         pwdTF = new JPasswordField(20);
            pwdTF.setFont(App.boldFont);
            pwdTF.setToolTipText("Password must contain 8 characters!");
        logInButton = new JButton("Log In");
        logInButton.setForeground(App.fgColor);
        logInButton.setBackground(Color.BLACK);
        logInButton.setFont(App.boldFont);
        logInButton.addActionListener(this);
        gbc.gridy = 1;
        panel.add(nameL, gbc);
        gbc.gridy = 2;
        panel.add(nameTF, gbc);
        gbc.gridy = 3;
        panel.add(pwdL, gbc);
        gbc.gridy = 4;
        panel.add(pwdTF, gbc);
        if (!(role.equals("Admin"))) {
            gbc.gridy = 5;
            panel.add(App.departmentSelector, gbc);
        }

        JPanel regJPanel = new JPanel();
        regJPanel.add(logInButton);
        JPanel container = new JPanel(new GridBagLayout());
        container.setBorder(BorderFactory.createTitledBorder("LogIn Panel"));
        Gbc.gridx = 0;
        Gbc.gridy = 0;
        container.add(panel, Gbc);
        gbc.gridy = 6;
        container.add(regJPanel, gbc);
        loginFrame.add(container, BorderLayout.CENTER);
        loginFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (students.isEmpty() && admins.isEmpty() && teachers.isEmpty()) {
            App.showmessage("Register yourself first please. Going to Main window");
            loginFrame.setVisible(false);
        } else {
            if (role.equals("Student")) {
                validateStudent();
            } else if (role.equals("Teacher")) {
                validateTeacher();
            } else if (role.equals("Admin")) {
                validateAdmin();
            }
        }

    }

    public void validateStudent() {
        boolean flag = false;
        Student foundStudent = null;
        for (Student s : students) {
            if (s.userName.equals(nameTF.getText())) {
                App.showmessage(" Student Found");
                if (!(s.userPassword.equals(pwdTF.getText()))) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    foundStudent = s;
                    loginFrame.setVisible(false);
                    App.logInKey = true;
                    flag = true;
                    break;
                }
            }
        }
        if (flag && foundStudent != null) {
            for (Student s : students) {
                System.out.println("Student: " + s.userName);
            }
            StudentDashboard sd = new StudentDashboard(foundStudent);
        } else {
            App.showmessage("Student Not Found! Sign up First please");
            SignUp signUp=new SignUp(students, teachers, admins, role);
            loginFrame.dispose();
        }
    }

    public void validateTeacher() {
        boolean flag = false;
        Teacher foundTeacher = null;
        for (Teacher teacher : teachers) {
            if (teacher.userName.equals(nameTF.getText())) {
                
                if (!teacher.userPassword.equals(pwdTF.getText())) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    foundTeacher = teacher;
                    loginFrame.setVisible(false);
                    App.logInKey = true;
                    flag = true;
                    break;
                }
            }
        }
        if (flag && foundTeacher != null) {
            JOptionPane.showMessageDialog(null, "Log In successful!", null, JOptionPane.INFORMATION_MESSAGE);
           TeacherDashboard teacherDashboard = new TeacherDashboard(foundTeacher, students);
        } else {
            App.showmessage("Teacher Not Found. Sign up First please");
            SignUp signUp=new SignUp(students, teachers, admins, role);
            loginFrame.dispose();
        }
    }
    
    public void validateAdmin() {
        boolean flag = false;
        Admin foundAdmin = null;
        for (Admin admin : admins) {
            if (admin.userName.equals(nameTF.getText())) {
                App.showmessage("Admin Found");
                if (!admin.userPassword.equals(pwdTF.getText())) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    foundAdmin = admin;
                    loginFrame.setVisible(false);
                    App.logInKey = true;
                    flag = true;
                    break;
                }
            }
        }
        if (flag && foundAdmin != null) {
            JOptionPane.showMessageDialog(null, "Log In successful!", null, JOptionPane.INFORMATION_MESSAGE);
            
             AdminDashboard adminDashboard=new AdminDashboard(foundAdmin, students, teachers, null);
        } else {
            App.showmessage("Admin Not Found. Sign up First please");
            SignUp signUp=new SignUp();
            loginFrame.dispose();
        }
    }
}
