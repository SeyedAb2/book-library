import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Rent extends File implements Library,Serializable {

    private Book book;
    private Member member;
    private String date;
    static int b;
    static int m;
    public Rent(Book book, Member member, String date) {

        this.book = book;
        this.member = member;
        this.date = date;
    }
    public static Rent getRent(int date) {
        Rent rent = null;
        for (Rent RentDetail : JavaSQL.Rents) {
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
    public int getDate() {
        return date;
    }
    public void setDate(int  date) {
        this.date = date;
    }
    public static void addRent() {
        JavaSQL.select_book();
        JavaSQL.select_member();
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter book id: -> ");
            String ID_BOOK = input.nextLine();
            Book book = Book.getBook(Integer.parseInt(ID_BOOK));
            System.out.print("Enter member National Code: -> ");
            String ID_MEMBER = input.nextLine();
            Member member = Member.getMember(Integer.parseInt(ID_MEMBER));
//            System.out.println(member);
//            System.out.println(member.toString());
            System.out.print("Enter date: -> ");
            String date = input.nextLine();
            Rent rent = new Rent(book,member,date);
            rent.save();
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
        JavaSQL.select_rent();
        for (Rent rent : JavaSQL.Rents) {
            System.out.println(rent.toString());
        }
    }
    @Override
    public String toString() {
        return "[ " + getBook().toString() + " , " + getMember().toString() + " , date : " + getDate() + " ]";
    }
}
