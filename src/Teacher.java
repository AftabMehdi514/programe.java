public class Teacher extends User {
    public String department;
    public String email;
    public String contactNo;
    Course[] courses;
    public Teacher(){};
    public Teacher(String n,String pwd){
        super(n,pwd);
        
    };
    public Teacher(String m,String pwd,String deg){
        super(m, pwd);
        this.department=deg;
    }
    public Teacher(String n,String e,String no,String d,String p){
        this.userName=n;
        this.email=e;
        this.contactNo=no;
        this.department=d;
        this.userPassword=p;
}
 
}
