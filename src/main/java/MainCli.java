import java.util.Scanner;

public class MainCli {
    Scanner cli = new Scanner(System.in);
    public void menu(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  menu description  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Create And Add    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Show Table Lists  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Remove Table Item |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Search Console    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 0  |  Exit              |");
        System.out.println("+----+--------------------+");
        System.out.println("Please Select Menu option");
        System.out.print("Command> ");
    }
    public void add(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  add description   |");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Add Manager       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Add Member        |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Add Book          |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Add Rent          |");
        System.out.println("+----+--------------------+");
        System.out.println("| 0  |  Back To Menu      |");
        System.out.println("+----+--------------------+");
        System.out.println("What you want to add ?");
        System.out.print("Command> ");
    }
    public void show(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  show description  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Show Manager List |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Show Member List  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Show Book List    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Show Rent List    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 0  |  Back To Menu      |");
        System.out.println("+----+--------------------+");

        System.out.println("Which list you want to see ?");
        System.out.print("Command> ");
    }
    public void remove(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  remove description|");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Remove Manager    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Remove Member     |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Remove Book       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Remove Rent       |");
        System.out.println("+----+--------------------+");
        System.out.println("| 0  |  Back To Menu      |");
        System.out.println("+----+--------------------+");

        System.out.println("Do You Want Remove Something ?");
        System.out.print("Command> ");
    }
    public void search(){
        System.out.println("+----+--------------------+");
        System.out.println("| id |  search description  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 1  |  Search in Mangers |");
        System.out.println("+----+--------------------+");
        System.out.println("| 2  |  Search in Member  |");
        System.out.println("+----+--------------------+");
        System.out.println("| 3  |  Search in Book    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 4  |  Search in Rent    |");
        System.out.println("+----+--------------------+");
        System.out.println("| 0  |  Back To Menu      |");
        System.out.println("+----+--------------------+");

        System.out.println("what are you looking for ?");
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
                    while(true){
                        add();
                        int add_input = cli.nextInt();
                        if(add_input==1){
                            Manager.addManager();
                        }
                        else if (add_input==2){
                            Member.addMember();
                        }
                        else if (add_input==3){
                            Book.addBook();
                        }
                        else if (add_input==4){
                            while(true){
                                System.out.println("+----+--------------------+");
                                System.out.println("| 1  |  Add Rent          |");
                                System.out.println("+----+--------------------+");
                                System.out.println("| 2  |  Show Books List   |");
                                System.out.println("+----+--------------------+");
                                System.out.println("| 3  |  Show Members List |");
                                System.out.println("+----+--------------------+");
                                System.out.println("| 0  |  Back To Menu      |");
                                System.out.println("+----+--------------------+");
                                System.out.print("Command> ");
                                int r = cli.nextInt();
                                if(r==1){
                                    Rent.addRent();
                                }
                                else if(r==2){
                                    Book.show();
                                }
                                else if(r==3){
                                    Member.show();
                                }
                                else if(r==0){
                                    break;
                                }
                                else{
                                    System.out.println("invalid option");
                                }
                            }
                        }
                        else if (add_input==0){
                            break;
                        }
                        else{
                            System.out.println("invalid option");
                        }
                    }
                }
                else if(input==2) {
                    while(true){
                        show();
                        int show_input = cli.nextInt();
                        if(show_input==1){
                            Manager.show();
                        }
                        else if (show_input==2){
                            Member.show();
                        }
                        else if (show_input==3){
                            Book.show();
                        }
                        else if (show_input==4){
                            JavaSQL.select_book();
                            JavaSQL.select_book();
                            Rent.show();
                        }
                        else if (show_input==0){
                            break;
                        }
                        else{
                            System.out.println("invalid option");
                        }
                    }
                }
                else if(input==3){
                    while(true){
                        remove();
                        System.out.print("Command> ");
                        int remove_input = cli.nextInt();
                        if(remove_input==1){
                            while (true){
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 1  |  Remove Manager       |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 2  |  Show Manager List    |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 0  |  Back To Remove List  |");
                                System.out.println("+----+-----------------------+");
                                System.out.print("Command> ");
                                int item = cli.nextInt();
                                if(item==1){
                                    JavaSQL.select_manager();
                                    System.out.print("Enter manager nationalCode: -> ");
                                    int v = cli.nextInt();
                                    Manager manager = Manager.getManager(v);
                                    manager.remove();
                                }
                                else if(item==2){
                                    Manager.show();
                                }
                                else if(item==0){
                                    break;
                                }
                                else{
                                    System.out.println("invalid option");
                                }
                            }
                        }
                        else if (remove_input==2){
                            while (true){
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 1  |  Remove Member        |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 2  |  Show Member List     |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 0  |  Back To Remove List  |");
                                System.out.println("+----+-----------------------+");
                                System.out.print("Command> ");
                                int item = cli.nextInt();
                                if(item==1){
                                    JavaSQL.select_member();
                                    System.out.print("Enter member nationalCode: -> ");
                                    int b = cli.nextInt();
                                    Member member= Member.getMember(b);
                                    member.remove();
                                }
                                else if(item==2){
                                    Member.show();
                                }
                                else if(item==0){
                                    break;
                                }
                                else{
                                    System.out.println("invalid option");
                                }
                            }
                        }
                        else if (remove_input==3){
                            while (true){
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 1  |  Remove Book          |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 2  |  Show Book List       |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 0  |  Back To Remove List  |");
                                System.out.println("+----+-----------------------+");
                                System.out.print("Command> ");
                                int item = cli.nextInt();
                                if(item==1){
                                    JavaSQL.select_book();
                                    System.out.print("Enter id: -> ");
                                    int o= cli.nextInt();
                                    Book book= Book.getBook(o);
                                    book.remove();
                                }
                                else if(item==2){
                                    Book.show();
                                }
                                else if(item==0){
                                    break;
                                }
                                else{
                                    System.out.println("invalid option");
                                }
                            }
                        }
                        else if (remove_input==4){
                            while (true){
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 1  |  Remove Rent          |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 2  |  Show Rent List       |");
                                System.out.println("+----+-----------------------+");
                                System.out.println("| 0  |  Back To Remove List  |");
                                System.out.println("+----+-----------------------+");
                                System.out.print("Command> ");
                                int item = cli.nextInt();
                                if(item==1){
                                    JavaSQL.select_rent();
                                    System.out.print("Enter date: -> ");
                                    int q = cli.nextInt();
                                    Rent rent= Rent.getRent(String.valueOf(q));
                                    rent.remove();
                                }
                                else if(item==2){
                                    JavaSQL.select_book();
                                    JavaSQL.select_book();
                                    Rent.show();                                }
                                else if(item==0){
                                    break;
                                }
                                else{
                                    System.out.println("invalid option");
                                }
                            }
                        }
                        else if (remove_input==0){
                            break;
                        }
                        else{
                            System.out.println("invalid option");
                        }
                    }
                }
                else if(input==4){
                    while(true){
                        search();
                        int search_input = cli.nextInt();
                        if(search_input==1){
                            Manager.show();
                        }
                        else if (search_input==2){
                            Member.show();
                        }
                        else if (search_input==3){
                            Book.show();
                        }
                        else if (search_input==4){
                            JavaSQL.select_book();
                            JavaSQL.select_book();
                            Rent.show();
                        }
                        else if (search_input==0){
                            break;
                        }
                        else{
                            System.out.println("invalid option");
                        }
                    }
                }

                else if(input==0){break;}
                else {
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
