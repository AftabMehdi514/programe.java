import javax.swing.*;
import java.awt.*;
import java.awt.image.renderable.ContextualRenderedImageFactory;
public class Center {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Registration form");
        frm.setSize(1500, 648);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(null);
        frm.setVisible(true);
        JPanel panel=new JPanel();
        JPanel panell=new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLocation(100,90);
        panell.setBackground(Color.GREEN);
        panell.setLocation(700, 700);
        // Container pane=frm.getContentPane();
        // pane.setBackground(Color.RED);
        JTextField txt=new JTextField(20);
        txt.setText("hello");
        frm.add(panel);
        frm.add(panell);
        frm.add(txt);
    }
}
