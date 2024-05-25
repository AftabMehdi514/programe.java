/* int this class there is problem with previewing students for uploadresult and for uploading attendance functionality is correct but little bit problem is still. */
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.util.ArrayList;

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

public class TeacherDashboard implements ActionListener,ItemListener {
      private Teacher teachers;
      private static ArrayList<Student> students;
      private static Teacher teacher;

       private static JPanel lowerPanel,upperPanel,container,panel,lowerFilterPanel,lowerViewPanel, linePanel;
      private static JButton uploadAttendance,uploadResult,logOut,viewStudents;
      private static JComboBox courseSelector,dateSelector;
      private static JButton viewStudentsBtn;
      private static  JLabel batch,name,deg;
      private static int selectedCourseIndex,selectedDateIndex,marks;
     private static JFrame frm;
   // TeacherDashboard(){}

    TeacherDashboard(Teacher teacher,ArrayList<Student> students){
        this.teacher=teacher;
        this.students=students;
        frm = new JFrame("Teacher Dashboard");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        /* Panels */
        panel=new JPanel(new GridBagLayout());
        lowerPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 20));
         lowerFilterPanel=new JPanel();
        lowerFilterPanel.setBorder(BorderFactory.createTitledBorder("Specify Students here!"));
        /* Combobox */
        courseSelector=new JComboBox<>(App.availablecourses);
        courseSelector.setPreferredSize(new Dimension(400, 30));
        courseSelector.addItemListener(this);
        dateSelector=new JComboBox<>(students.get(0).courses[0].date);
        dateSelector.setBackground(Color.white);
        dateSelector.addItemListener(this);
        courseSelector.setBackground(Color.WHITE);
        dateSelector.setPreferredSize(new Dimension(400, 30));
        /* Buttons */
        viewStudentsBtn=new JButton("View Students");
        App.styleBtn(viewStudentsBtn);
        lowerFilterPanel.add(new JLabel(""+students.get(0).courses[0].courseAttendanceArray[0][0]));
        
        lowerFilterPanel.add(courseSelector);
        lowerFilterPanel.add(dateSelector);
        //lowerFilterPanel.add(viewStudentsBtn);
        lowerFilterPanel.setBackground(Color.white);
        lowerViewPanel=new JPanel();
       
        lowerViewPanel.setBorder(BorderFactory.createTitledBorder("Mark Attendance Here!"));
      
        lowerViewPanel.setPreferredSize(new Dimension(1100, 500));
       /*  lowerPanel.add(lowerFilterPanel);
        lowerPanel.add(lowerViewPanel); */


        lowerPanel.setBackground(Color.white);
        lowerPanel.setForeground(Color.black);
        lowerPanel.setBorder(BorderFactory.createTitledBorder("View Info Panel"));
        upperPanel=new JPanel();
        upperPanel.setBackground(Color.white);
        upperPanel.setForeground(Color.black);
        /* uppper panel stuff ............................................*/
        uploadAttendance=new JButton("Upload Attendance");
        uploadAttendance.setForeground(App.fgColor);uploadAttendance.setBackground(App.bgColor);
        uploadAttendance.setFont(App.btnFont); uploadAttendance.addActionListener(this);
        uploadResult=new JButton("Upload Result");
        uploadResult.setForeground(App.fgColor);uploadResult.setBackground(App.bgColor);
        uploadResult.setFont(App.btnFont);  uploadResult.addActionListener(this);
        viewStudents=new JButton("View Students");
        viewStudents.setForeground(App.fgColor);viewStudents.setBackground(App.bgColor);
        viewStudents.setFont(App.btnFont);
        logOut=new JButton("Logout");
        logOut.setForeground(App.fgColor);logOut.setBackground(App.bgColor);
        logOut.setFont(App.btnFont);logOut.addActionListener(this);
        upperPanel.add(uploadAttendance);
        upperPanel.add(uploadResult);
        upperPanel.add(logOut);
       upperPanel.setBorder(BorderFactory.createTitledBorder("Option Panel"));
   

       
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
        frm.add(container,BorderLayout.NORTH);
        viewStudents.addActionListener(this);
        
    }
     public  void actionPerformed(ActionEvent e ){
      if(e.getSource().equals(logOut)){
        frm.dispose();
        App app=new App(App.students, App.admins, App.teachers);
      }
      if (e.getSource().equals(uploadResult)) {
        lowerFilterPanel.removeAll();
        lowerFilterPanel.add(courseSelector);
        JButton viewStudentsBtn=new JButton("View Students");
        lowerFilterPanel.add(viewStudentsBtn);
        App.styleBtn(viewStudentsBtn);
        lowerViewPanel.removeAll();
        lowerViewPanel.setBorder(BorderFactory.createTitledBorder("Student List is here"));
        lowerPanel.add(lowerFilterPanel);
        viewStudentsBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
            for(Student s:students){
              JTextField marksTf=new JTextField(2);
              JButton addMarks=new JButton("Add Marks"); App.styleBtn(addMarks);
              addMarks.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                  // 
                  throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
                }

                @Override
                public void keyPressed(KeyEvent e) {
                
                           
                  throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
                }

                @Override
                public void keyReleased(KeyEvent e) {
                  
                  throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
                }
                
              });
              addMarks.addActionListener(new ActionListener() {
               public  void actionPerformed(ActionEvent e){
                App.showmessage("Still underDevelopment");
                    
                }
              });
              name=new JLabel(s.userName);
              batch=new JLabel(s.batch);
              deg=new JLabel(s.degProgram);
              Dimension dim=new Dimension(100, 30);
              name.setPreferredSize(dim);
              batch.setPreferredSize(dim);
              deg.setPreferredSize(new Dimension(430, 30));
              linePanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
              linePanel.setBackground(Color.white);
              linePanel.setPreferredSize(new Dimension(1000, 40));
              linePanel.add(batch);
              linePanel.add(name);
              linePanel.add(deg);
              linePanel.add(marksTf);
              linePanel.add(addMarks);
              lowerViewPanel.add(linePanel);
              lowerViewPanel.revalidate();        
           } 

            }}
        );
        lowerPanel.add(lowerViewPanel);
        lowerPanel.revalidate();
      }
      if(e.getSource().equals(uploadAttendance)){
        lowerFilterPanel.removeAll();
        lowerFilterPanel.add(courseSelector);
        lowerFilterPanel.add(dateSelector);
        
        lowerViewPanel.removeAll();
        lowerViewPanel.revalidate();
        JButton showStudents=new JButton("Show Students");
        lowerFilterPanel.add(showStudents);
        App.styleBtn(showStudents);
        lowerViewPanel.revalidate();
        showStudents.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
           if(selectedCourseIndex==-1||selectedDateIndex==-1){
            App.showmessage("Please specify Course and Date First!");
            return;
           }
                lowerViewPanel.removeAll();
            for(int j=0;j<students.size();j++){
              for(int i=0;i<students.get(j).courses.length;i++)
              {
                if(App.availablecourses[selectedCourseIndex+1].equals(students.get(j).courses[i].courseName)){
                name=new JLabel(students.get(j).userName);
                batch=new JLabel(students.get(j).batch);
                deg=new JLabel(students.get(j).degProgram);
               JButton  presentBtn=new JButton("Present");
               JButton absentBtn=new JButton("Absent");
               JButton resetBtn=new JButton("Reset");
       
                Dimension dim=new Dimension(100, 30);
                name.setPreferredSize(dim);
                batch.setPreferredSize(dim);
                deg.setPreferredSize(new Dimension(430, 30));
                linePanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
                linePanel.setBackground(Color.white);
                linePanel.setPreferredSize(new Dimension(1000, 40));
                linePanel.add(batch);
                linePanel.add(name);
                linePanel.add(deg);
       
                App.styleBtn(presentBtn); 
                App.styleBtn(absentBtn);
                App.styleBtn(resetBtn);
                linePanel.add(presentBtn);  presentBtn.addActionListener(new buttonHandler(presentBtn,absentBtn,resetBtn,students.get(j)));
                linePanel.add(absentBtn);  absentBtn.addActionListener(new buttonHandler(presentBtn, absentBtn,resetBtn,students.get(j)));
                linePanel.add(resetBtn); resetBtn.addActionListener(new buttonHandler(presentBtn, absentBtn, resetBtn, students.get(j)));
                linePanel.revalidate();
                lowerViewPanel.add(linePanel);
                lowerViewPanel.revalidate(); 
                   i=students.get(j).courses.length;
                  }
              }        
         } 
         lowerViewPanel.revalidate();
        
       
          }
        });
          lowerPanel.add(lowerFilterPanel);
          lowerPanel.add(lowerViewPanel);
          lowerPanel.revalidate();
        
        }

    }
    public void itemStateChanged(ItemEvent e){
      if(e.getSource().equals(courseSelector)){
           selectedCourseIndex=courseSelector.getSelectedIndex()-1;
      }
      if(e.getSource().equals(dateSelector)){
         selectedDateIndex=dateSelector.getSelectedIndex()-1;
        }
      
    }
  /*   public static void main(String[] args) {
        Teacher teacher=new Teacher("Numan", "123");
        Student[] students=new Student[2];
         students[0]=new Student("Aftab","123","CIS","23-27");
         students[1]=new Student("Ahmad", "abc","Physics","24-28");
        TeacherDashboard TeacherDashboard=new TeacherDashboard(students);

    }  */
     class buttonHandler implements ActionListener{
       private JButton presentBtn,absentBtn,resetBtn;
       private Student student;
       buttonHandler(JButton pBtn,JButton aBtn,JButton r,Student s){
         this.student=s;
         this.resetBtn=r;
         this.presentBtn=pBtn;
         this.absentBtn=aBtn;
       }
       public void actionPerformed(ActionEvent e) {
          if(e.getSource().equals(presentBtn)){
            student.courses[selectedCourseIndex].courseAttendanceArray[selectedDateIndex][2]="Present";
            App.clickedStyleBtn(presentBtn);
            absentBtn.setVisible(false);
          }
         else if(e.getSource().equals(absentBtn)){
               student.courses[selectedCourseIndex].courseAttendanceArray[selectedDateIndex][2]="Absent";
               App.clickedStyleBtn2(absentBtn);
               presentBtn.setVisible(false);
            
          } 
         else if(e.getSource().equals(resetBtn)) { 
              student.courses[selectedCourseIndex].courseAttendanceArray[selectedDateIndex][2]="";
              App.styleBtn(presentBtn);
              App.styleBtn(absentBtn);
              absentBtn.setVisible(true);
              presentBtn.setVisible(true);
         } 
       }
       
    }
}
