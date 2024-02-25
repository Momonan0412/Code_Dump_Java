package Java_Database_Connectivity_Practice;

import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

//        Statement st = null;
        PreparedStatement st = null;

        Connection con = null;
        String firstName, lastName;

        try{
            String URL = "jdbc:mysql://localhost:3306/testdb";
            String Name = "root";
            String Password = "Chua123";

//            Query to get data from database
            String query1 = "SELECT * FROM USER";

            System.out.print("Enter First Name: ");
            firstName = sc.nextLine();
            System.out.print("Enter Last Name: ");
            lastName = sc.nextLine();

//            Query to insert data to database
//            String query2 = "INSERT INTO user (firstName, lastName) VALUES ('"+ firstName +"', '"+ lastName +"');";
            String query2 = "INSERT INTO user (firstName, lastName) VALUES (?, ?)"; // Prepared statement! instead values add question mark!
            /** Can also use delete just change insert to delete in MYSQL syntax **/


            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, Name, Password);

//            st = con.createStatement();
            st = con.prepareStatement(query2); // instead of statement use prepared statement instead
            st.setString(1, firstName); // first parameter and insert firstname
            st.setString(2, lastName); // second parameter and insert lastname

//            ResultSet rs = st.executeQuery(query1);
            int count = st.executeUpdate(); // executeUpdate in preparedStatement should not have a parameter

//             Data Definition language - to change the structure of the database
//             Data Manipulation Language - Insert, Update, Delete data from database ; executeUpdate
//             Data Query Language - Fetch data ; "executeQuery" used
//             Transaction control language - Grant permission and revoke permission

//            while (rs.next()) {
//                String data = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString("lastName");
//                System.out.println(data);
//            }

            System.out.println(count + "row/s affected");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert st != null;
            st.close();
            con.close();
        }
    }
}