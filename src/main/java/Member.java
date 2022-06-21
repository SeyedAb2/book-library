
import java.io.*;
import java.util.Scanner;

public class Member extends Entity {

    private static int static_member_id =1;
    private int Member_id;

    public Member(String entityName, String entityNationalCode) {
        super(entityName, entityNationalCode);
        this.Member_id = static_member_id;
        static_member_id++;
    }

    public int getMember_id() {
        return Member_id;
    }

    public void setMember_id(int member_id) {
        Member_id = member_id;
    }

    public static Member getMember(int member_id) {
        Member member = null;
        for (Member memberItem : Members) {
            if (memberItem.getMember_id() == member_id) {
                member = memberItem;
                break;
            }
        }
        return member;
    }

    public static void addMember() {

        Scanner inputName = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter name: -> ");
            String name = inputName.nextLine();
            System.out.print("Enter nationalCode: -> ");
            String nationalCode = input.nextLine();
            Member member = new Member(name, nationalCode);
            member.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void remove() {
        File.remove(this);
    }


    public void save() {
        File.save(this);
    }


    public void insert() {
        try {
            FileOutputStream File_output = new FileOutputStream(member_url);
            ObjectOutputStream Object_output = new ObjectOutputStream(File_output);
            for (Member memberItem : Members) {
                Object_output.writeObject(memberItem);
            }

            Object_output.close();
            System.out.println("");
        } catch (IOException ex) {
            System.out.print("");
        }
    }


    public static void select() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(member_url));) {

            while (true) {
                Member memberItem = (Member) input.readObject();
                Members.add(memberItem);
            }


        } catch (EOFException e) {
            System.out.println("");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("");
        }finally {
            if (Members.size()!=0){
                int n= Members.size()-1;
                Member.static_member_id = Members.get(n).Member_id+1;
            }
        }
    }

    public static void show() {
        for (Member member : Members) {
            System.out.println(member.toString());
        }
    }

    @Override
    public String toString() {
        return "{ member : " + getEntityName() + " , nationalCode: " + getEntityNationalCode() + " , id : " + getMember_id() + " }";
    }
}
