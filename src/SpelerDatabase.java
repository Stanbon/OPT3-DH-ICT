public class SpelerDatabase {

    /*
    public void saveToDatabase() {
        String sql = "INSERT INTO speler (spelerid, naam, status, positie, levens, HP) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, naam);
            stmt.setString(3, status);
            stmt.setInt(4, positie);
            stmt.setInt(5, levens);
            stmt.setInt(6, HP);

            stmt.executeUpdate();
            System.out.println("Speler saved to database.");

        } catch (SQLException e) {
            System.err.println("Failed to save Speler: " + e.getMessage());
        }
    }
    */

    /*
    public static Speler loadFromDatabase(int spelerid) {
        String sql = "SELECT * FROM speler WHERE spelerid = ?";

        try (Connection conn = Database.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, spelerid);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String naam = rs.getString("naam");
                    String status = rs.getString("status");
                    int positie = rs.getInt("positie");
                    int levens = rs.getInt("levens");
                    int HP = rs.getInt("HP");

                    return new Speler(id, naam, status, positie, levens, HP, new Vuist()); // or appropriate Wapen

                } else {
                    System.out.println("No speler found with id: " + spelerid);
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to load Speler: " + e.getMessage());
        }

        return null;
    }
    */

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
