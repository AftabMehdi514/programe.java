import javax.swing.*;
 class Student extends User { 
    public String degProgram;
    public String batch;
    public Course  courses[];
    public static Course  availableCourses[];
    public String firstName;
    public String lastName;
    public String dob;
    public String gender;
    public String email;
    public String phone;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String studentID;
    public String major;
    public double gpa;
    public String fatherName;
    public String motherName;
    public String emergencyContact;
    public JLabel image;
    public boolean paidDues;
    public Student() {
        userRole = "Student"; 
    }
    //necessary informatin of Student
    public Student(String n,String pwd,String deg){
        
        super(n,pwd);
        this.degProgram=deg;
        initializeCourses();
        initializeAvaiableCourses();
        
}
public Student(String n,String pwd,String deg,String batch,String e,String no){  
    super(n,pwd);
    this.degProgram=deg;
    this.batch=batch;
    paidDues=false;
    this.email=e;
    this.phone=no;
    initializeCourses();
    initializeAvaiableCourses();
}
public Student(String n,String pwd,String deg,String batch){  
    super(n,pwd);
    this.degProgram=deg;
    this.batch=batch;
    paidDues=false;
    initializeCourses();
    initializeAvaiableCourses();
}
public void sampleCourses(){
    for(int i=0;i<courses.length;i++){
        courses[0]=new Course("OOP", 2);
        courses[1]=new Course("DM", 2);
        courses[2]=new Course("Course 1", 2);
        courses[3]=new Course("Course 2", 2);
        courses[4]=new Course("Course 3", 2);
        courses[5]=new Course("Course 4", 2);
    }
}
public Student(String n,String pwd){
    super(n,pwd);
    paidDues=false;
    initializeAvaiableCourses();
    initializeCourses();
    
}
public void showName(){
    App.showmessage(this.userName);
}

public void initializeCourses(){
    courses=new Course[6];
    for(int i=0;i<courses.length;i++){
       courses[i]=new Course("Course"+i,1);
     }

}
/* for sample data filling only */
    public void fillAttendanceRecord(){
        for(int i=0;i<courses.length;i++){
            for(int j=0;j<courses[i].courseAttendanceArray.length;j++){
              courses[i].courseAttendanceArray[j][2]="Not Updated!";
               }
            
            }
        }
        
    
    public static void initializeAvaiableCourses(){
          availableCourses=new Course[6];
          availableCourses[0]=new Course("Select Course", 3);
          availableCourses[1]=new Course("OOP", 3);
          availableCourses[2]=new Course("DM", 2);
          availableCourses[3]=new Course("Course 1", 2);
          availableCourses[4]=new Course("Course 2", 2);
          availableCourses[5]=new Course("Course 3", 2);
    }

}
