import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class StudentRegistrationApp extends JFrame {
    private JTextField firstNameField, lastNameField, dobField, emailField, phoneField;
    private JTextField addressField, cityField, stateField, zipField, studentIDField, majorField;
    private JTextField fatherNameField, motherNameField, emergencyContactField;
    private JLabel imageLabel;
    private JComboBox<String> genderComboBox;
    private File imageFile;

    private Student student;

    public StudentRegistrationApp(Student student) {
        this.student=student;
        setTitle("Student Registration System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add("Personal Info", createPersonalInfoPanel());
        tabbedPane.add("Contact Info", createContactInfoPanel());
        tabbedPane.add("Academic Info", createAcademicInfoPanel());
        tabbedPane.add("Parents Info", createParentsInfoPanel());
        tabbedPane.add("Final Step", createOtherInfoPanel());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(labelFont);
        fieldsPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(20);
        firstNameField.setFont(fieldFont);
        fieldsPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(labelFont);
        fieldsPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(20);
        lastNameField.setFont(fieldFont);
        fieldsPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(labelFont);
        fieldsPanel.add(dobLabel, gbc);

        gbc.gridx = 1;
        dobField = new JTextField(20);
        dobField.setFont(fieldFont);
        fieldsPanel.add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        fieldsPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderComboBox.setFont(fieldFont);
        fieldsPanel.add(genderComboBox, gbc);

        panel.add(fieldsPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        JButton uploadButton = new JButton("Upload Image");
        App.styleBtn(uploadButton);
        fieldsPanel.add(uploadButton);
        uploadButton.addActionListener(e -> {
                   JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            imageFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(imageFile);
                ImageIcon imageIcon = new ImageIcon(resizeImage(image, 150, 150));
                imageLabel.setIcon(imageIcon);

                student.image.setIcon(imageIcon);
                student.image.setText("");
                imageLabel.setText("");
            } catch (IOException ex) {
                App.showmessage("Oop!");
            }
        }

        });
        student.image=new JLabel();
        student.image.setText("image not availaable!");
        student.image.setPreferredSize(new Dimension(300, 300));

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 300));
        imagePanel.add(uploadButton);
        imagePanel.add(imageLabel);
        
        panel.add(imagePanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createContactInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        panel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        phoneField = new JTextField(20);
        phoneField.setFont(fieldFont);
        panel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        panel.add(addressLabel, gbc);

        gbc.gridx = 1;
        addressField = new JTextField(20);
        addressField.setFont(fieldFont);
        panel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(labelFont);
        panel.add(cityLabel, gbc);

        gbc.gridx = 1;
        cityField = new JTextField(20);
        cityField.setFont(fieldFont);
        panel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(labelFont);
        panel.add(stateLabel, gbc);

        gbc.gridx = 1;
        stateField = new JTextField(20);
        stateField.setFont(fieldFont);
        panel.add(stateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel zipLabel = new JLabel("ZIP Code:");
        zipLabel.setFont(labelFont);
        panel.add(zipLabel, gbc);

        gbc.gridx = 1;
        zipField = new JTextField(20);
        zipField.setFont(fieldFont);
        panel.add(zipField, gbc);

        return panel;
    }

    private JPanel createAcademicInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setFont(labelFont);
        panel.add(studentIDLabel, gbc);

        gbc.gridx = 1;
        studentIDField = new JTextField(20);
        studentIDField.setFont(fieldFont);
        panel.add(studentIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel majorLabel = new JLabel("Major:");
        majorLabel.setFont(labelFont);
        panel.add(majorLabel, gbc);

        gbc.gridx = 1;
        majorField = new JTextField(20);
        majorField.setFont(fieldFont);
        panel.add(majorField, gbc);

        return panel;
    }

    private JPanel createParentsInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setFont(labelFont);
        panel.add(fatherNameLabel, gbc);

        gbc.gridx = 1;
        fatherNameField = new JTextField(20);
        fatherNameField.setFont(fieldFont);
        panel.add(fatherNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel motherNameLabel = new JLabel("Mother's Name:");
        motherNameLabel.setFont(labelFont);
        panel.add(motherNameLabel, gbc);

        gbc.gridx = 1;
        motherNameField = new JTextField(20);
        motherNameField.setFont(fieldFont);
        panel.add(motherNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setFont(labelFont);
        panel.add(emergencyContactLabel, gbc);

        gbc.gridx = 1;
        emergencyContactField = new JTextField(20);
        emergencyContactField.setFont(fieldFont);
        panel.add(emergencyContactField, gbc);
        fillFields();

        return panel;
    }

    private JPanel createOtherInfoPanel() {
        JPanel panel = new JPanel();
        JButton submitButton = new JButton("Submit");
        App.styleBtn(submitButton);
        submitButton.addActionListener(e -> handleSubmit());
        panel.add(student.image);
        panel.add(submitButton);

        return panel;
    }

    private void handleSubmit() {
        student.firstName = firstNameField.getText();
        student.lastName = lastNameField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        student.dob = dobField.getText();
        student.gender = (String) genderComboBox.getSelectedItem();
        student.email = emailField.getText();
        student.phone = phoneField.getText();
        student.address = addressField.getText();
        student.city = cityField.getText();
        student.state = stateField.getText();
        student.zip = zipField.getText();
        student.studentID = studentIDField.getText();
        student.major = majorField.getText();
        student.fatherName = fatherNameField.getText();
        student.motherName = motherNameField.getText();
        student.emergencyContact = emergencyContactField.getText();

        JOptionPane.showMessageDialog(this, "Registration Successful for " + student.firstName + " " + student.lastName + "!");
        dispose();
    }
    private Image resizeImage(BufferedImage originalImage, int width, int height) {
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return resizedImage;
    }
    private void  fillFields(){
        firstNameField.setText(student.firstName);
        lastNameField.setText(student.lastName);
        dobField.setText(student.dob);
        emailField.setText(student.email);
        phoneField.setText(student.phone);
        addressField.setText(student.address);
        cityField.setText(student.city);
        stateField.setText(student.state);
        zipField.setText(student.zip);
        studentIDField.setText(student.studentID);
        majorField.setText(student.major);
        fatherNameField.setText(student.fatherName);
        motherNameField.setText(student.motherName);
        emergencyContactField.setText(student.emergencyContact);
        
    }
}

