
import java.io.*;

import java.util.Scanner;

public class Manager extends Entity {

    public Manager(String entityName, int entityNationalCode) {
        super(entityName, entityNationalCode);
    }
    public static Manager getManager(int national_code) {
        Manager manager = null;
        for (Manager managerDetail : File.Managers) {
            if (managerDetail.getEntityNationalCode() == national_code) {
                manager = managerDetail;
                break;
            }
        }
        return manager;
    }
    public  void remove() {
        File.remove(this);
    }
    public static void addManager() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter name: -> ");
            String name = input.nextLine();
            System.out.print("Enter nationalCode: -> ");
            String nationalCode = input.nextLine();
            Manager manager = new Manager(name, Integer.parseInt(nationalCode));
            manager.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void insert() {
        try {
            FileOutputStream File_output = new FileOutputStream(File.manager_url);
            ObjectOutputStream Object_output = new ObjectOutputStream(File_output);
            for (Manager memberItem : File.Managers) {
                Object_output.writeObject(memberItem);
            }
            Object_output.close();
            System.out.println("files loaded");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static void select() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(File.manager_url))) {
            while (true) {
                Manager managerItem = (Manager) input.readObject();
                File.Managers.add(managerItem);
            }
        } catch (EOFException eof) {
            System.out.println("end of files");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }

    }


    public void save() {
        File.save(this);

    }

    public static void show() {
        for (Manager manager : File.Managers) {
            System.out.println(manager.toString());
        }
    }


    @Override
    public String toString() {
        return "{ manager : " + getEntityName() + " , nationalCode : " + getEntityNationalCode() + " }";
    }
}
