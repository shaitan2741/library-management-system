package lib;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Writer extends Book{
    
	
	static String Path ="newuser.txt";
    
    public static void writeNewUser(UserRecord ur) throws IOException {
        try{
            FileWriter fw = new FileWriter(Path,true);
            String Line = ur.UserName+","+ur.Password+","+ur.MobileNo+"\r\n";
            fw.write(Line, 0, Line.length());
            fw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
    }
}