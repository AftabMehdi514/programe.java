public class Teacher extends User {
    public static int teacherCount;
    private String department;
    Course[] courses;
    public Teacher(String n,String pwd){
        super(n,pwd);
        
    };
    public Teacher(String m,String pwd,String deg){
        super(m, pwd);
        this.department=deg;
    }
}
