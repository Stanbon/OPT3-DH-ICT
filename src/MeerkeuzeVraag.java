public class MeerkeuzeVraag implements VraagStrategie{

    private String vraag;
    private String[] opties;
    private String juisteAntwoord;

    public MeerkeuzeVraag(String vraag, String[] opties, String juisteAntwoord){}
    @Override
    public void printVraag() {
        System.out.println(vraag);
        char label = 'A';
        for (String optie : opties) {
            System.out.println(label++ + ") " + optie);
        }
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equalsIgnoreCase(juisteAntwoord);
    }
}
