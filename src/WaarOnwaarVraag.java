public class WaarOnwaarVraag implements VraagStrategie {
    private String vraag;
    private boolean juistAntwoord;

    public WaarOnwaarVraag(String vraag, boolean juistAntwoord) {
        this.vraag = vraag;
        this.juistAntwoord = juistAntwoord;
    }

    @Override
    public void printVraag() {
        System.out.println(vraag);
        System.out.println("Typ 'waar' of 'onwaar':");
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        antwoord = antwoord.trim().toLowerCase();
        if (antwoord.equals("waar")) {
            return juistAntwoord;
        } else if (antwoord.equals("onwaar")) {
            return !juistAntwoord;
        } else {
            System.out.println("Ongeldig antwoord. Typ 'waar' of 'onwaar'.");
            return false;
        }
    }
}
