import javax.imageio.spi.RegisterableService;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LogInForm implements ActionListener {
    private Student[] students;
    private Teacher[] teachers;
    private Admin[] admins;
    private String role;
   JLabel nameL,pwdL;
   JTextField nameTF,pwdTF;
   JButton logInButton,departmentBtn;
   JComboBox departmentsComboBoc;
  public static JFrame loginFrame;


    LogInForm(){}

    LogInForm(Student[] students,Teacher[] teachers,Admin[] admins,String role){
        this.students=students;
        this.teachers=teachers;
        this.admins=admins;
        this.role=role;
        GridBagConstraints gbc=new GridBagConstraints();
        GridBagConstraints Gbc=new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 20); 
         loginFrame = new JFrame("Log In Page");
        loginFrame.setSize(App.width, App.height);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        JPanel panel=new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Log In yourself here!"));
         nameL=new JLabel("Enter Your Name : ");nameL.setFont(App.boldFont);
         pwdL=new JLabel("Enter your Passowrd: ");pwdL.setFont(App.boldFont);
         nameTF=new JTextField(20);nameTF.setFont(App.boldFont);
         pwdTF=new JTextField(20);pwdTF.setFont(App.boldFont);pwdTF.setToolTipText("Password must contain 8 character!");
         logInButton=new JButton("Log In");
         logInButton.setForeground(App.fgColor); logInButton.setBackground(Color.BLACK);
         logInButton.setFont(App.boldFont);
         logInButton.addActionListener(this);
        gbc.gridy=1;
        panel.add(nameL,gbc);
        gbc.gridy=2;
        panel.add(nameTF,gbc);
        gbc.gridy=3;
        panel.add(pwdL,gbc);
        gbc.gridy=4;
        panel.add(pwdTF,gbc);
        if(!(role.equals("Admin"))){
            gbc.gridy=5;
            panel.add(App.departmentSelector);
         }
        
         JPanel regJPanel=new JPanel();
         regJPanel.add(logInButton);
        JPanel container=new JPanel(new GridBagLayout());
        container.setBorder(BorderFactory.createTitledBorder("LogIn Panel"));
        Gbc.gridx=0;
        Gbc.gridy=0;
        container.add(panel,Gbc);
        gbc.gridy=6;
        container.add(regJPanel,gbc);
        loginFrame.add(container,BorderLayout.CENTER);

    }
    public void  actionPerformed(ActionEvent e){
        if(students.equals(null)&&admins.equals(null)&&teachers.equals(null)){
            App.showmessage("Register yourself first please Going to Main window");
            loginFrame.setVisible(false); }
             else {
                if(role.equals("Student")){
                    validateStudent();
                }
                else if(role.equals("Teacher")){
                    validateTeacher();
                } 
                else if(role.equals("Admin")){
                    validateAdmin();
                }
            }
            
        }
       
        
    
    public void validateStudent(){
        for(int i=0;i<students.length;i++){
                if(!(students[i].userName.equals(nameTF.getText()))){
                    JOptionPane.showMessageDialog(null, "Student Not Found.Enter Vald Name", null, i);
                }
                else {
                    App.showmessage(" Student Found");
                    if(!(students[i].userPassword.equals(pwdTF.getText()))){
                           JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Log In sucessful!", null, JOptionPane.INFORMATION_MESSAGE);
                        App.showmessage("Showing student dashboard");
                         StudentDashboard studentDashboard=new StudentDashboard(students[i]);
                    }
                }
        }
    }
    public void validateTeacher(){
        for(int i=0;i<teachers.length;i++){
                if(!(teachers[i].userName.equals(nameTF.getText()))){
                    JOptionPane.showMessageDialog(null, "Teacher Not Found.Enter Vald Name", null, i);
                }
                else {
                    App.showmessage(" Teacher Found");
                    if(!(teachers[i].userPassword.equals(pwdTF.getText()))){
                           JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Log In sucessful!", null, JOptionPane.INFORMATION_MESSAGE);
                        App.showmessage("Teacher dashboard");
                        //TeacherDashboard teacherDashboard=new TeacherDashboard(teachers[i]);
                    }
                }
        }
    }
    public void validateAdmin(){
        for(int i=0;i<admins.length;i++){
                if(!(admins[i].userName.equals(nameTF.getText()))){
                    JOptionPane.showMessageDialog(null, "Admin Not Found.Enter Vald Name", null, i);
                }
                else {
                    App.showmessage(" Admin Found");
                    if(!(admins[i].userPassword.equals(pwdTF.getText()))){
                           JOptionPane.showMessageDialog(null, "Enter Valid Password", null, JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Log In sucessful!", null, JOptionPane.INFORMATION_MESSAGE);
                        App.showmessage("Adming dashboard");
                        AdminDashboard adminDashboard=new AdminDashboard(admins[i]);
                    }
                }
        }
    }
}
