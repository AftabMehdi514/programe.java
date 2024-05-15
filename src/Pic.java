import javax.swing.*;
import java.awt.*;

public class Pic {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Buttons");
        frm.setSize(900, 550);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new FlowLayout(FlowLayout.LEFT)); // Set layout to FlowLayout with left alignment
        frm.setVisible(true);
        
        // Load image from src folder
        ImageIcon icon = new ImageIcon(Pic.class.getResource("regpic.jpg"));

        // Resize the image
        Image img = icon.getImage().getScaledInstance(00, 700, Image.SCALE_SMOOTH); // Specify width and height
        ImageIcon scaledIcon = new ImageIcon(img);

        // Create JLabel with the scaled image
        JLabel label = new JLabel(scaledIcon);

        // Add JLabel to JFrame's content pane
        frm.add(label);

        frm.setVisible(true);
    }
}
