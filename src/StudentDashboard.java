import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class StudentDashboard implements ActionListener {
    private  Student student;
    private int enrolledCourseCount;
    private JButton studentReg,hostelTransportCon,courseEnroll;
    private static JButton confirmEnrollment;
    private JButton enrollSummary;
    private JButton feeDetail;
    private JButton courseFeedBack;
    private JButton resultCard;
    private JButton attendance;
    private JButton viewAttendance;
    private JButton admitSlip;
    private JButton policyForCheating;
    private JButton printChalan;
    private JButton financialAssistance;
    private JButton logOut;
    private static JPanel manuPanel,viewPanel,enrollmentPanel,viewAttendancePanel;
    private static JTextArea enrolledCourses;
    private static JTextArea attendanceTextArea;
    private static JFrame frm;
    private static JComboBox courseSelector,selectCourse;
    StudentDashboard(){}
    StudentDashboard(Student student){
        this.student=student;
        frm = new JFrame("Student Registration Portal");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(new Color(200, 200, 200));
        //Buttons.................................//
        studentReg=new JButton("Student Registration");
        hostelTransportCon=new JButton("Hostel Transport Confirm");
        courseEnroll=new JButton("Course Enroll");
        confirmEnrollment=new JButton("Confirm Course Enrollment");
        enrollSummary=new JButton("Enrollment Summary");
        feeDetail=new JButton("Complete Fee Details");
        courseFeedBack=new JButton("Course Feedback");
        resultCard=new JButton("View Result Card");
        attendance=new JButton("View Attendance");
        admitSlip=new JButton("Admit Slip");
        policyForCheating=new JButton("Policy For Cheating Cases");
        printChalan=new JButton("CISD Print Challan");
        financialAssistance=new JButton("Financial Assistance");
        logOut=new JButton("Log Out");
        App.styleBtn(studentReg);
        studentReg.addActionListener(e->{
        StudentRegistrationApp regApp=new StudentRegistrationApp(student);
        });
        App. styleBtn(hostelTransportCon); 
        App. styleBtn(courseEnroll);  courseEnroll.addActionListener(this);
        App. styleBtn(confirmEnrollment); confirmEnrollment.addActionListener(this);
        App. styleBtn(enrollSummary);enrollSummary.addActionListener(e->{
          createViewEnrolledCoursesPanel(student);
        });
        App. styleBtn(feeDetail);
        App. styleBtn(courseFeedBack);
        App. styleBtn(resultCard);
        App. styleBtn(attendance); attendance.addActionListener(this);
        App. styleBtn(admitSlip);
        App. styleBtn(policyForCheating);
        App. styleBtn(printChalan);
        App. styleBtn(financialAssistance);
        App. styleBtn(logOut);

      
       JLabel title=new JLabel("~Student Registration Portal");
       title.setBorder(BorderFactory.createLineBorder(App.bgColor));
       title.setFont(new Font("Arial", Font.BOLD, 40));
       title.setForeground(App.bgColor);
       title.setBackground(Color.white);

        manuPanel=new JPanel(new GridLayout(15, 2, 0, 7));
        manuPanel.setBorder(BorderFactory.createTitledBorder("Dashboard Panel"));
        viewPanel=new JPanel(); 
        viewPanel.setBorder(BorderFactory.createTitledBorder("View Panel"));
      //....................................................................///
       /* Student.initializeAvaiableCourses(); */
       courseSelector=new JComboBox<>(Student.availableCourses);
       App.styleCombo(courseSelector);
       selectCourse=new JComboBox<>(Student.availableCourses);
       App.styleCombo(selectCourse);
       selectCourse.addActionListener(this);
       
        //,,,,,,,,,,,,,,Course Enrollment Panel,,,,,,,,,,,,,,,,,,,,,//
        
          
        enrolledCourseCount=0;
        //........................View Attendance Panel.................................//
         JPanel optionsPanel = new JPanel();
         JPanel attendanceTextAreaPanel = new JPanel();
         viewAttendance = new JButton("View Attendance");
         App.styleBtn(viewAttendance);
         viewAttendance.addActionListener(this);

         attendanceTextArea = new JTextArea();
         attendanceTextArea.setFont(new Font("Javanese Text", Font.PLAIN, 20));

         JScrollPane scrollPane = new JScrollPane(attendanceTextArea);
         scrollPane.setPreferredSize(new Dimension(630, 570));
         scrollPane.setAutoscrolls(false);

         viewAttendance.setBackground(new Color(0, 0, 150));
         attendanceTextAreaPanel.setForeground(App.fgColor);

         // Use the scrollPane in attendanceTextAreaPanel
         attendanceTextAreaPanel.add(scrollPane);

         viewAttendancePanel = new JPanel(new BorderLayout());
         optionsPanel.add(courseSelector);  
         optionsPanel.add(viewAttendance);

         viewAttendancePanel.add(optionsPanel, BorderLayout.NORTH); 
         viewAttendancePanel.add(attendanceTextAreaPanel, BorderLayout.CENTER); 
        //  viewPanel.add(viewAttendancePanel);  
         

//................................................................................//

       
       manuPanel.add(studentReg);
       manuPanel.add(hostelTransportCon);
       manuPanel.add(courseEnroll); courseEnroll.addActionListener(this);
       manuPanel.add(enrollSummary);
       manuPanel.add(feeDetail);
       manuPanel.add(courseFeedBack);
       manuPanel.add(resultCard);
       manuPanel.add(attendance);
       manuPanel.add(admitSlip);
       manuPanel.add(policyForCheating);
       manuPanel.add(printChalan);printChalan.addActionListener(this);
       manuPanel.add(financialAssistance);
       manuPanel.add(logOut); logOut.addActionListener(this);
       
       //...................,
        Container pane=frm.getContentPane();
        pane.add(title,BorderLayout.NORTH);
        pane.add(manuPanel ,BorderLayout.WEST);
        pane.add(viewPanel,BorderLayout.CENTER);
        frm.setVisible(true);
        welcomePanel(student);
    }
    public  void  actionPerformed(ActionEvent e){
      if(e.getSource().equals(printChalan)){
            createChalanPanel(student);
      }
     if(e.getSource().equals(courseEnroll)){
      createViewEnrollCourses(student);

     }
     if(e.getSource().equals(confirmEnrollment)){
        if(enrolledCourseCount==Student.availableCourses.length-1){
          App.showmessage("You Cann't Enroll More courses!");
          confirmEnrollment.removeActionListener(this);
          enrollmentPanel.setBorder(BorderFactory.createTitledBorder("Enrollment Completed"));
          confirmEnrollment.setText("Enrollment successfull!");
        } else{
          if(!(selectCourse.getSelectedIndex()==0)){
            student.courses[enrolledCourseCount]=Student.availableCourses[selectCourse.getSelectedIndex()];
            App.showmessage("Mr."+student.userName+"Successfully enrolled Course"+student.courses[enrolledCourseCount].courseName);
           enrolledCourses.append("  "+(enrolledCourseCount+1)+".   "+student.courses[enrolledCourseCount].courseName+" Enrolled Succefully"+"\n");
          
           enrolledCourseCount++;
          }
          else {App.showmessage("Please Select Course");}
          
        }   

     }
     if(e.getSource().equals(attendance)){
      viewPanel.removeAll();
      viewPanel.add(viewAttendancePanel);
      viewPanel.revalidate();
      viewPanel.repaint();
     }
     if(e.getSource().equals(viewAttendance)){
      App.showmessage("Your Selected Course is "+student.courses[courseSelector.getSelectedIndex()-1].courseName);
      createUpdateAttendancePanel(student); 
     }
     if(e.getSource().equals(logOut)){
       frm.setVisible(false);
       App app=new App(App.students,App.admins,App.teachers);
     }
    }
    public static void createUpdateAttendancePanel(Student student){
      viewPanel.removeAll();
      Course tempCourse=student.courses[courseSelector.getSelectedIndex()-1];
         String temp=" "; 
         attendanceTextArea.setText(" ");
         attendanceTextArea.append("  Date                             "+"Course          "+"Attendance        "  + "\n");
         student.fillAttendanceRecord();
        for(int i=0;i<tempCourse.courseAttendanceArray.length;i++){
        temp=" " +tempCourse.courseAttendanceArray[i][0]+"      " +
            tempCourse.courseAttendanceArray[i][1]+"                 " + 
            tempCourse.courseAttendanceArray[i][2];
            attendanceTextArea.append(temp);
            attendanceTextArea.append("\n");
         
        }
        /* This line is to stop autoscrolling */
        SwingUtilities.invokeLater(() -> attendanceTextArea.setCaretPosition(0));
        viewPanel.add(viewAttendancePanel);
        viewPanel.revalidate();
    }
    public static void createViewEnrollCourses(Student student){
      JPanel upperEnrollmentPanel=new JPanel();
        JPanel lowerEnrollmPanel=new JPanel();
        enrolledCourses=new JTextArea();
        enrolledCourses.setPreferredSize(new Dimension(630, 200));
      
        
        enrollmentPanel=new JPanel(new BorderLayout());
        upperEnrollmentPanel.add(selectCourse);
        upperEnrollmentPanel.add(confirmEnrollment);
        lowerEnrollmPanel.add(enrolledCourses);
        enrollmentPanel.add(upperEnrollmentPanel,BorderLayout.NORTH);
        enrollmentPanel.add(lowerEnrollmPanel,BorderLayout.CENTER);
        viewPanel.removeAll();
        viewPanel.add(enrollmentPanel, BorderLayout.CENTER);
        viewPanel.revalidate();
        viewPanel.repaint();

    }
    public static void createViewEnrolledCoursesPanel(Student student) {
      // Create panel to hold the course information
      JPanel enrolledCoursesPanel = new JPanel(new GridBagLayout());
      enrolledCoursesPanel.setBorder(BorderFactory.createTitledBorder("Enrolled Courses"));

      // Initialize GridBagConstraints for layout
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(10, 10, 10, 10);

      // Add label for the student name
      JLabel studentLabel = new JLabel("Student: " + student.userName);
      studentLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 2;
      gbc.anchor = GridBagConstraints.WEST;
      enrolledCoursesPanel.add(studentLabel, gbc);

      // Reset gridwidth for course details
      gbc.gridwidth = 1;
      int row = 1;

      // Add course details
      for (Course course : student.courses) {
          // Display Course Name
          JLabel courseNameLabel = new JLabel("Course Name: " + course.courseName);
          courseNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Font size
          gbc.gridx = 0;
          gbc.gridy = row;
          gbc.anchor = GridBagConstraints.WEST;
          enrolledCoursesPanel.add(courseNameLabel, gbc);/* 

          // Display Course Code
          JLabel courseCodeLabel = new JLabel("Course Code: " + course.courseCode);
          courseCodeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Font size
          gbc.gridx = 1;
          gbc.gridy = row;
          gbc.anchor = GridBagConstraints.WEST;
          enrolledCoursesPanel.add(courseCodeLabel, gbc); */

          // Increment row for the next course details
          row++;

          // Display Instructor Name
          /* JLabel instructorNameLabel = new JLabel("Instructor: " + course.instructorName);
          instructorNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Font size
          gbc.gridx = 0;
          gbc.gridy = row;
          gbc.gridwidth = 2; // Span across two columns
          enrolledCoursesPanel.add(instructorNameLabel, gbc);
 */
          // Increment row for the next course
          row++;

          // Add a separator between courses
          JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
          separator.setPreferredSize(new Dimension(600, 10));
          gbc.gridx = 0;
          gbc.gridy = row;
          gbc.gridwidth = 2; // Span across two columns
          enrolledCoursesPanel.add(separator, gbc);

          // Increment row for the next entry after the separator
          row++;
      }

      // Add the enrolledCoursesPanel to the main viewPanel
      viewPanel.removeAll();
      viewPanel.add(enrolledCoursesPanel, BorderLayout.CENTER);
      viewPanel.revalidate();
      viewPanel.repaint();
  }
    public static void createChalanPanel(Student student) {
    viewPanel.removeAll();

    // Create a text area to display the sample chalan
    JTextArea chalanTextArea = new JTextArea();
    chalanTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Set font to monospaced for better alignment

    String chalanText = String.format(
            "                        Sample Bank Chalan\n\n" +
            "Bank:                  Sample Bank Ltd.\n" +
            "Account No:            1234567890\n" +
            "Branch Code:           00123\n" +
            "---------------------------------------------------------\n" +
            "Student Name:          %s\n" +
            "Semester:              %d\n" +
            "Amount Due:            PKR %,.2f\n" +
            "Due Date:              %s\n" +
            "---------------------------------------------------------\n\n" +
            "Please make the payment before the due date.\n" +
            "Failure to do so may result in late fee charges.\n",
            student.userName, 1, 103000.00, "14 September 2023"
    );

    chalanTextArea.setText(chalanText);
    chalanTextArea.setEditable(false);
    chalanTextArea.setCaretPosition(0);

    // Create a confirm button
    JButton confirmButton = new JButton("Confirm Payment");
    App.styleBtn(confirmButton); // Assuming App.styleBtn applies some styling

    // Add action listener to the button
    confirmButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to confirm the payment?",
                    "Confirm Payment",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                student.paidDues = true;
                JOptionPane.showMessageDialog(null, "Payment Confirmed", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });

    // Create a panel to hold the text area and the button
    JPanel chalanPanel = new JPanel(new BorderLayout(10, 10));
    chalanPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
    chalanPanel.add(new JScrollPane(chalanTextArea), BorderLayout.CENTER);
    chalanPanel.add(confirmButton, BorderLayout.SOUTH);

    // Add the chalan panel to the view panel and refresh the view
    viewPanel.add(chalanPanel);
    viewPanel.revalidate();
    viewPanel.repaint();
}
    public static void welcomePanel(Student student) {
            viewPanel.removeAll();

            JLabel headerLabel = new JLabel("Welcome to Student Registration Portal", JLabel.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 26));
            headerLabel.setForeground(new Color(70, 130, 180)); // Steel blue color for the header

            JPanel infoPanel = new JPanel(new GridLayout(0, 1, 10, 10));
            infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding around the panel

            JLabel nameLabel = new JLabel("Student Name: " + student.userName);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            nameLabel.setForeground(new Color(25, 25, 112)); // Midnight blue color for text

            JLabel batchLabel = new JLabel("Batch: " + student.batch);
            batchLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            batchLabel.setForeground(new Color(25, 25, 112));

            JLabel departmentLabel = new JLabel("Department: " + student.degProgram);
            departmentLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            departmentLabel.setForeground(new Color(25, 25, 112));

            infoPanel.add(nameLabel);
            infoPanel.add(batchLabel);
            infoPanel.add(departmentLabel);

            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 3)); // Border with steel blue color
            mainPanel.setBackground(new Color(240, 248, 255)); // Light blue background
            mainPanel.add(headerLabel, BorderLayout.NORTH);
            mainPanel.add(infoPanel, BorderLayout.CENTER);

            viewPanel.add(mainPanel);
            viewPanel.revalidate();
            viewPanel.repaint();
}
    

/*     public static void main(String[] args) {
      Student s=new Student("a", "123", "cis", "2023", "afai", "0454");
       StudentDashboard sb=new StudentDashboard(s);
      
    }  */
   
 
}