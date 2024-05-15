public class Course {
    private String courseName;
    private int courseCreditHour;
    private int courseSemester;
    private String courseInstructor;
    public Course(){}
    public Course(String n,int ch,int sem,String techer){
        this.courseName=n;
        this.courseCreditHour=ch;
        this.courseSemester=sem;
        this.courseInstructor=techer;
    }
    
}
