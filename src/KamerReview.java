import java.util.Scanner;

class KamerReview extends Kamer {

    public KamerReview() {
        String vraag = "Waar of niet waar:" +
                "\nDe Sprint Review is vooral een statusvergadering waarin teamleden rapporteren " +
                "wat ze tijdens de sprint hebben gedaan.";

        this.vraagStrategie = new WaarOnwaarVraag(vraag, false);
    }
    @Override
    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        boolean correct = vraagStrategie.controleerAntwoord(antwoord);
    }

    @Override
    public void printFeedback() {

    }

    @Override
    public void printResultaat() {

    }

    @Override
    public void printOpdracht() {
        vraagStrategie.printVraag();
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Sprint Review kamer!");
    }


    @Override
    public void roepHintProviderAan() {

    }

    @Override
    public boolean kanKeyJokerGebruiken() {
        return false;
    }

    @Override
    public void update(boolean correctAntwoord) {

    }

    @Override
    public void vraagHint() {

    }

    @Override
    public void geefHint() {

    }
}