public class User {
    public String userName,userPassword;
    protected String userRole;
    protected User(){}
    public User(String n,String pwd){
        this.userName=n;
        this.userPassword=pwd;
    }
}
