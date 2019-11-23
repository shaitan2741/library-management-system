package lib;

public class bookrecord {

	public String title;
    public String author;
    public String publisher;
    public String publicationYear;
    

    public bookrecord(String title,String author,String publisher,String publicationYear){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear=publicationYear;
        
    }

   

	/*public void printUserRecord(){
        System.out.println("title: "+title+"author: "+author+"publisher:"+publisher);
        System.out.println("publication year: "+publicationYear);
    }*/
}
