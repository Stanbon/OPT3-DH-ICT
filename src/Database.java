import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Database {

        private static final String URL = "jdbc:mysql://localhost:3306/opt3";
        private static final String USER = "root";
        private static final String PASSWORD = "password HERE";

        public static Connection connectDatabase() throws SQLException {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
    }

