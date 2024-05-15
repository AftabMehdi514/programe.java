import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentDashboard implements ActionListener {
    Course courses[];
    private Student student;
    private JButton studentReg,hostelTransportCon,courseEnroll,enrollSummary,feeDetail,courseFeedBack,resultCard,attendance,admitSlip,policyForCheating,printChalan,financialAssistance,logOut;
    private JPanel manuPanel,viewPanel,enrollmentPanel;
    private JTextArea info,other;
    private static JFrame frm;
    StudentDashboard(){}
    StudentDashboard(Student student){
        this.student=student;
         frm = new JFrame("Student Registration Portal");
        frm.setSize(App.width, App.height);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(new Color(200, 200, 200)); 
        frm.setVisible(true);
        //..................................///
        //Buttons.................................//
        studentReg=new JButton("Student Registration");
        studentReg.setForeground(App.fgColor);studentReg.setBackground(App.bgColor);
        studentReg.setFont(App.btnFont); studentReg.addActionListener(this);
        hostelTransportCon=new JButton("Hostel Transport Confirm");
        hostelTransportCon.setForeground(App.fgColor);hostelTransportCon.setBackground(App.bgColor);
        hostelTransportCon.setFont(App.btnFont);
        courseEnroll=new JButton("Course Enroll");
        courseEnroll.setForeground(App.fgColor);courseEnroll.setBackground(App.bgColor);
        courseEnroll.setFont(App.btnFont);
        enrollSummary=new JButton("Enrollment Summary");
        enrollSummary.setForeground(App.fgColor);enrollSummary.setBackground(App.bgColor);
        enrollSummary.setFont(App.btnFont);
        feeDetail=new JButton("Complete Fee Details");
        feeDetail.setForeground(App.fgColor);feeDetail.setBackground(App.bgColor);
        feeDetail.setFont(App.btnFont);
        courseFeedBack=new JButton("Course Feedback");
        courseFeedBack.setForeground(App.fgColor);courseFeedBack.setBackground(App.bgColor);
        courseFeedBack.setFont(App.btnFont);
        resultCard=new JButton("View Result Card");
        resultCard.setForeground(App.fgColor);resultCard.setBackground(App.bgColor);
        resultCard.setFont(App.btnFont);
        attendance=new JButton("View Attendance");
        attendance.setForeground(App.fgColor);attendance.setBackground(App.bgColor);
        attendance.setFont(App.btnFont);
        admitSlip=new JButton("Admit Slip");
        admitSlip.setForeground(App.fgColor);admitSlip.setBackground(App.bgColor);
        admitSlip.setFont(App.btnFont);
        policyForCheating=new JButton("Policy For Cheating Cases");
        policyForCheating.setForeground(App.fgColor);policyForCheating.setBackground(App.bgColor);
        policyForCheating.setFont(App.btnFont);
        printChalan=new JButton("CISD Print Challan");
        printChalan.setForeground(App.fgColor);printChalan.setBackground(App.bgColor);
        printChalan.setFont(App.btnFont);
        financialAssistance=new JButton("Financial Assistance");
        financialAssistance.setForeground(App.fgColor);financialAssistance.setBackground(App.bgColor);
        financialAssistance.setFont(App.btnFont);
        logOut=new JButton("Log Out");
        logOut.setForeground(App.fgColor);logOut.setBackground(App.bgColor);
        logOut.setFont(App.btnFont);
        //........................................//
       //.............panels......................
       JLabel title=new JLabel("~Student Registration Portal");
       title.setBorder(BorderFactory.createLineBorder(App.bgColor));
       title.setFont(new Font("Arial", Font.BOLD, 40));
       title.setForeground(App.bgColor);
       title.setBackground(Color.white);
        manuPanel=new JPanel(new GridLayout(15, 2, 0, 7));
        manuPanel.setBorder(BorderFactory.createTitledBorder("Dashboard Panel"));
        viewPanel=new JPanel(new FlowLayout()); 
        viewPanel.setBorder(BorderFactory.createTitledBorder("View Panel"));
       //,,,,,,,,,,,,,,Registration Panel,,,,,,,,,,,,,,,,,,,,,//

       //.....................................................//
       info=new JTextArea("Your Will See Information here");
       other=new JTextArea("New Information");
       enrollmentPanel=new JPanel();
       enrollmentPanel.add(info);
        
        viewPanel.add(enrollmentPanel);

       //.....................
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
       manuPanel.add(printChalan);
       manuPanel.add(financialAssistance);
       manuPanel.add(logOut); logOut.addActionListener(this);
       
       //...................,
        Container pane=frm.getContentPane();
        pane.add(title,BorderLayout.NORTH);
        pane.add(manuPanel ,BorderLayout.WEST);
        pane.add(viewPanel,BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, "MAINPAGE HAS RECEIVED"+student.userName, null, 0);
       

    }
    public  void  actionPerformed(ActionEvent e){
     if(e.getSource().equals(studentReg)){
        RegForm regForm=new RegForm(student);
         
     }
     else if(e.getSource().equals(logOut)){
      App.showmessage("I am loging out");
       frm.setVisible(false);
       LogInForm.loginFrame.setVisible(false);
       SignUp.signUpFrm.setVisible(false);
     }
    }
 
}