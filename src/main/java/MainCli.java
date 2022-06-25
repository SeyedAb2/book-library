import java.util.Scanner;

public class MainCli {
    Scanner cli = new Scanner(System.in);
    public void menu(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  menu description  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Add Manager       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Add Member        |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Add Book          |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Add Rent          |");
        System.out.println("+----+--------------------+");
        System.out.println("| 5  |  show Manager      |");
        System.out.println("+----+--------------------+");
        System.out.println("| 6  |  show Member       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 7  |  show book         |");
        System.out.println("+----+--------------------+");
        System.out.println("| 8  |  show Rent         |");
        System.out.println("+----+--------------------+");
        System.out.println("| 9  |  remove Manager    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 10 |  remove Member     |");
        System.out.println("+----+--------------------+");
        System.out.println("| 11 |  remove Book       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 12 |  remove Rent       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 13 |  exit              |");
        System.out.println("+----+--------------------+");
        System.out.println("Please Select Menu option");
        System.out.print("Command> ");
    }
    public void run(){
        System.out.println("Welcome to Your Library");
        System.out.println("We hope you enjoy being here");
        System.out.println("What are you going to do? Just choose an item");
        try {
            while (true){
                menu();
                int input = cli.nextInt();
                if (input==1) {
                    Manager.addManager();
                } else if(input==2) {
                    Member.addMember() ;
                } else if(input==3) {
                    Book.addBook();
                } else if(input==4) {
                    Rent.addRent();
                } else if(input==5) {
                    Manager.show();
                } else if(input==6) {
                    Member.show();
                } else if(input==7) {
                    Book.show();
                } else if(input==8) {
                    JavaSQL.select_book();
                    JavaSQL.select_book();
                    Rent.show();
                } else if(input==9) {
                    JavaSQL.select_manager();
                    System.out.print("Enter manager nationalCode: -> ");
                    int v = cli.nextInt();
                    Manager manager = Manager.getManager(v);
                    manager.remove();
                } else if(input==10) {
                    JavaSQL.select_member();
                    System.out.print("Enter member nationalCode: -> ");
                    int b = cli.nextInt();
                    Member member= Member.getMember(b);
                    member.remove();
                } else if(input==11) {
                    JavaSQL.select_book();
                    System.out.print("Enter id: -> ");
                    int o= cli.nextInt();
                    Book book= Book.getBook(o);
                    book.remove();
                } else if(input==12) {
                    JavaSQL.select_rent();
                    System.out.print("Enter date: -> ");
                    int q = cli.nextInt();
                    Rent rent= Rent.getRent(q);
                    rent.remove();
                } else if(input==13) {
                    System.exit(0);
                } else {
                    System.out.print("invalid option");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        new MainCli().run();
    }
}
