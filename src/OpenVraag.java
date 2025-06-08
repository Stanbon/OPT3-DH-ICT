public class OpenVraag implements VraagStrategie {
    private String vraag;
    private String juisteAntwoord;

    public OpenVraag(String vraag, String juisteAntwoord) {
        this.vraag = vraag;
        this.juisteAntwoord = juisteAntwoord;
    }

    @Override
    public void printVraag() {
        System.out.println(vraag);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.trim().equalsIgnoreCase(juisteAntwoord);
    }
}
