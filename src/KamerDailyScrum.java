import java.util.List;
import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    private List<HintProvider> hintProviders;
    private boolean isCorrect;
    private int attempts = 0;
    private final int maxAttempts = 3;

    public KamerDailyScrum() {
        String vraag = "Wat is het voornaamste doel van de Daily Scrum?";
        String[] opties = {
                "Nieuwe taken toewijzen aan teamleden",
                "Voortgang rapporteren aan de Product Owner",
                "Het team synchroniseren en de komende 24 uur plannen",
                "Een sprint review houden"
        };
        this.vraagStrategie = new MeerkeuzeVraag(vraag, opties, "C");
        hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
    }

    @Override
    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.next();
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
    public void roepHintProviderAan() {
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
    public void printIntroductie() {
        System.out.println("Welkom in de Daily Scrum kamer!");
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

    @Override
    public boolean kanKeyJokerGebruiken(){
        return true;
    }
}
