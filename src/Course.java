import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course {
    public String courseName;
    private int courseCreditHour;
    private int courseSemester;
    private String courseInstructor;
    int marks;
    /* lets make attendance management */
    
    String[][] courseAttendanceArray = new String[121][3];
   //For Combo Box//
    String[] date=new String[122];
    
    public void iniatilizeAttendanceRecord(){
        LocalDate startDate = LocalDate.of(2024, 9, 1);
        LocalDate currentDate = startDate;
        for (int i = 0; i < 121; i++) {
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
            courseAttendanceArray[i][0] = formattedDate;
            courseAttendanceArray[i][1] = courseName; 
            courseAttendanceArray[i][2]="";
            currentDate = currentDate.plusDays(1); // Move to the next day
            date[0]="Select Date";
            date[i+1]=courseAttendanceArray[i][0];
        }

                    }
    public void  showAttendanceRecord(){
        for (String[] row : courseAttendanceArray) {
            System.out.println("Date: " + row[0] + ", Course: " + row[1]+" Attendace: "+row[2]);
        }
    }
  /*   Lets design fucntion for demo only i.e Sample Filling */

    


    /* ...................... */
    public Course(){
        courseName="";
        iniatilizeAttendanceRecord();
    }
     public Course(String n,int ch){
        this.courseName=n;
        this.courseCreditHour=ch;
        iniatilizeAttendanceRecord();
    }
    public Course(String n,int ch,int sem,String techer){
        this.courseName=n;
        this.courseCreditHour=ch;
        this.courseSemester=sem;
        this.courseInstructor=techer;
        iniatilizeAttendanceRecord();
    }
    public String toString(){
        return courseName;
    }
    
}
