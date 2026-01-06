package main;
import java.util.Scanner;
import log.Logger;
//import java.util.logging.Logger;
//import src.management.management;
//import java.util.logging.Logger;
import management.management;
import books.books;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Logger logger = new Logger("system_log.txt");

        management libmanagement =  new management(logger);


        while (true){
            System.out.println("\n ----welcome to library---");
            System.out.println("1. Add Btudent");
            System.out.println("2. Remove Books");
            System.out.println("3. Search Boook");
            System.out.println("4. display book");

            int select = scanner.nextInt();

            if (select == 1) {
                System.out.println("enter book id: ");
                int bookid = scanner.nextInt();
                scanner.nextLine();

                System.out.println("enter book name");
                String bookName = scanner.nextLine();

                System.out.println("enter author's name");
                String Author = scanner.nextLine();

                System.out.println("enter the book's genre");
                String Genre = scanner.nextLine();

                books puatak = new books(bookid, bookName, Author, Genre);
                libmanagement.addBook(puatak);


            } else if ( select == 2) { 
                System.out.println("enter bookid to remove book: ");
                int tobedeletedid = scanner.nextInt();

                    if (libmanagement.deleteBook(tobedeletedid)) {
                        System.out.println("book deleted successfully ");
                    } else {
                        System.out.println("book not found ");
                    }
            } else if(select == 3){
                System.out.print("Enter bookID to search: ");
                    int searchId = scanner.nextInt();
                    books result = libmanagement.searchBooks(searchId);

                    if (result != null) {
                        System.out.println("Student Found:");
                        System.out.println(result);
                    } else {
                        System.out.println("Student not found!");
                    }
            
            
        }else if(select == 4){
            libmanagement.show();
        }else{
            System.out.println("invalid selection, try again ");
        }
        }
}
}
