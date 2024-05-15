import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.Flow;
public class RegForm implements ActionListener {
     private Student student;
    JTextField nameTf,pwdTf,degTf;
    JButton registerBtn;
    public static JFrame regFormFrame;

    public RegForm(){
       // this.student=student;
        regFormFrame = new JFrame("Registration form");
        regFormFrame.setSize(App.width,App.height);
        regFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFormFrame.setVisible(true);
        JPanel rightPanel,leftPanel,container,panel;
         /* Panels */
          panel=new JPanel(new GridBagLayout());
          rightPanel=new JPanel();
          rightPanel.add((new JLabel("Registration  Panel View")),BorderLayout.NORTH);
          rightPanel.setBackground(Color.white);
          rightPanel.setForeground(Color.black);
          leftPanel=new JPanel();
          leftPanel.setBackground(Color.white);
          leftPanel.setForeground(Color.black);
    
          /* left panel stuff ............................................*/
          
          registerBtn=new JButton("Regiser yourself");
          registerBtn.setForeground(App.fgColor);registerBtn.setBackground(App.bgColor);
          registerBtn.setFont(new Font("Courier", Font.BOLD, 20));
          leftPanel.add(registerBtn);
          /* ........................................................................... */
          
          GridBagConstraints Gbc=new GridBagConstraints();
          GridBagConstraints gbc=new GridBagConstraints();
          gbc.insets=new Insets(15 , 5, 10, 5);
          gbc.gridy=2;
          panel.add(leftPanel,gbc);
          gbc.gridy=1;
          panel.add(rightPanel,gbc);
          rightPanel.setPreferredSize(new Dimension(1180, 580));
         
          container=new JPanel(new GridBagLayout());
          Gbc.gridx=0;
          Gbc.gridy=0;
          container.add(panel,Gbc);
          container.setBorder(BorderFactory.createLineBorder(Color.GREEN));
          regFormFrame.add(container,BorderLayout.NORTH);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == registerBtn) {
            String name = nameTf.getText();
            String password = pwdTf.getText();
            String degreeProgram = degTf.getText();

        }
    
    

       
    }
    public static void main(String[] args) {
        RegForm regForm=new RegForm();
    }
   
}
