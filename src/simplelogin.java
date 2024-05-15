import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class simplelogin implements ActionListener,ItemListener {
    public JTextField nameTf,pwdTf;
    public JTextArea textArea;
    public String name;
    public String pwd;
    JButton register,login;
    private JComboBox box;
    private JLabel select;
    private static String names[]={"a","b","c"};
    simplelogin(){
    JFrame frm = new JFrame("Buttons");
        frm.setSize(900, 550);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(new Color(200, 200, 200)); 
        frm.setVisible(true);
         nameTf=new JTextField(20);
        pwdTf=new JTextField(20);
        textArea=new JTextArea();
         register=new JButton("Register");
         login=new JButton();
         String a="log IN";
         String b="hello";
        Container pane=frm.getContentPane();
        pane.setLayout(new FlowLayout());
        JFileChooser chooser=new JFileChooser();
        JCheckBoxMenuItem item=new JCheckBoxMenuItem("AFtab");
        JDesktopPane p=new JDesktopPane();
        p.add(new JButton("Next"));
         box=new JComboBox<>(names);
         select=new JLabel("no item selected");
       // box.setMaximumRowCount(3);

       /*  pane.add(nameTf);
        pane.add(pwdTf);
        pane.add(register);
        pane.add(textArea);
        pane.add(login); */
        pane.add(select);
        box.setFont(App.boldFont);
        box.setBorder(BorderFactory.createTitledBorder("Select your Departmet"));
        box.setPreferredSize(new Dimension(300, 50));
      /*   box.setBackground(new Color(0,0,0),Color.OPAQUE); */
      box.setComponentZOrder(p, 0);
        pane.add(box);
        
        box.addItemListener(this);
        login.addActionListener(this);
        register.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(register)){
       name=nameTf.getText();
       pwd=pwdTf.getText();
       textArea.setText("Name : "+this.name+"\npwd: "+this.pwd);
       nameTf.setText("");
       pwdTf.setText("");
    }
    else if(e.getSource().equals(login)){
        if((nameTf.getText().equals(name))&&(pwdTf.getText().equals(pwd))){
                 JOptionPane.showMessageDialog(null, "log in Succefull ", name, 0);
        }
    }
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getSource().equals(box)){
             select.setText(names[box.getSelectedIndex()]);    
        }
    }
    public static void main(String[] args) {
        simplelogin slogin=new simplelogin();
    }
}
