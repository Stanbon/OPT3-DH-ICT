import java.util.List;
import java.util.Scanner;

class KamerReview extends Kamer {

    public KamerReview() {
        String vraag = "Waar of niet waar:" +
                "\nDe Sprint Review is vooral een statusvergadering waarin teamleden rapporteren " +
                "wat ze tijdens de sprint hebben gedaan.";

        this.vraagStrategie = new WaarOnwaarVraag(vraag, false);
        this.hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
    }
    @Override
    public void controleerAntwoord() {
        while (attempts < getMaxAttempts() && !isCorrect) {
            System.out.print("Je antwoord: ");
            Scanner scanner = new Scanner(System.in);
            String antwoord = scanner.nextLine().trim().toUpperCase();

            isCorrect = vraagStrategie.controleerAntwoord(antwoord);
            attempts++;

            if (!isCorrect && attempts < getMaxAttempts()) {
                System.out.println("Niet correct. Probeer opnieuw.");
                roepHintProviderAan();
            }
        }
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