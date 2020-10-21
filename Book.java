package lib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {





public String Name;
	public String Star;
    public String title;
    public String author;
    public String publisher;
    public String publicationYear;
    public String status;
    public String borrower;
    public String borrowDate;
    public String returnDate;
    public String name;
    public int k;
    static Scanner sc1=new Scanner(System.in);
    
    public String status1 = "Available";
    public String status2 = "Borrowed";
    public int BookChoice;
    public int returnchoice;
    
    static Scanner pls=new Scanner(System.in);
    


    static ArrayList<String> UserList = new ArrayList<String>();
    static ArrayList<Book> BookList = new ArrayList<Book>();

    static int choice ;

    static Scanner userInput = new Scanner(System.in);
    static Scanner choiceInput = new Scanner(System.in);
	private Scanner t1;
    /*
     * Book Constructor:
     */
	private Scanner x;
	//private Scanner lib;
	

    public static void displayFirstMenu(){
        System.out.println(">########################################################################");
        System.out.println("> Choose one of the options below by typing the corresponding number: ");
        System.out.println(">====================================================================");
        System.out.println("2- Add a book to the Library.");
        System.out.println("6- Blow up library.");
        System.out.println("7- Back to main menu.");
        System.out.println("0- Exit.");
        System.out.println(">########################################################################");
        System.out.println("> Enter your option here: ");
        choice = choiceInput.nextInt();

    }

    public static void displaySecondMenu(){
        System.out.println(">########################################################################");
        System.out.println("> Choose one of the options below by typing the corresponding number: ");
        System.out.println(">====================================================================");
        System.out.println("1- Check library list.");
        System.out.println("2- Add a book to the Library.");
        System.out.println("3- Borrow a book.");
        System.out.println("4- Return a book.");
       
       // System.out.println("6- Blow up library.");
        System.out.println("7- Back to main menu.");
        
        System.out.println("0- Exit.");
        System.out.println(">########################################################################");
        System.out.println("> Enter your option here: ");
        choice = choiceInput.nextInt();

    }

    public String displayBook(){

        String BookInfo = "----------------------------"+
                "\nTitle:.................."+title+
                "\nAuthor:................."+author+
                "\nPublisher:.............."+publisher+
                "\nPublicationYear:........"+publicationYear+
                "\nStatus:................."+status+
                "\nBorrower:..............."+borrower+
                "\nDate Borrowed:.........."+borrowDate+
                "\nReturn date:............"+returnDate+
                "\n----------------------------";
       // fw.write(Lane);
        //fw.close();
        return BookInfo;
    }

    public void createBook() throws IOException{
        System.out.println("> Enter the title of the book: ");
        title = userInput.nextLine();

        System.out.println("> Enter the author of the book: ");
        author = userInput.nextLine();

        System.out.println("> Enter the publisher of the book: ");
        publisher = userInput.nextLine();

        System.out.println("> Enter the publication year of the book: ");
        publicationYear = userInput.nextLine();

        borrower = "nobody";
        borrowDate = "none";
        returnDate = "none";

        status = "Available";
       bookrecord br = new bookrecord(title, author, publisher , publicationYear);
        bookwriter.writeNewBook(br);
        return;
    }

    public void addBook(){
        Book newBook = new Book(); 
        try {
			newBook.createBook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BookList.add(newBook);
        System.out.println("---------------------------------------------------------");
        System.out.println("> You have successfully added the book to the library!\n");
        System.out.println("---------------------------------------------------------");
    }

    public void displayBookList(){
        if (BookList.size() == 0){
            System.out.println(">-------------------------------------------------------------");
            System.out.println("> There Library is Emply! Please add a book first!\n");
            System.out.println(">-------------------------------------------------------------");
            Book.displayFirstMenu();
            choice = choiceInput.nextInt();
            k=sc1.nextInt();
            

        } else {
            for (int i = 0; i < BookList.size(); i++){
                System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n",i+1);
                System.out.println(BookList.get(i).displayBook());
                System.out.println(">-------------------------------------------------------------");
            }
        }
    }

    public void borrowBook() throws IOException{
        System.out.println("---------------------------------------------------------");
        System.out.println("> Here are all the books registered in the library: ");
        System.out.println("---------------------------------------------------------");
        displayBookList();

        borrowLoop1:
        while(choice == 3){
            System.out.println("\n\n> Choose an available book from the above list and write down it's index number: ");
            BookChoice = choiceInput.nextInt()-1;//register user's book choice.
            if(BookChoice > BookList.size()){
                System.out.println("> The number of the book you entered is not in the list!");
                choice = 7;
            }else if(BookChoice <= BookList.size()){
                break borrowLoop1;
            }
        }

        borrowLoop2:
        while(choice == 3){
            
            if (BookList.get(BookChoice).status.equalsIgnoreCase(status1) && BookList.size() >= BookChoice){
                
                BookList.get(BookChoice).status = "Borrowed";
                System.out.printf("\n> You have chosen the following book: %s\n", BookList.get(BookChoice).displayBook());

                
                BookList.get(BookChoice).borrower = borrower;
                BookList.get(BookChoice).borrowDate = "Today.";
                BookList.get(BookChoice).returnDate = "In two weeks.";
               
				
                System.out.println("> You have to return the book in two weeks!");
                issuedrecord ir = new issuedrecord(borrower,BookList.get(BookChoice).title);
               issuedbook.issuedbookrecordwriter(ir);
               
                choice = 7;
                break borrowLoop2;

            }else if(BookList.get(BookChoice).status.equalsIgnoreCase(status2) && BookList.size() >= BookChoice){
                System.out.println("> The Book you are trying to borrow is unavailable!");
                choice = 7;
                break borrowLoop2;
            }else if(BookChoice > BookList.size()-1){
                System.out.println("> The number you entered in not in the list!");
                choice = 7;
                break borrowLoop2;
            }
        }
    }


    public void returnBook() throws IOException{
      
    	System.out.println("############## RETURN COUNTER #################");
    	
    	bookLoop1:
    		while(choice == 4)
    		{
    			System.out.println("please enter the index no of the book that you have to return");
    			returnchoice=pls.nextInt()-1;
    			 if(returnchoice > BookList.size()){
    	                System.out.println("> The number of the book you entered is not in the list!");
    	                choice = 7;
    	            }else if(returnchoice <= BookList.size()){
    	                break bookLoop1;
    	            }
    		}
    	
    	
    	bookLoop2:
    	
    		while(choice == 4){
                
                if (BookList.get(returnchoice).status.equalsIgnoreCase(status2) && BookList.size() >= returnchoice){
                    
                    BookList.get(returnchoice).status = "Available";
                    System.out.printf("\n> You have chosen the following book: %s\n", BookList.get(returnchoice).displayBook());

                    
                    BookList.get(returnchoice).borrower = null;
                    BookList.get(returnchoice).borrowDate = "none";
                    BookList.get(returnchoice).returnDate = "none";
                   
    				
                    System.out.println("> You have successfully returned the book!");
               
                   
                    choice = 7;
                    break bookLoop2;

                }else if(BookList.get(returnchoice).status.equalsIgnoreCase(status1) && BookList.size() >= returnchoice){
                    System.out.println("> The Book you are trying to return is inadequate");
                    choice = 7;
                    break bookLoop2;
                }else if(returnchoice > BookList.size()-1){
                    System.out.println("> The number you entered in not in the list!");
                    choice = 7;
                    break bookLoop2;
                }
            }
    	
    }


   

    public void emptyLibrary(){
        System.out.println("> WARNING < You have chosen to delete all books in the library! ");
        System.out.println("> Are you sure?? Enter yes or no: ");
        String confirmation = userInput.nextLine();
        try{
            if(confirmation.equalsIgnoreCase("yes")){
                System.out.println("> Library is being deleted...");
                BookList.clear();
                System.out.println("> Library is Empty!");
                choice = 7;
            }
            else
            {
            	System.out.println("You have decided to take a step back! ");
            	choice=7;
            	
            	
            }
        }catch(InputMismatchException error){
            System.out.println("<ERROR> Make sure you spell yes or no correctrly: ");
            choice = 6;
        }
    }

    public void addUser() throws IOException{
    	int ch;
    	
    	
        System.out.println(">choose the following options ");
        System.out.println("1.New user ");
        System.out.println("2.Existing user ");
        
        t1 = new Scanner(System.in);
        x = new Scanner(System.in);
        
        ch=t1.nextInt();
        
        if(ch==1)
        {
        	 System.out.println("Enter Username: ");
        	 borrower = userInput.nextLine();
             UserList.add(borrower);
             String UserName = borrower;
             
             System.out.println("Enter Password: ");
             
             String Password = x.nextLine();
             
             System.out.println("Enter Mobile Number: ");
             long MobileNo = t1.nextLong();
             UserRecord ur = new UserRecord(UserName, Password, MobileNo);
             Writer.writeNewUser(ur);
             return;
        	
        }
        else {
        	 System.out.println("Enter Username: ");
        	
           String UserName= x.nextLine();
             
             
             if(FindInFile.findUserName(UserName)){
            	 borrower=UserName;
            	 
                 System.out.println("Enter Password: ");
                 String Password = x.nextLine();
                 if(FindInFile.matchPassword(UserName, Password)){
                     return;
                 }
                 else{
                     System.out.println("Incorrect Password");
                     throw new IOException();
                 }
             }
             else{
                 System.out.println("User Not Found");
                 throw new IOException();
                 
             }
         }
        	
        }
       	
    
   public void yes() 
   {
	   int k;
	  
	   System.out.println("");
	   
	   System.out.println("###############################################");
	   
	   System.out.println("PLEASE ENTER THE NAME OF THE CURRENT LIBRARIAN AVAILABLE..");
   		String mr = sc1.nextLine();
   		System.out.println("HELLO "+mr);
   		
   	
    while(true)
   	{
   		System.out.println("> " +mr+ " Please Choose one of the following options by typeing the corresponding number.");
   		
   		System.out.println("2.Add a book to the library");
   		System.out.println("6.delete all the books from library");
   		
   		System.out.println("9.IF YOU ARE DONE , THEN START REGISTERING THE STUDENTS");
   		System.out.println("0.Exit");
   		
   		k=sc1.nextInt();
   		
   		
   		switch(k)
   		{
   			
   			case 2:
   			{
   				addBook();
   				break;
   				
   			}
   			case 6:
   			{
   				emptyLibrary();
   				break;
   				
   			}
   			case 0:
   			{
   				System.out.println("Mr/Mrs. " +mr+ " have exited the library!!!!!!!!!!");
   				
   				return;
   				
   			}
   			case 9:
   			{
   				try {
					run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   				
   			}
   		}
   	}

   }

    public  void run() throws IOException{
    	
    	
    
        System.out.println("@TEST@ <<< 1 >>>>");

        addUser();
        System.out.println("@TEST@ <<< 2 >>>>");

        Book.displaySecondMenu();//Displays the main menu and ask for choice.

        System.out.println("@TEST@ <<< 3>>>>");

        exit:

        while(choice != 0){
            try{
//Choice 1:
                if(choice == 1 && BookList.size() > 0){

                    displayBookList();
                    choice = 7;
                }

                if(choice == 1 && BookList.size() == 0){
                    System.out.println("<ERROR> Library is empty! Please add a Book first!");
                    choice = 7;
                }

                if(choice == 2){
                    //createBook();
                    addBook();
                    displaySecondMenu();
                }

                if(choice == 3){
                    if(BookList.size() > 0){
                        borrowBook();
                    }
                }

                if(choice == 4){
                    returnBook();
                    
                    
                }
                
               // if(choice == 6){
                   // emptyLibrary();
                //}

                if(choice == 7){
                    if(BookList.size() > 0){
                        displaySecondMenu();
                    }else if(BookList.size() == 0){
                        displayFirstMenu();
                    }
                }
                if(choice == 0){
                    break exit;
                }
            }catch(InputMismatchException error){
                System.out.println("@TEST@ <<< 5- Breaking from main while loop... >>>>");
                break exit;
            }
        }

        System.out.println("#### Student name:"+borrower+ " have Exited the Library Portal!  ####");
        System.out.println("===========================================================");
    }

    public static void main(String[] args){

        System.out.println("> Welcome to the library!");
       
        
        Book newBook = new Book();
        try {
			newBook.yes();
			//File file=new File(issuedbook.txt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
      
    }

}


