import ISP.Vuist;

import java.sql.*;

public class SpelerDatabase {

    public static Speler createSpeler(String naam) {
        String sql = "SELECT * FROM speler WHERE naam = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, naam);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("speler_id");
                    int positie = rs.getInt("positie");
                    int levens = rs.getInt("levens");
                    int HP = rs.getInt("HP");
                    String status = rs.getString("status");

                    return new Speler(id, naam, status, positie, levens, HP, new Vuist());
                }
            }

            // Speler bestaat niet → maak nieuwe speler aan
            String insert = "INSERT INTO speler (naam, positie, levens, status, HP) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
                int positie = 0;
                int levens = 3;
                int HP = 100;
                String status = "levend";
                insertStmt.setString(1, naam);
                insertStmt.setInt(2, positie);
                insertStmt.setInt(3, levens);
                insertStmt.setString(4, status);
                insertStmt.setInt(5, HP);

                insertStmt.executeUpdate();

                try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        return new Speler(id, naam, status, positie, levens, HP, new Vuist());
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Fout bij zoeken of maken speler: " + e.getMessage());
        }

        return null;
    }




    /*
    public void updateLevensInDatabase(int newLevens) {
        String sql = "UPDATE speler SET levens = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newLevens);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.levens = newLevens;
                System.out.println("Levens updated to " + newLevens);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating levens: " + e.getMessage());
        }
    }
    */

    /*
    public void updateStatusInDatabase(String newStatus) {
        String sql = "UPDATE speler SET status = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.status = newStatus;
                System.out.println("Status updated to " + newStatus);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating status: " + e.getMessage());
        }
    }
    */

    /*
    public void updatePositieInDatabase(int newPositie) {
        String sql = "UPDATE speler SET positie = ? WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newPositie);
            stmt.setInt(2, this.id);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                this.positie = newPositie;
                System.out.println("Positie updated to " + newPositie);
            } else {
                System.out.println("No speler found with id: " + this.id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating positie: " + e.getMessage());
        }
    }
    */
}
