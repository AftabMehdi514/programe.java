import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class App implements ActionListener {
    LogInForm logInForm;
    SignUp signUp;
    public static boolean logInKey=false;
    static  ArrayList<Student> students;
    static ArrayList<Admin> admins;
    static ArrayList<Teacher> teachers;

    public static String[] departmentNames={"Select your Depatment","CIS","PHYSICS"}, batch={"Select Batch","23-27","24-28"},availablecourses={"Select Course","OOP","DM","sampleCourse"};
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
        public static void styleBtn(JButton btn){
            btn.setForeground(fgColor);
            btn.setBackground(bgColor);
            btn.setFont(btnFont);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setContentAreaFilled(false);
            btn.setOpaque(true);
    
            // Adding hover effect
            btn.addMouseListener(new MouseAdapter() {
        
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(bgColor.darker());
                }
    
                
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(bgColor);
                }
            });
    
            // Adding click animation
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Timer timer = new Timer(20, null);
                    timer.addActionListener(new ActionListener() {
                        private float alpha = 1.0f;
                        private boolean fadingOut = true;
    
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (fadingOut) {
                                alpha -= 0.1f;
                                if (alpha <= 0.5f) {
                                    fadingOut = false;
                                }
                            } else {
                                alpha += 0.1f;
                                if (alpha >= 1.0f) {
                                    timer.stop();
                                }
                            }
                            btn.setBackground(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), (int) (alpha * 255)));
                        }
                    });
                    timer.start();
                }
            });
    
        }
        public static void clickedStyleBtn(JButton btn){
            btn.setForeground(Color.yellow);
            btn.setBackground(new Color(0,150,0));
        }
        public static void clickedStyleBtn2(JButton btn){
            btn.setForeground(Color.yellow);
            btn.setBackground(new Color(150,0,0));
        }
        public static void btnStyleBtn3(JButton btn){
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(00,0,150));
            btn.setFont(new Font("Arial", Font.BOLD, 14));
        }
        public static void styleCombo(JComboBox c){
            c.setBackground(Color.WHITE);
            c.setPreferredSize(new Dimension(400, 30)); 
        }
    private JButton btnAdmin,btnTeacher,btnStudent;
    private String  role;
    public static Dimension buttonSize,panelSize;
    public static GridBagConstraints gbc,containerGbc;
    public static JFrame frm;
    public static JPanel panel,askPanel,container;
    
    public static JButton signInBtn,signUpBtn,back;
    public static void askUserLogInOrSignUp(){
       

    }
    App(ArrayList<Student> students, ArrayList<Admin> admins, ArrayList<Teacher> teachers) {
        this.students = students;
        this.admins = admins;
        this.teachers = teachers;
    
    
       frm = new JFrame("Student Registration Portal");
       frm.setSize(900, 550);
       frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frm.getContentPane().setBackground(new Color(200, 200, 200)); 
     
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
      // App.clickedStyleBtn2(btnAdmin);
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
          askPanel.setVisible(false);
            logInForm=new LogInForm(students,teachers,admins,role);
       }
       else if(e.getSource().equals(signUpBtn)){
        App.showmessage("already the length is "+students.size());
        System.out.println("Sign up clicked new the array lenght is"+students.size());
        showmessage("You are singing UP as a "+role+"!");
        signUp=new SignUp(students,teachers,admins,role);
       
       }
    }
 
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students =new ArrayList<Student>();
        Student student=new Student("sampleStudent", "abc", "CIS", "2024","email@gmail.com","511123");
        student.sampleCourses();
        students.add(student);
        students.add(new Student("Ali Khan", "ali123", "CIS", "2023", "ali.khan@example.com", "9876543210"));
        students.add(new Student("Sana Ahmed", "sana456", "CIS", "2022", "sana.ahmed@example.com", "5555555555"));
        students.add(new Student("Usman Malik", "usman789", "CIS", "2023", "usman.malik@example.com", "1112223333"));
        students.add(new Student("Ayesha Rahman", "ayeshaABC", "CIS", "2022", "ayesha.rahman@example.com", "9998887777"));
        students.add(new Student("Fatima Zaman", "fatimaDEF", "CIS", "2024", "fatima.zaman@example.com", "6667778888"));
     

        Teacher t=new Teacher("", "a");
        ArrayList<Admin> admins=new ArrayList<Admin>();
        Admin ad=new Admin("admin", "abc");
         admins.add(ad);
        ArrayList<Teacher>teachers=new ArrayList<Teacher>();
        teachers.add(new Teacher("Numan", "numan@gmail.com", "420", "CIS", "abc") );
        teachers.add(new Teacher("sampleTeacher", "sampleteacher@example.com", "1234567890", "Mathematics", "password1"));
        teachers.add(new Teacher("Teacher 2", "teacher2@example.com", "9876543210", "Physics", "password2"));
        teachers.add(new Teacher("Teacher 3", "teacher3@example.com", "5555555555", "Computer Science", "password3"));
        teachers.add(new Teacher("Teacher 4", "teacher4@example.com", "1112223333", "History", "password4"));
        teachers.add(new Teacher("Teacher 5", "teacher5@example.com", "9998887777", "Biology", "password5"));
        App app = new App(students,admins,teachers);
    }
    
}
