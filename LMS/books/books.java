package books;
//import java.time.LocalDate;
public class books{
    int bookid;
    String bookName;
    String Author;
    String Genre;
   
    
    public books(int bookid, String bookName, String author, String genre) {
        this.bookid = bookid;
        this.bookName = bookName;
        Author = author;
        Genre = genre;
    }
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }

    public String toString(){
        return "ID: " + bookid + ", Name: " + bookName +
                ", Author: " + Author + ", Genre: " + Genre;
    }
    
    // public String toString() {
    // return String.format(
    //     "%-6d %-20s %-18s %-20s",
    //     bookid, bookName, Author, Genre
    // );
}

