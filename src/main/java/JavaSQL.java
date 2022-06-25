import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaSQL {

    static ArrayList<Manager> Managers = new ArrayList<>();
    static ArrayList<Member> Members = new ArrayList<>();
    static ArrayList<Book> Books = new ArrayList<>();
    static ArrayList<Rent> Rents = new ArrayList<>();
    public static String DriverName = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/javalibrary?user=root";

    /**
     *
     * @param manager
     * insert new manger
     **/
    public static void save(Manager manager) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "INSERT INTO manager(name , national_code) VALUES ('%s',%s)";
            query = String.format(query,manager.getEntityName(),manager.getEntityNationalCode());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("manager successful is added");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param member
     * insert new member
     **/
    public static void save(Member member) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "INSERT INTO member(name , national_code) VALUES ('%s',%s)";
            query = String.format(query,member.getEntityName(),member.getEntityNationalCode());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("member successful is added");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param book
     * insert new book
     **/
    public static void save(Book book) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "INSERT INTO book(name , author) VALUES ('%s','%s')";
            query = String.format(query,book.getBookName(),book.getAuthor());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("book successful is added");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param rent
     * insert new rent
     **/
    public static void save(Rent rent) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "INSERT INTO rent(book_id , member_id,date) VALUES (%s,%s,%s)";
//            query = String.format(query,rent.getBook().getBook_id(),rent.getMember().getMember_id(), rent.getDate());
            query = String.format(query,rent.getBook().getBook_id(),rent.getMember().getMember_id(), rent.getDate());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("book successful is rented");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param manager
     * delete manager from manager table by nationalCode
     **/
    public static void remove(Manager manager) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "DELETE FROM manager WHERE national_code = (%s)";
            query = String.format(query,manager.getEntityNationalCode());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("manager is removed");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param member
     * delete member from member table by nationalCode
     **/
    public static void remove(Member member) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "DELETE FROM member WHERE national_code = (%s)";
            query = String.format(query,member.getEntityNationalCode());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("member is removed");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param book
     * delete book from book table by id
     **/
    public static void remove(Book book) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "DELETE FROM book WHERE id = (%s)";
            query = String.format(query,book.getBook_id());
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("book is removed");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @param rent
     * delete rent from rent table by id
     **/
    public static void remove(Rent rent) {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "DELETE FROM rent WHERE date = (%s)";
            query = String.format(query,Integer.parseInt(rent.getDate()));
            state.execute(query);
            state.close();
            connect.close();
            System.out.println("rent is removed");
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    /**
     * select mangers
     **/
    public static void select_manager() {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "SELECT * FROM manager";
            ResultSet res = state.executeQuery(query);
            ArrayList<Manager> cloneManagers = new ArrayList<>();
            while (res.next()){
                String id = res.getString(1);
                String name = res.getString(2);
                String national_code = res.getString(3);
                cloneManagers.add(
                        new Manager(name,Integer.parseInt(national_code))
                );
            }
            Managers = (ArrayList<Manager>) cloneManagers.clone();
            state.close();
            connect.close();
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     * select members
     **/
    public static void select_member() {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "SELECT * FROM member";
            ResultSet res = state.executeQuery(query);
            ArrayList<Member> cloneMember = new ArrayList<>();
            while (res.next()){
                String id = res.getString(1);
                String name = res.getString(2);
                String national_code = res.getString(3);
                cloneMember.add(
                        new Member(Integer.parseInt(id),name,Integer.parseInt(national_code))
                );
            }
            Members = (ArrayList<Member>) cloneMember.clone();
            state.close();
            connect.close();
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     * select book
     **/
    public static void select_book() {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "SELECT * FROM book";
            ResultSet res = state.executeQuery(query);
            ArrayList<Book> cloneBook = new ArrayList<>();
            while (res.next()){
                String id = res.getString(1);
                String name = res.getString(2);
                String author = res.getString(3);
                cloneBook.add(
                        new Book(Integer.parseInt(id),name,author)
                );
            }
            Books = (ArrayList<Book>) cloneBook.clone();
            state.close();
            connect.close();
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    /**
     * select rent
     **/
    public static void select_rent() {
        try{
            Class.forName(DriverName).newInstance();
            Connection connect = DriverManager.getConnection(url);
            Statement state = connect.createStatement();
            String query = "SELECT * FROM rent";
            ResultSet res = state.executeQuery(query);
            ArrayList<Rent> cloneRent = new ArrayList<>();
            while (res.next()){
                String id = res.getString(1);
                String book_id = res.getString(2);
                String member_id = res.getString(3);
                String date = res.getString(4);
                cloneRent.add(
                        new Rent(
                                Book.getBook(Integer.parseInt(book_id)),
                                Member.getMemberById(Integer.parseInt(member_id))
                                ,date
                        )
                );
            }
            Rents = (ArrayList<Rent>) cloneRent.clone();
            state.close();
            connect.close();
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
