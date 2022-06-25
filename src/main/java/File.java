import java.util.ArrayList;

public class File {
    static String Base_url = "E:\\programming\\";
    static String manager_url = Base_url + "Manager.txt";
    static String rent_url = Base_url + "Rent.txt";
    static String member_url = Base_url + "Member.txt";
    static String book_url = Base_url + "Book.txt";
    static ArrayList<Manager> Managers = new ArrayList<>();
    static ArrayList<Member> Members = new ArrayList<>();
    static ArrayList<Book> Books = new ArrayList<>();
    static ArrayList<Rent> Rents = new ArrayList<>();

    public static void save(Manager manager) {
        Managers.add(manager);
    }
    public static void save(Member member) {
        Members.add(member);
//        member.insert();
    }
    public static void save(Book book) {
        Books.add(book);
//        book.insert();
    }
    public static void save(Rent rent) {
        Rents.add(rent);
//        rent.insert();
    }
    public static void remove(Manager manager) {
        Managers.remove(manager);
//        manager.write();
    }
    public static void remove(Member member) {
        Members.remove(member);
//        member.insert();
        for (Rent rent: Rents){
            if (rent.getMember().equals(member))
                Rent.remove(rent);
        }
    }
    public static void remove(Book book) {
        Books.remove(book);
//        book.insert();
        for (Rent rent: Rents){
            if (rent.getBook().equals(book))
            {
                Rent.remove(rent);
            }
        }
    }
    public static void remove(Rent rent) {
        Rents.remove(rent);
//        rent.insert();
    }
}