import java.util.List;
import java.util.Scanner;

public class KamerScrumBoard extends Kamer implements AntwoordObserver{

    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerScrumBoard() {
        String vraag = "Juist of onjuist: Op een scrumboard verplaatst een taak zich van 'Te Doen' naar 'Bezig' naar 'Klaar' naarmate het werk vordert.";
        String antwoord = "Juist";
        this.vraagStrategie = new WaarOnwaarVraag(vraag, true);
        this.hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
        Deur deur = new Deur();
        Monster monster = new MonsterGorilla();
        ScoreBord scoreBord = new ScoreBord();
        antwoordControle.voegObserverToe(deur);
        antwoordControle.voegObserverToe(monster);
        antwoordControle.voegObserverToe(this);
    }



    @Override
    public void controleerAntwoord() {
        while (attempts < getMaxAttempts() && !isCorrect) {
            String antwoord = getUserInput().toUpperCase();

            antwoordControle.controleAntwoord(antwoord, vraagStrategie);

            if (antwoord.equalsIgnoreCase("/joker")) {
                gebruikJokerMenu();
                continue;
            }

            if (isCorrect) {
                break;
            } else {
                attempts++;
                if (attempts < getMaxAttempts()) {
                    roepHintProviderAan();
                } else {
                    System.out.println("Helaas, je hebt het maximale aantal pogingen bereikt.");
                }
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
    public void roepHintProviderAan () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wil je een hint? (ja/nee): ");
        String keuze = scanner.nextLine().trim().toLowerCase();

        if (keuze.equals("ja")) {
            HintProvider hint = HintSelector.kiesHintUitLijst(hintProviders);
            hint.vraagHint();
            hint.geefHint();
        } else {
            System.out.println("Geen hint gekozen, succes!");
        }
    }


    @Override
    public void update ( boolean correctAntwoord){
        this.isCorrect = correctAntwoord;
        if (correctAntwoord) {
            System.out.println("Dat is correct!");
        } else {
            System.out.println("Dat is incorrect!");
        }
    }

    @Override
    public boolean kanKeyJokerGebruiken() {
        return false;
    }


    @Override
    public void vraagHint() {

    }

    @Override
    public void geefHint() {

    }
    @Override
    public void activeerKeyHint() {
        System.out.println("");
    }
}
