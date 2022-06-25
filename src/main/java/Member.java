
import java.io.*;
import java.util.Scanner;

public class Member extends Entity {

    private static int static_member_id =1;
    private int Member_id;
    public static String name;
    public static String nationalCode;

    public Member(int member_primary,String entityName, int entityNationalCode) {
        super(entityName, entityNationalCode);
//        this.Member_id = static_member_id;
//        static_member_id++;
        this.Member_id = member_primary;
    }

    public int getMember_id() {
        return Member_id;
    }

    public void setMember_id(int member_id) {
        Member_id = member_id;
    }

    public static Member getMember(int nationalCode) {
        Member member = null;
        for (Member memberItem : JavaSQL.Members) {
            if (memberItem.getEntityNationalCode() == nationalCode) {
                member = memberItem;
                break;
            }
        }
        return member;
    }
    public static Member getMemberById(int id) {
        JavaSQL.select_member();
        Member member = null;
        for (Member memberItem : JavaSQL.Members) {
            if (memberItem.getMember_id() == id) {
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
            name = inputName.nextLine();
            System.out.print("Enter nationalCode: -> ");
            nationalCode = input.nextLine();
            Member member = new Member(static_member_id,name, Integer.parseInt(nationalCode));
            member.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void remove() {
        JavaSQL.remove(this);
    }


    public void save() {
        JavaSQL.save(this);
    }
    public static void show() {
        JavaSQL.select_member();
        for (Member member : JavaSQL.Members) {
            System.out.println(member.toString());
        }
    }

    @Override
    public String toString() {
        return "{ member : " + getEntityName() + " , nationalCode: " + getEntityNationalCode() + " , id : " + getMember_id() + " }";
    }
}
