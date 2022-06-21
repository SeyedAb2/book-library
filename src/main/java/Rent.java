import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Rent extends File implements Library,Serializable {

    private Book book;
    private Member member;
    private String date;

    public Rent(Book book, Member member, String date) {
        this.book = book;
        this.member = member;
        this.date = date;
    }
    public static Rent getRent(String date) {
        Rent rent = null;
        for (Rent RentDetail : Rents) {
            if (Objects.equals(RentDetail.getDate(), date)) {
                rent = RentDetail;
                break;
            }
        }
        return rent;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String  date) {
        this.date = date;
    }
    public static void addRent() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter book id: -> ");
            String ID_BOOK = input.nextLine();
            Book book = Book.getBook(Integer.parseInt(ID_BOOK));

            System.out.print("Enter member id: -> ");
            String ID_MEMBER = input.nextLine();
            Member member = Member.getMember(Integer.parseInt(ID_MEMBER));
            System.out.print("Enter date: -> ");
            String date = input.nextLine();
            book.setBorrowBook(true);
            Rent rent = new Rent(book, member, date);
            rent.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void remove() {
        File.remove(this);
    }
    public void insert() {
        try {
            FileOutputStream File_output = new FileOutputStream(rent_url);
            ObjectOutputStream Object_output = new ObjectOutputStream(File_output);
            for (Rent rentItem : Rents) {
                Object_output.writeObject(rentItem);
            }
            Object_output.close();
            System.out.println("");
        } catch (IOException ex) {
            System.out.print("");
        }
    }
    public static void select() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(rent_url));) {
            while (true) {
                Rent rentItem = (Rent) input.readObject();
                Rents.add(rentItem);
            }
        } catch (EOFException e) {
            System.out.println("");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }
    }
    public void save() {
        File.save(this);
    }
    public static void show() {
        for (Rent rent : Rents) {
            System.out.println(rent.toString());
        }
    }
    @Override
    public String toString() {
        return "[ " + getBook().toString() + " , " + getMember().toString() + " , " + getDate() + " ]";
    }
}
