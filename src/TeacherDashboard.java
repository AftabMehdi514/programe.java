import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TeacherDashboard implements ActionListener {
      private Teacher teachers;
      private static Student[] students;
       private static JPanel lowerPanel,upperPanel,container,panel,lowerViewPanel, linePanel;
      private static JButton addTeacher,addStudent,approveExamSlip,viewStudents,viewTeachers,viewCourses,assignCourses;
      private static JLabel label;
      private static JComboBox courseSelector,batchSelector;
      private static JButton viewStudentsBtn;
      private static  JLabel batch,name,deg,btch;
   // TeacherDashboard(){}

    TeacherDashboard(Student[] students){
        this.students=students;
        JFrame frm = new JFrame("Teacher Dashboard");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        /* Panels */
        panel=new JPanel(new GridBagLayout());
        lowerPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 20));
       // lowerPanel=new JPanel(new FlowLayout());
        JPanel lowerFilterPanel=new JPanel();
        lowerFilterPanel.setBorder(BorderFactory.createTitledBorder("Specify Students here!"));
        /* Combobox */
        courseSelector=new JComboBox<>(App.courses);
        courseSelector.setPreferredSize(new Dimension(400, 30));
        batchSelector=new JComboBox<>(App.batch);
        batchSelector.setBackground(Color.white);
        courseSelector.setBackground(Color.WHITE);
        batchSelector.setPreferredSize(new Dimension(400, 30));
        /* Buttons */
        viewStudentsBtn=new JButton("View Students");
        App.styleBtn(viewStudentsBtn);
        viewStudentsBtn.addActionListener(this);
        lowerFilterPanel.add(new JLabel("Specify Students here!"));
        
        lowerFilterPanel.add(courseSelector);
        lowerFilterPanel.add(batchSelector);
        lowerFilterPanel.add(viewStudentsBtn);
        lowerFilterPanel.setBackground(Color.white);
        lowerViewPanel=new JPanel();
        label=new JLabel("helo");
       
        lowerViewPanel.setBorder(BorderFactory.createTitledBorder("Mark Attendance Here!"));
       // lowerViewPanel.add();
        lowerViewPanel.setPreferredSize(new Dimension(1100, 500));
        lowerPanel.add(lowerFilterPanel);
        lowerPanel.add(lowerViewPanel);


        lowerPanel.setBackground(Color.white);
        lowerPanel.setForeground(Color.black);
        upperPanel=new JPanel();
        upperPanel.setBackground(Color.white);
        upperPanel.setForeground(Color.black);
        /* uppper panel stuff ............................................*/
        addTeacher=new JButton("Add Teacher");
        addTeacher.setForeground(App.fgColor);addTeacher.setBackground(App.bgColor);
        addTeacher.setFont(App.btnFont);
        addStudent=new JButton("Add Student");
        addStudent.setForeground(App.fgColor);addStudent.setBackground(App.bgColor);
        addStudent.setFont(App.btnFont);
        viewStudents=new JButton("View Students");
        viewStudents.setForeground(App.fgColor);viewStudents.setBackground(App.bgColor);
        viewStudents.setFont(App.btnFont);
        viewTeachers=new JButton("View Teachers");
        viewTeachers.setForeground(App.fgColor);viewTeachers.setBackground(App.bgColor);
        viewTeachers.setFont(App.btnFont);
        viewCourses=new JButton("View Courses");
        viewCourses.setForeground(App.fgColor);viewCourses.setBackground(App.bgColor);
        viewCourses.setFont(App.btnFont);
        assignCourses=new JButton("Assign Courses");
        assignCourses.setForeground(App.fgColor);assignCourses.setBackground(App.bgColor);
        assignCourses.setFont(App.btnFont);
        approveExamSlip=new JButton("Approve Exam Slip");
        approveExamSlip.setForeground(App.fgColor);approveExamSlip.setBackground(App.bgColor);
        approveExamSlip.setFont(App.btnFont);
        upperPanel.add(addTeacher);
        upperPanel.add(viewTeachers);
        upperPanel.add(addStudent);
        upperPanel.add(viewStudents);
        upperPanel.add(viewCourses);
        upperPanel.add(assignCourses);
        upperPanel.add(approveExamSlip);
   

       
        /* ........................................................................... */
        
        GridBagConstraints Gbc=new GridBagConstraints();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(2   , 10, 10, 10);
        gbc.gridy=1;
        panel.add(upperPanel,gbc);
        gbc.gridy=2;
        panel.add(lowerPanel,gbc);
        lowerPanel.setPreferredSize(new Dimension(1180, 620));
       
        container=new JPanel(new GridBagLayout());
        Gbc.gridx=0;
        Gbc.gridy=0;
        container.add(panel,Gbc);
        container.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        frm.add(container,BorderLayout.NORTH);
        viewStudents.addActionListener(this);
       // App.showmessage("teacher Receiver", teacher.userName);
        
    }
     public  void actionPerformed(ActionEvent e ){
        if(e.getSource().equals(viewStudentsBtn)){
         for(Student s:students){
         name=new JLabel(s.userName);
         batch=new JLabel(s.batch);
         deg=new JLabel(s.degProgram);
          JButton  presentBtn=new JButton("Present");
          JButton absentBtn=new JButton("Absent");
         Dimension dim=new Dimension(100, 30);
         name.setPreferredSize(dim);
         batch.setPreferredSize(dim);
         deg.setPreferredSize(new Dimension(500, 30));
         linePanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
         linePanel.setBackground(Color.white);
         linePanel.setPreferredSize(new Dimension(1000, 40));
         linePanel.add(batch);
         linePanel.add(name);
         linePanel.add(deg);
         App.styleBtn(presentBtn); 
         App.styleBtn(absentBtn);
         linePanel.add(presentBtn);  presentBtn.addActionListener(new buttonHandler(presentBtn,absentBtn));
         linePanel.add(absentBtn);  absentBtn.addActionListener(new buttonHandler(presentBtn, absentBtn));
         lowerViewPanel.add(linePanel);
         lowerViewPanel.revalidate();
        
         
                
      } 
        }
    }
    public static void main(String[] args) {
        Teacher teacher=new Teacher("Numan", "123");
        Student[] students=new Student[2];
         students[0]=new Student("Aftab","123","CIS","23-27");
         students[1]=new Student("Ahmad", "abc","Physics","24-28");
        TeacherDashboard TeacherDashboard=new TeacherDashboard(students);

    }
     class buttonHandler implements ActionListener{
       private JButton presentBtn,absentBtn;
       buttonHandler(JButton pBtn,JButton aBtn){
         this.presentBtn=pBtn;
         this.absentBtn=aBtn;
       }
       public void actionPerformed(ActionEvent e) {
          if(e.getSource().equals(presentBtn)){
            App.showmessage("I am present");
          }
         else if(e.getSource().equals(absentBtn)){
            App.showmessage("I am absent");
            //Ta ta this is amazing//
          }
           
       }
    }
}
