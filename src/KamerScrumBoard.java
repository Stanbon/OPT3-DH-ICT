import java.util.List;
import java.util.Scanner;

public class KamerScrumBoard extends Kamer{

    public KamerScrumBoard() {
        String vraag = "Juist of onjuist: Op een scrumboard verplaatst een taak zich van 'Te Doen' naar 'Bezig' naar 'Klaar' naarmate het werk vordert.";
        String antwoord = "Juist";
        this.vraagStrategie = new WaarOnwaarVraag(vraag, true);
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
        System.out.println("Welkom in de Scrum Board kamer!");
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
