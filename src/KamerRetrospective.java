import java.util.List;
import java.util.Scanner;

public class KamerRetrospective extends Kamer{

    public KamerRetrospective(){
        String vraag = "Geef antwoord op de volgende vraag: \nWat is het doel van een retrospective?";
        String antwoord = "Het team kijkt terug op de sprint en bedenkt verbeterpunten";
        this.vraagStrategie = new OpenVraag(vraag, antwoord);
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
        System.out.println("Welkom in de Sprint Retrospective kamer!");
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
