package Java_Database_Demo;

public class User {
    public String firstName;
    public String lastName;
    public int identificationNumber;
    @Override
    public String toString(){
        return "First Name: " + this.firstName + "\nLastName: " + lastName + "\n";
    }
}
