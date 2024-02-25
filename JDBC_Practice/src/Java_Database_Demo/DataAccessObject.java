package Java_Database_Demo;

import java.sql.*;

public class DataAccessObject{
    PreparedStatement prepSate;
    Connection con;
    String URL;
    String name;
    String password;
    String query;
    void connection(String query){
        try {
            URL = "jdbc:mysql://localhost:3306/testdb";
            name = "root";
            password = "Chua123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, name, password);
            prepSate = con.prepareStatement(query);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    void insertData(String firstName, String lastName){
        this.query = "INSERT INTO user (firstName, LastName) VALUE (?, ?)";
        try{
            connection(query);
            prepSate.setString(1, firstName);
            prepSate.setString(2, lastName);
            int rowAffected = prepSate.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                prepSate.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    void deleteData(int dataID){
        User data = new User();
        data.identificationNumber = dataID;
        this.query = "DELETE FROM user WHERE iduser = " + dataID;
        connection(query);
        try {
            int rowAffected = prepSate.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    User getData(int dataID){
        User data = new User();
        data.identificationNumber = dataID;
        this.query = "SELECT firstName, lastName FROM user WHERE iduser = " + dataID;
        connection(query);
        try {
            ResultSet resultSet = prepSate.executeQuery();
            resultSet.next();
            data.firstName = resultSet.getNString(1);
            data.lastName = resultSet.getNString(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
