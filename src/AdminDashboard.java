import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminDashboard {
      private Admin admin;
      JPanel rightPanel,leftPanel,container,panel;
      private JButton addTeacher,addStudent,approveExamSlip,viewStudents,viewTeachers,viewCourses,assignCourses;
   // AdminDashboard(){}
    AdminDashboard(Admin admin){
        this.admin=admin;
        JFrame frm = new JFrame("Admin DashBoard");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        /* Panels */
        panel=new JPanel(new GridBagLayout());
        rightPanel=new JPanel();
        rightPanel.add((new JLabel("Admin Panel View")),BorderLayout.NORTH);
        rightPanel.setBackground(Color.white);
        rightPanel.setForeground(Color.black);
        leftPanel=new JPanel();
        leftPanel.setBackground(Color.white);
        leftPanel.setForeground(Color.black);
        /* left panel stuff ............................................*/
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
        leftPanel.add(addTeacher);
        leftPanel.add(viewTeachers);
        leftPanel.add(addStudent);
        leftPanel.add(viewStudents);
        leftPanel.add(viewCourses);
        leftPanel.add(assignCourses);
        leftPanel.add(approveExamSlip);
        /* ........................................................................... */
        
        GridBagConstraints Gbc=new GridBagConstraints();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(2   , 10, 10, 10);
        gbc.gridy=1;
        panel.add(leftPanel,gbc);
        gbc.gridy=2;
        panel.add(rightPanel,gbc);
        rightPanel.setPreferredSize(new Dimension(1180, 620));
       
        container=new JPanel(new GridBagLayout());
        Gbc.gridx=0;
        Gbc.gridy=0;
        container.add(panel,Gbc);
        container.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        frm.add(container,BorderLayout.NORTH);
       App.showmessage("Admin Receiver", admin.userName);
        
    }
}
