
import java.io.*;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Manager extends Entity {
    public static String name;
    public static String nationalCode;
    public Manager(String entityName, int entityNationalCode) {
        super(entityName, entityNationalCode);
    }
    public static Manager getManager(int national_code) {
        Manager manager = null;
        for (Manager managerDetail : JavaSQL.Managers) {
            if (managerDetail.getEntityNationalCode() == national_code) {
                manager = managerDetail;
                break;
            }
        }
        return manager;
    }
    public void remove() {
        JavaSQL.remove(this);
    }
    public static void addManager() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter name: -> ");
            name = input.nextLine();
            System.out.print("Enter nationalCode: -> ");
            nationalCode = input.nextLine();
            Manager manager = new Manager(name, Integer.parseInt(nationalCode));
            manager.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void save() {
        JavaSQL.save(this);

    }

    public static void show() {
        JavaSQL.select_manager();
        for (Manager manager : JavaSQL.Managers) {
            System.out.println(manager.toString());
        }
    }


    @Override
    public String toString() {
        return "{ manager : " + getEntityName() + " , nationalCode : " + getEntityNationalCode() + " }";
    }
}
