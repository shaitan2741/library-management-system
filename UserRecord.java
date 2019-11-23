package lib;

public class UserRecord{
    public String UserName;
    public String Password;
    public long MobileNo;

    public UserRecord(String UserName,String Password,long MobileNo){
        this.UserName = UserName;
        this.Password = Password;
        this.MobileNo = MobileNo;
    }

    public void printUserRecord(){
        System.out.println("UserName: "+UserName+"Password: "+Password);
        System.out.println("MobileNo: "+MobileNo);
    }
}