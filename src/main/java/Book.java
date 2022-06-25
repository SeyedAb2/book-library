
import java.io.*;
import java.util.Scanner;

public class Book extends File implements Library,Serializable {

    private int Book_id;
    private String bookName;
    private String writer;
    private boolean borrowStatus = false;
    private static int const_id = 1;

    public Book(String bookName, String writer, boolean borrowStatus) {
        this.bookName = bookName;
        this.writer = writer;
        this.Book_id = const_id;
        this.borrowStatus = borrowStatus;
        const_id++;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return writer;
    }
    public void setAuthor(String writer) {
        this.writer = writer;
    }
    public int getBook_id() {
        return Book_id;
    }
    public void setBook_id(int book_id) {
        Book_id = book_id;
    }
    public void setBorrowBook(boolean borrow) {
        this.borrowStatus = borrow;
    }
    public boolean isBorrowBook() {
        return borrowStatus;
    }
    public static Book getBook(int book_id) {
        Book book = null;
        for (Book bookItem : Books) {
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
            String Writer_name = input.nextLine();
            Book book = new Book(book_name, Writer_name, false);
            book.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void insert() {
        try {
            FileOutputStream file_output = new FileOutputStream(book_url);
            ObjectOutputStream object_output = new ObjectOutputStream(file_output);
            for (Book book : Books) {
                object_output.writeObject(book);
            }
            object_output.close();
            System.out.println("file updated");
        } catch (IOException ex) {
            System.out.print("");
        }
    }
    public void remove() {
        File.remove(this);
    }
    public static void select() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(book_url))) {
            while (true) {
                Book book = (Book) input.readObject();
                Books.add(book);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("");
        }
        finally {
            if (Books.size()!=0){
                int num = Books.size()-1;
                Book.const_id = Books.get(num).Book_id+1;
            }
        }
    }
    public void save() {
        File.save(this);
    }
    public static void show() {
        for (Book book : Books) {
            System.out.println(book.toString());
        }
    }
    @Override
    public String toString() {
        return "{ book :" + getBookName() + " , writer : " + getAuthor() + " , id : " + getBook_id() + " }";

    }
}
