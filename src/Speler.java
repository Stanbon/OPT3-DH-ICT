import java.sql.*;

public class Speler {
    private int id;
    private String naam;
    private String Status;
    private int Positie;
    private int levens;


    public Speler(int id, String naam, String status, int positie, int levens) {
        this.id = id;
        this.naam = naam;
        this.Status = status;
        this.Positie = positie;
        this.levens = levens;
    }

    public String getStatus() {
        return Status;
    }
    public int getLevens() {
        return levens;
    }

    public int getPositie (){ return Positie; }
    public int setPositie(int newPositie) { return Positie = newPositie; }


    public void saveToDatabase() {
        String sql = "INSERT INTO speler (spelerid, naam, status, positie, levens) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, naam);
            stmt.setString(3, Status);
            stmt.setInt(4, Positie);
            stmt.setInt(5, levens);

            stmt.executeUpdate();
            System.out.println("Speler saved to database.");

        } catch (SQLException e) {
            System.err.println("Failed to save Speler: " + e.getMessage());
        }
    }

    public static Speler loadFromDatabase(int spelerid) {
        String sql = "SELECT * FROM speler WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, spelerid);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String naam = rs.getString("naam");
                    String Status = rs.getString("status");
                    int Positie = rs.getInt("positie");
                    int levens = rs.getInt("levens");

                    return new Speler(id, naam, Status, Positie, levens);
                } else {
                    System.out.println("No speler found with id: " + spelerid);
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to load Speler: " + e.getMessage());
        }

        return null;
    }

    public void updateLevensInDatabase(int newLevens) {
        String sql = "UPDATE speler SET levens = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newLevens);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.levens = newLevens; // Also update the object in memory
                System.out.println("Levens updated to " + newLevens);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating levens: " + e.getMessage());
        }
    }
    public void updateStatusInDatabase(String newStatus) {
        String sql = "UPDATE speler SET status = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.Status = newStatus; // Also update the object in memory
                System.out.println("Status updated to " + newStatus);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating status: " + e.getMessage());
        }
    }
    public void updatePositieInDatabase(int newPositie) {
        String sql = "UPDATE speler SET positie = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newPositie);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.Positie = newPositie; // Also update the object in memory
                System.out.println("Positie updated to " + newPositie);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating positie: " + e.getMessage());
        }
    }

}

