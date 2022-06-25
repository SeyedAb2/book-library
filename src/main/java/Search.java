import java.util.Scanner;

public class Search{
    private String search_key;
    public static String show_result;

    public Search(String search_key) {
        this.search_key = search_key;
    }
    public String getShow_result() {
        return show_result;
    }

    public void setShow_result(String show_result) {
        Search.show_result = show_result;
    }

    public String getSearch_key() {
        return search_key;
    }

    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }
    public static void searchRequest(int num) {
        Scanner inputName = new Scanner(System.in);
        try {
            if (num==1){
                JavaSQL.select_manager();
                System.out.print("Enter Manager National Code : -> ");
                String nationalCode = inputName.nextLine();
                Manager search_manager = Manager.getManager(Integer.parseInt(nationalCode));
                show_result = search_manager.toString();
                System.out.println(show_result);
            }
            else if(num==2){
                JavaSQL.select_member();
                System.out.print("Enter Member National Code : -> ");
                String nationalCode = inputName.nextLine();
                Member search_member = Member.getMember(Integer.parseInt(nationalCode));
                show_result = search_member.toString();
                System.out.println(show_result);
            }
            else if(num==3){
                JavaSQL.select_book();
                System.out.print("Enter Book Name : -> ");
                String name = inputName.nextLine();
                Book search_book = Book.getBookByName(name);
                show_result = search_book.toString();
                System.out.println(show_result);
            }
            else if(num==4){
                JavaSQL.select_book();
                JavaSQL.select_member();
                JavaSQL.select_rent();
                System.out.print("Enter Date Rent Number : -> ");
                String date = inputName.nextLine();
                Rent search_rent = Rent.getRent(date);
                show_result = search_rent.toString();
                System.out.println(show_result);
            }
            else {
                System.out.println("Invalid Option");
            }
        } catch (Exception e) {
            System.out.println("results not found :( ");
        }
    }
}
