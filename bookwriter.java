package lib;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class bookwriter {
	
static String Path ="newbook.txt";
    
    public static void writeNewBook(bookrecord br) throws IOException {
        try{
            FileWriter fw = new FileWriter(Path,true);
            String Line = br.title+","+br.author+","+br.publisher+","+br.publicationYear+"\r\n";
            fw.write(Line, 0, Line.length());
            fw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
    }

}
