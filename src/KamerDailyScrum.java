import java.util.List;
import java.util.Scanner;

class KamerDailyScrum extends Kamer {

    private List<HintProvider> hintProviders;
    private boolean isCorrect;
    private int attempts = 0;
    private final int maxAttempts = 3;

    public KamerDailyScrum(String quiz, String antwoord) {
        super(quiz, antwoord);
        // Define hints specific to this room
        hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
    }

    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);

        while (attempts < maxAttempts && !isCorrect) {
            System.out.print("Je antwoord: ");
            String userInput = scanner.nextLine().trim();

            isCorrect = checkAntwoord(userInput);
            attempts++;

            if (isCorrect) {
                printResultaat();
                printFeedback();
                break;
            } else {
                printResultaat();
                printFeedback();

                // After first wrong attempt, offer hint
                if (attempts == 1) {
                    roepHintProviderAan();
                }
            }
        }

        if (!isCorrect) {
            System.out.println("Je hebt al je pogingen gebruikt. Het juiste antwoord was: " + antwoord);
        }
    }

    @Override
    public void printFeedback() {
        if (isCorrect) {
            System.out.println("Goed gedaan! Je hebt het juiste antwoord gegeven.");
        } else {
            System.out.println("Dat is niet correct. Probeer het opnieuw.");
        }
    }

    @Override
    public void printResultaat() {
        if (isCorrect) {
            System.out.println("Antwoord is juist!");
        } else {
            System.out.println("Antwoord is fout.");
        }
    }

    @Override
    public void printOpdracht() {
        System.out.println("Wie geeft welke status update?");
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
    public boolean checkAntwoord(String userAnswer) {
        return userAnswer.equalsIgnoreCase(antwoord);
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
