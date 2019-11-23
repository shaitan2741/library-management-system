package lib;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class issuedbook {
	
     
		public static void issuedbookrecordwriter(issuedrecord ir) {
			String Path ="issuedbook.txt";
			
			try{
            FileWriter fw = new FileWriter(Path,true);
            String Line = ir.UserName+" has issued "+ir.title+"\r\n";
            String Lane="book has to be returned in two weeks";
            fw.write(Line, 0, Line.length());
            fw.write(Lane, 0, Lane.length());
            
            fw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
		
		public static void returnedbookrecordwriter(returnedbook kr)
		{
			String path="returnedbook.txt";
			try{
	            FileWriter fw = new FileWriter(path,true);
	            String Line = kr.UserName+" has returned "+kr.title+"\r\n";
	            String Lane="Thank you please come again";
	            fw.write(Line, 0, Line.length());
	            fw.write(Lane, 0, Lane.length());
	            
	            fw.close();
	        }
	        catch(FileNotFoundException e){
	            System.out.println("FILE NOT FOUND");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
   

	/*public void printUserRecord(){
        System.out.println("title: "+title+"author: "+author+"publisher:"+publisher);
        System.out.println("publication year: "+publicationYear);*/


