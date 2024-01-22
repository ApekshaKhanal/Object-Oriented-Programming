import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc2 {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3308/jdbcdemo2";
        String username="root";
        String password = "";
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,username,password);
        Scanner scanner = new Scanner(System.in);
        // Prompt user for credentials
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        // Query to check if username and password exist in the database
        String query = "SELECT * FROM users WHERE username = '" + inputUsername + "' AND password = '" + inputPassword + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
        scanner.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

