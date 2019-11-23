package lib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindInFile{
    static String Path = "ok.txt";
	private static BufferedReader br;
	private static BufferedReader br2;
    public static boolean findUserName(String UserName) throws IOException {
        try{
            FileReader fr = new FileReader(Path);
            br = new BufferedReader(fr);
            String line;
            
            line = br.readLine();
            while(line!=null){
                String arr[] = line.split(",");
                if(UserName.equals(arr[0]))
                    return true;
                line = br.readLine();
            }

            return false;
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            return false;
        }
    }

    public static boolean matchPassword(String UserName,String Password) throws IOException {
        try{
            FileReader fr = new FileReader(Path);
            br2 = new BufferedReader(fr);
            String line = br2.readLine();
            line = br2.readLine();
            while(line!=null){
                String arr[] = line.split(",");
                if(UserName.equals(arr[0]) && Password.equals(arr[1]))
                    return true;
                line = br2.readLine();
            }

            return false;
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            return false;
        }
    }
}