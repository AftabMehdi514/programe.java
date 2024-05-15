import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class SignUp implements ActionListener,ItemListener {
    private Student[] students;
    private Teacher[] teachers;
    private Admin[] admins;
    private String role;
    private String department;
   JLabel nameL,pwdL,confirmPwdL;
   JTextField nameTF,pwdTF,confirmPwdTf;
   JButton SignUpButton;
   public static JFrame signUpFrm;


    SignUp(){
       
    }

    SignUp(Student[] students,Teacher[] teachers,Admin[] admins,String role){
        this.role=role;
        if(role.equals("Student")){
            this.students=students;
        }
        
        if(role.equals("Teacher")){
            this.teachers=teachers;
        }
        if(role.equals("Admin")){
            this.admins=admins;
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
         pwdTF=new JTextField(20);pwdTF.setFont(App.boldFont);
         confirmPwdTf=new JTextField(20);confirmPwdTf.setFont(App.boldFont);
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
        panel.add(pwdTF,gbc);
        gbc.gridy=5;
        panel.add(confirmPwdL,gbc);
        gbc.gridy=6;
        panel.add(confirmPwdTf,gbc);
        if(!(role.equals("Admin"))){
            gbc.gridy=7;
            panel.add(App.departmentSelector);
            App.departmentSelector.addItemListener(this);
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

    }
    public void  actionPerformed(ActionEvent e){
        String name=nameTF.getText();
        String pwd=pwdTF.getText();
        String confirm=confirmPwdTf.getText();
        if(!(confirm.equals(pwd))){
            pwdTF.setText(" ");
            confirmPwdTf.setText(" ");
            confirmPwdTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            pwdTF.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Password Confirmatin unsucessful!", confirm, JOptionPane.ERROR_MESSAGE);
            
        }
        else{
             if(role.equals("Student")){
                students[Student.studentCount-1]=new Student(name, pwd,department);
                Student.studentCount++;
                Student[] appendedStudents=new Student[Student.studentCount];
                appendedStudents=students;
                App.showmessage("Student appedned ready for log in and departemtn is "+department);
                LogInForm logInForm=new LogInForm(appendedStudents,teachers,admins,role);
             }
             if(role.equals("Teacher")){
                teachers[Teacher.teacherCount-1]=new Teacher(name, pwd,department);
                Teacher.teacherCount++;
                Teacher[] appendedTeachers=new Teacher[Teacher.teacherCount];
                appendedTeachers=teachers;
                App.showmessage("Teacher appedned ready for log in");
                LogInForm logInForm=new LogInForm(students,appendedTeachers,admins,role);
             }
             if(role.equals("Admin")){
                admins[Admin.adminCount-1]=new Admin(name, pwd);
                Admin.adminCount++;
                Admin[] appendedAdmins=new Admin[Admin.adminCount];
                appendedAdmins=admins;
                App.showmessage("Admin appedned ready for log in");
                LogInForm logInForm=new LogInForm(students,teachers,appendedAdmins,role);
               

             }

        }
        
         
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getSource().equals(App.departmentSelector)){
            department=App.departmentNames[App.departmentSelector.getSelectedIndex()];
            App.showmessage("you selected "+department);

        }
    }
}
