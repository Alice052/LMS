package management;

import books.books;


//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import log.Logger;


public class management {
    Logger logger = new Logger("system_log.txt");
    public ArrayList <books> gedajasto;   //creating gedajasto arraylist which holds all objects of books

public management(Logger logger) {
        gedajasto = new ArrayList<>();  
    }

// public management(Logger logger) {
//     //TODO Auto-generated constructor stub
// }

public void addBook(books b){
    gedajasto.add(b);
    System.out.println("addition successful");
    //logger.log("book added successfully");
    logger.log (""+b);
    saveCurrentState();
    //logger.append(b)
}

public boolean deleteBook(int tobedeletedid) {

    books bookToRemove = null;

    for (books b : gedajasto) {
        if (b.getBookid() == tobedeletedid) {  //findind if there is any book that can be removed
            bookToRemove = b;
            break;
        }
    }

    if (bookToRemove != null) {
        gedajasto.remove(bookToRemove);  //actual deletion process
        logger.log("Book removed: " + bookToRemove); //book remove matra gareko, file rewrite haina
        saveCurrentState();  
        return true;
    }

    return false;
}



public void saveCurrentState() { //remove bhako book bahek ko record save garcha; file rewrite

    //System.out.println("saveCurrentState() CALLED");
   // System.out.println("Writing to: " + new File("system_log.txt").getAbsolutePath());

    try (PrintWriter writer = new PrintWriter(new FileWriter("system_log.txt"))) {

         writer.printf(
            "%-10s %-30s %-22s %-20s%n",
            "ID", "Name", "Author", "Genre"  
        );  

        for (books b : gedajasto) {
            writer.printf(
        "%-10s %-30s %-22s %-20s%n",
                b.getBookid(),
                b.getBookName(),
                b.getAuthor(),
                b.getGenre() );
        }

    } catch (IOException e) {
        System.out.println("Could not update file");
    }
}



public books searchBooks(int searchingID){
    for(books b: gedajasto){
        if(b.getBookid() == searchingID){
            return b;
        }
    }
    return null;
}

public void show(){
    if (gedajasto.isEmpty()){
        System.out.println("kei chaina mug");
    }
    for (books b : gedajasto){
        System.out.println(b);
    }
}
}
