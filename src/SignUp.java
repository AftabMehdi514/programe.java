import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class SignUp implements ActionListener,ItemListener {
    private static ArrayList<Student> students;
private static ArrayList<Teacher> teachers;
private static ArrayList<Admin> admins;
private String role;
private String department,studentBatch;
JLabel nameL, pwdL, confirmPwdL;
JTextField nameTF;
JPasswordField pwdTf,confirmPwdTf;
JButton SignUpButton;
public static JFrame signUpFrm;

SignUp() {
}

SignUp(ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Admin> admins, String role) {
            this.students = students;
            this.teachers = teachers;
            this.admins = admins;
            this.role = role;

            if (role.equals("Student")) {
                this.students = students;
            }

            if (role.equals("Teacher")) {
                this.teachers = teachers;
            }

            if (role.equals("Admin")) {
                this.admins = admins;
            }


        GridBagConstraints gbc=new GridBagConstraints();
        GridBagConstraints Gbc=new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); 
         signUpFrm = new JFrame("SignUp Page");
        signUpFrm.setSize(App.width, App.height);
        signUpFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrm.setVisible(true);
        JPanel panel=new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Sign Up yourself here!"));
         nameL=new JLabel("Enter Your Name : ");nameL.setFont(App.boldFont);
         pwdL=new JLabel("Enter your Passowrd: ");pwdL.setFont(App.boldFont);
         confirmPwdL=new JLabel("Confirm your Password: ");pwdL.setFont(App.boldFont);
         nameTF=new JTextField(20);nameTF.setFont(App.boldFont);
         nameTF.setToolTipText("Enter your name here");
         pwdTf=new JPasswordField(20);pwdTf.setFont(App.boldFont);
         confirmPwdTf=new JPasswordField(20);
         ;confirmPwdTf.setFont(App.boldFont);
        confirmPwdTf.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==e.VK_ENTER)
                actionPerformed(null);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
         SignUpButton=new JButton("Sign Up");
         SignUpButton.setForeground(App.fgColor); SignUpButton.setBackground(Color.BLACK);
         SignUpButton.setFont(App.boldFont);
         SignUpButton.addActionListener(this);
        gbc.gridy=1;
        panel.add(nameL,gbc);
        gbc.gridy=2;
        panel.add(nameTF,gbc);
        gbc.gridy=3;
        panel.add(pwdL,gbc);
        gbc.gridy=4;
        panel.add(pwdTf,gbc);
        gbc.gridy=5;
        panel.add(confirmPwdL,gbc);
        gbc.gridy=6;
        panel.add(confirmPwdTf,gbc);
        if(!(role.equals("Admin"))){
            gbc.gridy=7;
            panel.add(App.departmentSelector);
            App.departmentSelector.addItemListener(this);
         }
         if(role.equals("Student")){
           gbc.gridx=1;
           panel.add(App.batchSelector);
           App.batchSelector.addItemListener(this);
         }
        
         JPanel regJPanel=new JPanel();
         regJPanel.add(SignUpButton);
        JPanel container=new JPanel(new GridBagLayout());
        container.setBorder(BorderFactory.createTitledBorder("SignUp Panel"));
        Gbc.gridx=0;
        Gbc.gridy=0;
        container.add(panel,Gbc);
        gbc.gridy=5;
        container.add(regJPanel,gbc);
        signUpFrm.add(container,BorderLayout.CENTER);
      //  signUpFrm.setVisible(true);

    }
    public void  actionPerformed(ActionEvent e){
        if(App.departmentSelector.getSelectedIndex()==0||nameTF.equals("")||pwdTf.getText().equals("")){
            App.showmessage("All Fields are mandatory!");
            return;
        }
        
        String name=nameTF.getText();
        String pwd=pwdTf.getText();
        String confirm=confirmPwdTf.getText();
        if(!(validateInfo(pwd))){
            return;
        }
        if(!(confirm.equals(pwd))){
            pwdTf.setText(" ");
            confirmPwdTf.setText(" ");
            confirmPwdTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            pwdTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Password Confirmatin unsucessful!", confirm, JOptionPane.ERROR_MESSAGE);
            
        }
        else{
             if(role.equals("Student")){
                Student newStudent = new Student(name, pwd, department,studentBatch);
                students.add(newStudent);
                LogInForm logInForm = new LogInForm(students, teachers, admins, role);
             }
             if (role.equals("Teacher")) {
                teachers.add(new Teacher(name, pwd, department));
                LogInForm logInForm = new LogInForm(students, teachers, admins, role);
            }
            if (role.equals("Admin")) {
                admins.add(new Admin(name, pwd));
                LogInForm logInForm = new LogInForm(students, teachers, admins, role);
                System.exit(0);
            }
            
             signUpFrm.dispose();

        }
        
         
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getSource().equals(App.departmentSelector)){
            
            department=App.departmentNames[App.departmentSelector.getSelectedIndex()];
        }
        if(e.getSource().equals(App.batchSelector)){
            studentBatch=App.batch[App.batchSelector.getSelectedIndex()];
        }
    }
    private boolean validateInfo(String pwd){
        if(role.equals("Student")){
            for(Student s:students){
               if(s.userPassword.equals(pwd)){
                App.showmessage("Password  already taken please use different password!");
                return false;
               }
            }
        }
        if(role.equals("Admin")){
            for(Admin s:admins){
              if(s.userPassword.equals(pwd)){
                App.showmessage("Password  already taken please use different password!");
                return false;
               }
            }
        }
        if(role.equals("Teacher")){
            for(Teacher s:teachers){
               if(s.userPassword.equals(pwd)){
                App.showmessage("Password  already taken please use different password!");
                return false;
               }
            }
        }
       return true;
    }
}
