import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&use" +
            "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1321";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(month('31.01.2018'))/12 " +
                    "AS 'avg subscription per month' FROM purchaselist GROUP BY course_name");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_name") + "\t- " +
                        resultSet.getString("avg subscription per month"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}