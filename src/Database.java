import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:opt3.db";

    public static Connection connectDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        if (connection != null) {
            System.out.println("Verbonden met de database.");
        } else {
            System.out.println("Kan geen verbinding maken met de database.");
        }
        return connection;
    }

    // ✅ Deze methode maakt de tabellen aan
    public static void createTables() {
        String createKamerTable = """
                CREATE TABLE IF NOT EXISTS kamer (
                    kamer_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    naam TEXT NOT NULL
                );
                """;

        String createSpelerTable = """
                CREATE TABLE IF NOT EXISTS speler (
                    speler_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    naam TEXT NOT NULL,
                    positie INTEGER NOT NULL,
                    levens INTEGER NOT NULL
                );
                """;

        String createCompletedTable = """
                CREATE TABLE IF NOT EXISTS completed (
                    speler_id INTEGER NOT NULL,
                    kamer_id INTEGER NOT NULL,
                    PRIMARY KEY (speler_id, kamer_id),
                    FOREIGN KEY (speler_id) REFERENCES speler(speler_id),
                    FOREIGN KEY (kamer_id) REFERENCES kamer(kamer_id)
                );
                """;

        try (Connection conn = connectDatabase(); Statement stmt = conn.createStatement()) {
            stmt.execute(createKamerTable);
            stmt.execute(createSpelerTable);
            stmt.execute(createCompletedTable);
            System.out.println("Tabellen succesvol aangemaakt.");
        } catch (SQLException e) {
            System.err.println("Fout bij aanmaken tabellen: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        createTables();  // 🔧 Aangeroepen vanuit main()
    }
}
