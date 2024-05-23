import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class simplelogin implements ActionListener,ItemListener {
    GregorianCalendar c=new GregorianCalendar();
       
    public JTextField nameTf,pwdTf;
    public JTextArea textArea;
    public String name;
    public String pwd;
    JButton register,login;
    private JComboBox box;
    private JLabel select;
    private String array[][];
    private static String names[]={"a","b","c"};
    private String recordLine;
    simplelogin(String array[][]){
           this.array=array;
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
        box.setMaximumRowCount(3);

         pane.add(nameTf);
        pane.add(pwdTf);
        pane.add(register);
        pane.add(textArea);
        pane.add(login); 
         pane.add(select);
        box.setFont(App.boldFont);
        box.setBorder(BorderFactory.createTitledBorder("Select your Departmet"));
        box.setPreferredSize(new Dimension(300, 50));
   
        
        box.addItemListener(this);
        login.addActionListener(this);
        register.addActionListener(this);  
        textArea.setPreferredSize(new Dimension(500, 699));
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(register)){
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++)
              recordLine=array[i][0]+array[i][1]; 
              App.showmessage(recordLine);


            }
            
















     
    }
    else if(e.getSource().equals(login)){
       
    }
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getSource().equals(box)){
             select.setText(names[box.getSelectedIndex()]);    
        }
    }
    
    public static void main(String[] args) {
       
        // Define the start and end dates of the semester
        LocalDate startDate = LocalDate.of(2024, 9, 1); // Example: September 1, 2024
        // Create a 2D array to store dates and empty attendance
        String[][] attendanceArray = new String[121][2];

        // Populate the array with dates and empty attendance
        LocalDate currentDate = startDate;
        for (int i = 0; i < 121; i++) {
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
            attendanceArray[i][0] = formattedDate;
            attendanceArray[i][1] = "P"; // Leave the second column empty
            currentDate = currentDate.plusDays(1); // Move to the next day
        }

        // Print the attendance array (for demonstration)
      //  for (String[] row : attendanceArray) {
            
           // System.out.println("Date: " + row[0] + ", Attendance: " + row[1]);
       // }
       // simplelogin s =new simplelogin(attendanceArray);
       int[] arr=new int[2];
       arr[0]=1;
       arr[1]=2;
       for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
       }
       int[] arr2=new int[3];
       
       
       System.out.println("arrray 2");
       System.out.println(arr2.length);

    }
}

