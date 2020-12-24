import java.sql.*;

public class DBConnection {
    private static Connection connection;

    private static final String USER = "root";
    private static final String PASS = "test1321";
    private static final String URL = "jdbc:mysql://localhost:3306/learn?useUnicode=true&serverTimezone=UTC";


    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASS);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void executeMultiInsert(StringBuilder builder) throws SQLException {

        DBConnection.getConnection().createStatement()
                .execute("INSERT INTO voter_count(name, birthDate) VALUES" +
                        builder.toString());
    }


    public static void printVoterCounts() {
        String sql = "SELECT name, birthDate, COUNT(*) AS `count` FROM voter_count GROUP BY name, birthDate HAVING `count` > 1";
        try (ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("\t" + rs.getString("name") + " (" +
                        rs.getString("birthDate") + ") - " + rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}