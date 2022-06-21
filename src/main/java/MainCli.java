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
        System.out.println("Welcome to your Library");
        System.out.println("We hope you enjoy being here");
        System.out.println("What are you going to do? Just choose an item");
        try {
            while (true){
                menu();
                int input = cli.nextInt();
                if (input==1) {
                    Manager.addManager();
                } else if(input==2) {
                    Member.addMember();
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
                    Rent.show();
                } else if(input==9) {
                    System.out.println("Enter nationalCode: -> ");
                    String v = cli.nextLine();
                    Manager manager= Manager.getManager(v);
                    manager.remove();
                } else if(input==10) {
                    System.out.println("Enter id: -> ");
                    int b = cli.nextInt();
                    Member member= Member.getMember(b);
                    member.remove();
                } else if(input==11) {
                    System.out.print("Enter id: -> ");
                    int o= cli.nextInt();
                    Book book= Book.getBook(o);

                    book.remove();
                } else if(input==12) {
                    System.out.println("Enter date: -> ");
                    int q = cli.nextInt();
                    Rent rent= Rent.getRent(String.valueOf(q));
                    rent.remove();
                } else if(input==13) {
                    System.exit(0);
                } else {
                    System.out.println("invalid option");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        Manager.select();
        Member.select();
        Book.select();
        Rent.select();
        new MainCli().run();
    }
}
