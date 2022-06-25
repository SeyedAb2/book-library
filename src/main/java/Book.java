
import java.io.*;
import java.util.Scanner;

public class Book extends File implements Library,Serializable {

    private int Book_id;
    private String bookName;
    private String author;
    private static int const_id = 1;

    public Book(int primary_id,String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        this.Book_id = primary_id;
//        this.Book_id = const_id;
//        const_id++;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBook_id() {
        return Book_id;
    }
    public void setBook_id(int book_id) {
        Book_id = book_id;
    }
    public static Book getBook(int book_id) {
        Book book = null;
        for (Book bookItem : JavaSQL.Books) {
            if (bookItem.getBook_id() == book_id) {
                book = bookItem;
                break;
            }
        }
        return book;
    }
    public static void addBook() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter name: -> ");
            String book_name = input.nextLine();
            System.out.print("Enter author: -> ");
            String author_name = input.nextLine();
            Book book = new Book(const_id,book_name, author_name);
            book.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove() {
        JavaSQL.remove(this);
    }
    public void save() {
        JavaSQL.save(this);
    }
    public static void show() {
        JavaSQL.select_book();
        for (Book book : JavaSQL.Books) {
            System.out.println(book.toString());
        }
    }
    @Override
    public String toString() {
        return "{ book :" + getBookName() + " , author : " + getAuthor() + " , id : " + getBook_id() + " }";

    }
}
