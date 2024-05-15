import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.TableView.TableCell;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class App implements ActionListener {
    LogInForm logInForm;
    SignUp signUp;
    private  Student[] students;
    private Admin[] admins;
    private Teacher[] teachers;
    public static String[] departmentNames={"Select your Depatment","CIS","PHYSICS"}, batch={"Select Batch","23-27","24-28"},courses={"Select Course","OOP","DM"};
    public static JComboBox departmentSelector,batchSelector,courseSelector;
    //Some Utilites
    public static Color bgColor=new Color(30,145,255);
    public static Color fgColor=new Color(255,255,255);
    public static Font boldFont=new Font("Arial", Font.BOLD, 18);
    public static Font btnFont=new Font("Courier", Font.BOLD, 14);
    public static int width=1500;
    public static int height=720;
    public static void showmessage(String n){
    JOptionPane.showMessageDialog(null, n, n, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showmessage(String n,String m){
        JOptionPane.showMessageDialog(null, n+m, n, JOptionPane.INFORMATION_MESSAGE);
        }
        public static void styleBtn(JButton btn){
            btn.setForeground(App.fgColor);
            btn.setBackground(App.bgColor);
            btn.setFont(App.btnFont);
        }
       
    //PrivateComponets of Class
    private JButton btnAdmin,btnTeacher,btnStudent;
    private String  role;
    public static Dimension buttonSize,panelSize;
    public static GridBagConstraints gbc,containerGbc;
    //creating a Universal Frame
    public static JFrame frm;
    public static JPanel panel,askPanel,container;
    
    public static JButton signInBtn,signUpBtn,back;
    public static void askUserLogInOrSignUp(){
       

    }
    App(Student[] students,Admin[] admins,Teacher[] teachers){
        this.students=students;
        this.admins=admins;
        this.teachers=teachers;
        frm = new JFrame("Student Registration Portal");
       frm.setSize(900, 550);
       frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frm.getContentPane().setBackground(new Color(200, 200, 200)); // Set background color for the frame
       /* ComboBoxes */
       departmentSelector=new JComboBox<>(App.departmentNames);
       departmentSelector.setMaximumRowCount(7);
       departmentSelector.setName("Select Department");
       departmentSelector.setPreferredSize(new Dimension(400, 50));
       departmentSelector.setAutoscrolls(true);
      

      
       //departmentSelector.setFocusable(false);
       departmentSelector.setBorder(BorderFactory.createTitledBorder("Select Your Department"));
       
        btnAdmin = new JButton("Admin");
        btnTeacher = new JButton("Teacher");
        btnStudent = new JButton("Student");
   // Set text color to white and background color to blue for buttons
       Color textColor = Color.WHITE;
       Color bgColor = new Color(30, 144, 255); 
       btnAdmin.setForeground(textColor);
       btnAdmin.setBackground(bgColor);
       btnTeacher.setForeground(textColor);
       btnTeacher.setBackground(bgColor);
       btnStudent.setForeground(textColor);
       btnStudent.setBackground(bgColor);

       // Increase button size
        buttonSize = new Dimension(150, 50);
        panelSize=new Dimension(400, 400);
       btnAdmin.setPreferredSize(buttonSize);
       btnTeacher.setPreferredSize(buttonSize);
       btnStudent.setPreferredSize(buttonSize);
       btnAdmin.setFont(App.boldFont);
       btnTeacher.setFont(App.boldFont);
       btnStudent.setFont(App.boldFont);
       //Assigning actions
       btnAdmin.addActionListener(this);
       btnStudent.addActionListener(this);
       btnTeacher.addActionListener(this);
        panel = new JPanel(new GridBagLayout());
       panel.setPreferredSize(panelSize);
       panel.setBorder(BorderFactory.createTitledBorder("Select Your Role"));
       
        gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10); // Add insets for padding


       // Add Admin button
       gbc.gridy = 1;
       panel.add(btnAdmin, gbc);

       // Add Teacher button
       gbc.gridy = 2;
       panel.add(btnTeacher, gbc);

       // Add Students button
       gbc.gridy = 3;
       panel.add(btnStudent, gbc);

       // Center the panel containing buttons
        container = new JPanel(new GridBagLayout());
       containerGbc = new GridBagConstraints();
       containerGbc.gridx = 0;
       containerGbc.gridy = 0;
       container.add(panel, containerGbc);

       // Center the container panel within the frame
       frm.add(container, BorderLayout.CENTER);

       // Center the JFrame on the screen
       frm.setLocationRelativeTo(null);
       //...........................code for ask panel/////////////////////////
       signInBtn = new JButton("Sign In");
       signInBtn.setForeground(fgColor);
       signInBtn.setBackground(bgColor);
       signInBtn.setFont(boldFont);
       signInBtn.setPreferredSize(buttonSize);
       signUpBtn = new JButton("");
       signUpBtn.setForeground(fgColor);
       signUpBtn.setBackground(bgColor);
       signUpBtn.setFont(boldFont);
       signUpBtn.setPreferredSize(buttonSize);
       signInBtn.addActionListener(this);
       signUpBtn.addActionListener(this);
       askPanel=new JPanel(new GridBagLayout());
       askPanel.setPreferredSize(App.panelSize);
       askPanel.setBorder(BorderFactory.createTitledBorder("What you want to do?"));
       gbc.gridy=1;
       askPanel.add(signInBtn,gbc);
       gbc.gridy=2;
       askPanel.add(signUpBtn,gbc);
       //GoBack
        back=new JButton("Go Back");
       back.setFont(boldFont);
       back.setForeground(fgColor);
       back.setBackground(bgColor);
       back.setPreferredSize(buttonSize);
       back.addActionListener(this);
       
       gbc.gridy=3;
       askPanel.add(back,gbc);
       //container.add(askPanel);
       askPanel.setVisible(true);
       //.....................................................................
       //......................LogIn Page...........................//

       //............................................................
       
       frm.setVisible(true);
    }
    public  void  actionPerformed(ActionEvent e){
       if(e.getSource().equals(btnAdmin)){
        role="Admin";signUpBtn.setText("New Admin");
        panel.setVisible(false);
        container.add(askPanel);
        askPanel.setVisible(true);
        App.askUserLogInOrSignUp();
       
       }
       else if(e.getSource().equals(btnTeacher)){
              role="Teacher"; signUpBtn.setText("New Teacher");
               panel.setVisible(false);
               container.add(askPanel);
               askPanel.setVisible(true);
       }
       else if(e.getSource().equals(btnStudent)) {
             role="Student"; signUpBtn.setText("New Student");
             panel.setVisible(false);
             container.add(askPanel);
             askPanel.setVisible(true);
               
       }
       else if(e.getSource().equals(back)){
               askPanel.setVisible(false);
               container.add(panel);
               panel.setVisible(true);
       }
       else if(e.getSource().equals(signInBtn)){
          showmessage("Your Logging In as a "+role+"!");
            logInForm=new LogInForm(students,teachers,admins,role);
       }
       else if(e.getSource().equals(signUpBtn)){
        showmessage("You are singing UP as a "+role+"!");
            signUp=new SignUp(students,teachers,admins,role);
       
       }
    }
   /*  class askPanelHandler implements ActionListener{
           public void actionPerformed(ActionEvent e){
            if(e.getSource().)
           }
    } */
 
    public static void main(String[] args) throws Exception {
       
        Student.studentCount=1;Admin.adminCount=1;Teacher.teacherCount=1;
        Student[] students = new Student[Student.studentCount];
        Admin[] admins=new Admin[Admin.adminCount];
        Teacher[] teachers=new Teacher[Teacher.teacherCount];
        App app = new App(students,admins,teachers);
    }
    
}
