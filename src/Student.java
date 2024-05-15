import javax.swing.*;
import java.awt.*;
 class Student extends User { 
    public static int studentCount;
    public String degProgram;
    public String batch;
    public Student() {
        userRole = "Student"; 
    }
    //necessary informatin of Student
    public Student(String n,String pwd,String deg){
        
        super(n,pwd);
        this.degProgram=deg;
        
}
public Student(String n,String pwd,String deg,String batch){
        
    super(n,pwd);
    this.degProgram=deg;
    this.batch=batch;
}

public Student(String n,String pwd){
    super(n,pwd);
    
}
public void showName(){
    App.showmessage(this.userName);
}

}
