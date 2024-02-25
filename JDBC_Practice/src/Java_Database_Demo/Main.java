package Java_Database_Demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DataAccessObject DAO = new DataAccessObject();
        System.out.print("Enter Choice: ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.print("Enter Data Identification Number: ");
                User user = DAO.getData(sc.nextInt());
                System.out.println(user.toString());
                break;
            case 2:
                sc.nextLine();
                System.out.print("Enter First Name: ");
                String first = sc.nextLine();
                System.out.print("Enter Last Name: ");
                String last = sc.nextLine();
                DAO.insertData(first, last);
                break;
            case 3:
                System.out.print("Enter Data Identification Number to be Deleted: ");
                DAO.deleteData(sc.nextInt());
                break;
        }
    }
}
