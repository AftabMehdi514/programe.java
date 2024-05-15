import javax.swing.*;
import java.awt.*;
public class ResultCardForm {
    
    ResultCardForm(){
        JFrame frm = new JFrame("Student Marks form");
        frm.setSize(1500, 648);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        ImageIcon img=new ImageIcon(RegForm.class.getResource("resultCardPic.jpg"));
        Image sImg=img.getImage().getScaledInstance(650, 648, 0);
        ImageIcon pic=new ImageIcon(sImg);
        Container pane=frm.getContentPane();
        pane.setLayout(new BorderLayout());
        JTextArea txt=new JTextArea();
        txt.setText("hello this is Result Card  form");
        JLabel imgL=new JLabel(pic);
        JPanel leftP=new JPanel(new FlowLayout());
        JPanel rightP=new JPanel(new FlowLayout());
        leftP.add(imgL);
        rightP.add(txt);
        leftP.setBorder(BorderFactory.createLineBorder(Color.RED));
        rightP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pane.add(leftP,BorderLayout.WEST);
        pane.add(rightP,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        ResultCardForm resultCardForm=new ResultCardForm();
    }
}


