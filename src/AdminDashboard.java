import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class AdminDashboard {
      private  ArrayList<Teacher>teachers;
      private  ArrayList<Student>students;
      private Admin admin;
      private JFrame frm;
      private static JPanel viewPanel,optionPanel,container,panel;
      private JButton addTeacher,approveExamSlip,viewStudents,viewTeachers,assignCourses,logOut;
      private String[] availableCourses;

   // AdminDashboard(){}
    AdminDashboard(Admin admin,ArrayList<Student>students,ArrayList<Teacher>teachers,String[] c){
        this.students=students;
        this.teachers=teachers;
        this.admin=admin;
        this.availableCourses=c;
         frm = new JFrame("Admin DashBoard");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        
        /* Panels */
        panel=new JPanel(new GridBagLayout());
       viewPanel = new JPanel(new BorderLayout());
            viewPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel label = new JLabel("Admin Panel View");
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setHorizontalAlignment(JLabel.CENTER);

            viewPanel.add(label, BorderLayout.CENTER);

            viewPanel.setBackground(new Color(255, 255, 255));
            viewPanel.setForeground(new Color(0, 0, 0));

            viewPanel.setBorder(BorderFactory.createLineBorder(App.bgColor, 2));
        optionPanel=new JPanel();
        optionPanel.setBackground(Color.white);
        optionPanel.setForeground(Color.black);
        addTeacher = new JButton("Add Teacher");
        App.styleBtn(addTeacher);
        addTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            createAddTeacherPanel(teachers); 
            }
        });
        
        viewStudents = new JButton("View Students");
        App.styleBtn(viewStudents);
        viewStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createViewStudentsPanel(students);
            }
        });
        
        viewTeachers = new JButton("View Teachers");
        App.styleBtn(viewTeachers);
        viewTeachers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createViewTeachersPanel(teachers);
            }
        });
        
        assignCourses = new JButton("Assign Courses");
        App.styleBtn(assignCourses);
        assignCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAssignCoursePanel(teachers, availableCourses);
            }
        });
        
        approveExamSlip = new JButton("Approve Exam Slip");
        App.styleBtn(approveExamSlip);
        approveExamSlip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createApproveExamSlipPanel(students);
            }
        });
        
        logOut=new JButton("Log out");
        App.styleBtn(logOut); logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               frm.dispose();
               App app=new App(App.students, App.admins, App.teachers);
            }
        }); 
        optionPanel.add(addTeacher);
        optionPanel.add(viewTeachers);
        optionPanel.add(viewStudents);
        optionPanel.add(assignCourses);
        optionPanel.add(approveExamSlip);
        optionPanel.add(logOut);
        /* ........................................................................... */
        
        GridBagConstraints Gbc=new GridBagConstraints();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(2   , 10, 10, 10);
        gbc.gridy=1;
        panel.add(optionPanel,gbc);
        gbc.gridy=2;
        panel.add(viewPanel,gbc);
        viewPanel.setPreferredSize(new Dimension(1180, 620));
        container=new JPanel(new GridBagLayout());
        Gbc.gridx=0;
        Gbc.gridy=0;

        container.add(panel,Gbc);
        frm.add(container,BorderLayout.NORTH);
        
    };
    public static void createAssignCoursePanel(ArrayList<Teacher> teachers, String[] availableCourses) {
        // Create panel to hold the assignment components
        JPanel assignCoursePanel = new JPanel(new GridBagLayout());
        assignCoursePanel.setBorder(BorderFactory.createTitledBorder("Assign Course"));
    
        // Initialize GridBagConstraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Increase padding for larger components
    
        // Add label for selecting teacher
        JLabel teacherLabel = new JLabel("Select Teacher:");
        teacherLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        assignCoursePanel.add(teacherLabel, gbc);
    
        // Create ComboBox for selecting teacher
        JComboBox<String> teacherComboBox = new JComboBox<>();
        for (Teacher teacher : teachers) {
            teacherComboBox.addItem(teacher.userName);
        }
        teacherComboBox.setPreferredSize(new Dimension(300, 30)); // Larger size
        teacherComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger font size
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        assignCoursePanel.add(teacherComboBox, gbc);
    
        // Add label for selecting course
        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        assignCoursePanel.add(courseLabel, gbc);
    
        // Create ComboBox for selecting course
        JComboBox<String> courseComboBox = new JComboBox<>(App.availablecourses);
        courseComboBox.setPreferredSize(new Dimension(300, 30)); // Larger size
        courseComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger font size
        App.courseSelector = courseComboBox; // Assuming App.courseSelector is declared somewhere
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        assignCoursePanel.add(courseComboBox, gbc);
    
        // Create button to assign course
        JButton assignButton = new JButton("Assign Course");
        App.styleBtn(assignButton); // Style button using the method from App class
        assignButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font size
        assignButton.setPreferredSize(new Dimension(200, 40)); // Larger size
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected teacher index
                int teacherIndex = teacherComboBox.getSelectedIndex();
                if (teacherIndex >= 0 && teacherIndex < teachers.size()) {
                    // Get selected course index
                    int courseIndex = courseComboBox.getSelectedIndex();
                    if (courseIndex >= 0 && courseIndex < availableCourses.length) {
                        // Assign course to selected teacher
                        Teacher teacher = teachers.get(teacherIndex);
                        // teacher.addCourse(availableCourses[courseIndex]); // Assuming method exists
                        // Show message indicating successful assignment
                        JOptionPane.showMessageDialog(null, "Course assigned to teacher successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a course!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a teacher!");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        assignCoursePanel.add(assignButton, gbc);
    
        // Add the assignment panel to the viewPanel
        viewPanel.removeAll();
        viewPanel.add(assignCoursePanel, BorderLayout.CENTER);
        viewPanel.revalidate();
    }
    
    public static void createApproveExamSlipPanel(ArrayList<Student> students) {
        // Create panel to hold the components for approving exam slips
        JPanel approveExamSlipPanel = new JPanel(new GridBagLayout());
        approveExamSlipPanel.setBorder(BorderFactory.createTitledBorder("Approve Exam Slip"));
    
        // Initialize GridBagConstraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Increased padding for larger components
    
        // Add label for selecting student
        JLabel studentLabel = new JLabel("Select Student:");
        studentLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        approveExamSlipPanel.add(studentLabel, gbc);
    
        // Create ComboBox for selecting student
        JComboBox<String> studentComboBox = new JComboBox<>();
        for (Student student : students) {
            studentComboBox.addItem(student.userName);
        }
        studentComboBox.setPreferredSize(new Dimension(300, 30)); // Larger size
        studentComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger font size
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        approveExamSlipPanel.add(studentComboBox, gbc);
    
        // Create button to approve exam slip
        JButton approveButton = new JButton("Approve Exam Slip");
        App.styleBtn(approveButton); // Style button using the method from App class
        approveButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font size
        approveButton.setPreferredSize(new Dimension(200, 40)); // Larger size
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected student index
                int studentIndex = studentComboBox.getSelectedIndex();
                if (studentIndex >= 0 && studentIndex < students.size()) {
                    Student selectedStudent = students.get(studentIndex);
                    selectedStudent.paidDues = true;
                    JOptionPane.showMessageDialog(null, "Exam slip approved successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student!");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        approveExamSlipPanel.add(approveButton, gbc);
    
        // Add the approveExamSlipPanel to the viewPanel
        viewPanel.removeAll();
        viewPanel.add(approveExamSlipPanel, BorderLayout.CENTER);
        viewPanel.revalidate();
        viewPanel.repaint();
    }
    


public static void createViewTeachersPanel(ArrayList<Teacher> teachers) {
 GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    JPanel viewTeachersPanel = new JPanel(new GridBagLayout());
    viewTeachersPanel.setBorder(BorderFactory.createTitledBorder("View Teachers"));

    // Display the total number of teachers at the top
    JLabel totalLabel = new JLabel("Total Registered Teachers: " + teachers.size());
   // totalLabel.setFont(App.boldFont);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 5; // Span across all columns
    viewTeachersPanel.add(totalLabel, gbc);

    // Reset gridwidth and move to the next row
    gbc.gridwidth = 1;
    int row = 1;
    int teacherNumber = 1;
    viewTeachersPanel.setBackground(Color.white);

    for (Teacher teacher : teachers) {
        // Display Teacher Number
        JLabel numberLabel = new JLabel("Teacher " + teacherNumber + ": ");
        numberLabel.setPreferredSize(new Dimension(100, 30));
       // numberLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = row;
        viewTeachersPanel.add(numberLabel, gbc);

        // Display Teacher Name
        JLabel nameLabel = new JLabel("Name: " + teacher.userName);
        nameLabel.setPreferredSize(new Dimension(200, 30));
       // nameLabel.setFont(App.boldFont);
        gbc.gridx = 1;
        gbc.gridy = row;
        viewTeachersPanel.add(nameLabel, gbc);

        // Display Teacher Email
        JLabel emailLabel = new JLabel("Email: " + teacher.email);
        emailLabel.setPreferredSize(new Dimension(200, 30));
       // emailLabel.setFont(App.boldFont);
        gbc.gridx = 2;
        gbc.gridy = row;
        viewTeachersPanel.add(emailLabel, gbc);

        // Display Teacher Contact Number
        JLabel contactLabel = new JLabel("Contact Number: " + teacher.contactNo);
        contactLabel.setPreferredSize(new Dimension(200, 30));
       // contactLabel.setFont(App.boldFont);
        gbc.gridx = 3;
        gbc.gridy = row;
        viewTeachersPanel.add(contactLabel, gbc);

        // Display Teacher Department
        JLabel deptLabel = new JLabel("Department: " + teacher.department);
        deptLabel.setPreferredSize(new Dimension(200, 30));
       // deptLabel.setFont(App.boldFont);
        gbc.gridx = 4;
        gbc.gridy = row;
        viewTeachersPanel.add(deptLabel, gbc);

        // Increment row for the next teacher's information
        row++;

        // Add a separator row for clarity
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1000, 10));
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 5; // Span the separator across all columns
        viewTeachersPanel.add(separator, gbc);

        // Reset gridwidth back to 1 for the next row's content
        gbc.gridwidth = 1;

        // Increment row for the next content after the separator
        row++;
        teacherNumber++;
    }

    JPanel container = new JPanel(new GridBagLayout());
    GridBagConstraints gbcContainer = new GridBagConstraints();
    gbcContainer.gridx = 0;
    gbcContainer.gridy = 0;
    viewTeachersPanel.setPreferredSize(new Dimension(1100, 700));
    container.add(viewTeachersPanel, gbcContainer);
    container.setBorder(BorderFactory.createTitledBorder("View Teachers Panel"));

    viewPanel.removeAll();
    viewPanel.add(container, BorderLayout.CENTER);
    viewPanel.revalidate();
}



    
    
public static void createViewStudentsPanel(ArrayList<Student> students) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    JPanel viewStudentsPanel = new JPanel(new GridBagLayout());
    viewStudentsPanel.setBorder(BorderFactory.createTitledBorder("View Students"));

    // Display the total number of students at the top
    JLabel totalLabel = new JLabel("Total Number of Students: " + students.size());
    totalLabel.setFont(App.boldFont);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 8; // Span across all columns
    viewStudentsPanel.add(totalLabel, gbc);

    // Reset gridwidth and move to the next row
    gbc.gridwidth = 1;
    int row = 1;
    int studentNumber = 1;

    for (Student student : students) {
        // Display Student Number
        JLabel numberLabel = new JLabel("Student " + studentNumber + ": ");
        numberLabel.setPreferredSize(new Dimension(100, 30));
       // numberLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = row;
        viewStudentsPanel.add(numberLabel, gbc);
        // Display Student Name
        JLabel nameLabel = new JLabel("Name: " + student.userName);
        nameLabel.setPreferredSize(new Dimension(200, 30));
       // nameLabel.setFont(App.boldFont);
        gbc.gridx = 2;
        gbc.gridy = row;
        viewStudentsPanel.add(nameLabel, gbc);

        // Display Student Degree Program and Batch
        JLabel degBatchLabel = new JLabel("Deg: " + student.degProgram + ", Batch: " + student.batch);
        degBatchLabel.setPreferredSize(new Dimension(150, 30));
       // degBatchLabel.setFont(App.boldFont);
        gbc.gridx = 3;
        gbc.gridy = row;
        viewStudentsPanel.add(degBatchLabel, gbc);
       // Display Student Email
        JLabel emailLabel = new JLabel("Email: " + student.email);
        emailLabel.setPreferredSize(new Dimension(200, 30));
       // emailLabel.setFont(App.boldFont);
        gbc.gridx = 5;
        gbc.gridy = row;
        viewStudentsPanel.add(emailLabel, gbc);

        // Display Student Phone
        JLabel phoneLabel = new JLabel("Phone: " + student.phone);
        phoneLabel.setPreferredSize(new Dimension(150, 30));
       // phoneLabel.setFont(App.boldFont);
        gbc.gridx = 6;
        gbc.gridy = row;
        viewStudentsPanel.add(phoneLabel, gbc);

        // Display Student Paid Dues
        JLabel paidDuesLabel = new JLabel("Dues paid? : " + (student.paidDues ? "Yes" : "No"));
        paidDuesLabel.setPreferredSize(new Dimension(100, 30));
        paidDuesLabel.setFont(App.boldFont);
        gbc.gridx = 7;
        gbc.gridy = row;
        viewStudentsPanel.add(paidDuesLabel, gbc);

        // Increment row for the next student's information
        row++;

        // Add a separator row for clarity
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1200, 10));
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 8; // Span the separator across all columns
        viewStudentsPanel.add(separator, gbc);

        // Reset gridwidth back to 1 for the next row's content
        gbc.gridwidth = 1;

        // Increment row for the next content after the separator
        row++;
        studentNumber++;
    }

    JPanel container = new JPanel(new GridBagLayout());
    GridBagConstraints gbcContainer = new GridBagConstraints();
    gbcContainer.gridx = 0;
    gbcContainer.gridy = 0;
    viewStudentsPanel.setPreferredSize(new Dimension(1400, 700));
    container.add(viewStudentsPanel, gbcContainer);
    container.setBorder(BorderFactory.createTitledBorder("View Students Panel"));

    viewPanel.removeAll();
    viewPanel.add(container, BorderLayout.CENTER);
    viewPanel.revalidate();
}


    
    
    public static void createAddTeacherPanel(ArrayList<Teacher>teachers) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        GridBagConstraints Gbc = new GridBagConstraints();
        JPanel addTeacherPanel = new JPanel(new GridBagLayout());
        addTeacherPanel.setBorder(BorderFactory.createTitledBorder("Register Yourself here!"));
    
        // Name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        addTeacherPanel.add(nameLabel, gbc);
    
        JTextField nameTF = new JTextField(20);
        nameTF.setFont(App.boldFont);
        gbc.gridx = 1;
        addTeacherPanel.add(nameTF, gbc);
    
        // Email label and text field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addTeacherPanel.add(emailLabel, gbc);
    
        JTextField emailTF = new JTextField(20);
        emailTF.setFont(App.boldFont);
        gbc.gridx = 1;
        addTeacherPanel.add(emailTF, gbc);
    
        // Contact Number label and text field
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        addTeacherPanel.add(contactLabel, gbc);
    
        JTextField contactTF = new JTextField(20);
        contactTF.setFont(App.boldFont);
        gbc.gridx = 1;
        addTeacherPanel.add(contactTF, gbc);
    
        // Department label and text field
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        addTeacherPanel.add(deptLabel, gbc);
    
        JTextField deptTF = new JTextField(20);
        deptTF.setFont(App.boldFont);
        gbc.gridx = 1;
        addTeacherPanel.add(deptTF, gbc);
    
        // Password label and text field
        JLabel pwdLabel = new JLabel("Assign Password:");
        pwdLabel.setFont(App.boldFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        addTeacherPanel.add(pwdLabel, gbc);
    
        JPasswordField pwdTF = new JPasswordField(20);
        pwdTF.setFont(App.boldFont);
        pwdTF.setToolTipText("Password must contain 8 characters!");
        gbc.gridx = 1;
        addTeacherPanel.add(pwdTF, gbc);
    
        // Add Teacher button
        JButton addButton = new JButton("Add Teacher");
        addButton.setFont(App.boldFont);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTF.getText();
                String email = emailTF.getText();
                String contactNumber = contactTF.getText();
                String department = deptTF.getText();
                String password = new String(pwdTF.getPassword());
    
                Teacher newTeacher = new Teacher(name, email, contactNumber, department, password);
                teachers.add(newTeacher);
                JOptionPane.showMessageDialog(addTeacherPanel, "Teacher added successfully!");
                nameTF.setText("");
                emailTF.setText("");
                contactTF.setText("");
                deptTF.setText("");
                pwdTF.setText("");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        App.styleBtn(addButton);
        addTeacherPanel.add(addButton, gbc);
    
        JPanel container = new JPanel(new GridBagLayout());
        Gbc.gridx = 0;
        Gbc.gridy = 0;
        container.add(addTeacherPanel, Gbc);
        container.setBorder(BorderFactory.createTitledBorder("Registration Panel"));
    
        viewPanel.removeAll();
        viewPanel.add(container, BorderLayout.CENTER);
        viewPanel.revalidate();
    }
    

    public static void main(String[] args) {
        Admin ad=new Admin("Admin", "abc");
        Student s=new Student("Aftab","123");
        ArrayList<Student> students =new ArrayList<Student>();
        students.add(s);
        Teacher t=new Teacher("Teacher", "teacher");
        ArrayList<Teacher> teachers=new ArrayList<Teacher>();
        teachers.add(t);
        String[] availableCourse={"Aftab","OOP"};
        AdminDashboard adminDashboard=new AdminDashboard(ad, students, teachers,availableCourse);
    }
}
