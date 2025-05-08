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
}
