import javax.swing.*;
import java.awt.*;

public class buttons extends JFrame {
    buttons(){
        JFrame frm = new JFrame("Buttons");
        frm.setSize(900, 550);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(new Color(200, 200, 200)); // Set background color for the frame
        JButton btnAdmin = new JButton("Admin");
        JButton btnTeacher = new JButton("Teacher");
        JButton btnStudents = new JButton("Students");
    // Set text color to white and background color to blue for buttons
        Color textColor = Color.WHITE;
        Color bgColor = new Color(30, 144, 255); 
        btnAdmin.setForeground(textColor);
        btnAdmin.setBackground(bgColor);
        btnTeacher.setForeground(textColor);
        btnTeacher.setBackground(bgColor);
        btnStudents.setForeground(textColor);
        btnStudents.setBackground(bgColor);

        // Increase button size
        Dimension buttonSize = new Dimension(150, 50);
        btnAdmin.setPreferredSize(buttonSize);
        btnTeacher.setPreferredSize(buttonSize);
        btnStudents.setPreferredSize(buttonSize);
        btnAdmin.setFont(App.boldFont);
        btnTeacher.setFont(App.boldFont);
        btnStudents.setFont(App.boldFont);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Select Your Role"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add insets for padding


        // Add Admin button
        gbc.gridy = 1;
        panel.add(btnAdmin, gbc);

        // Add Teacher button
        gbc.gridy = 2;
        panel.add(btnTeacher, gbc);

        // Add Students button
        gbc.gridy = 3;
        panel.add(btnStudents, gbc);

        // Center the panel containing buttons
        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints containerGbc = new GridBagConstraints();
        containerGbc.gridx = 0;
        containerGbc.gridy = 0;
        container.add(panel, containerGbc);

        // Center the container panel within the frame
        frm.add(container, BorderLayout.CENTER);

        // Center the JFrame on the screen
        frm.setLocationRelativeTo(null);

        frm.setVisible(true);
    }
    public static void main(String[] args) {
        buttons butn=new buttons();
    }
}
