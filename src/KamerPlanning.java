import java.util.List;
import java.util.Scanner;

class KamerPlanning extends Kamer implements AntwoordObserver{
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerPlanning(){
        String vraag = "Vul in:\nTijdens de sprint planning selecteert het team items uit de _______ _______ " +
                "om tijdens de sprint aan te werken.";
        String antwoord = "Product Backlog";
        this.vraagStrategie = new OpenVraag(vraag, antwoord);
        this.hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
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
        System.out.println("Welkom in de kamer van de Sprint Planning!");
    }

    @Override
    public void roepHintProviderAan () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wil je een hint? (ja/nee): ");
        String keuze = scanner.nextLine().trim().toLowerCase();

        if (keuze.equals("ja")) {
            HintProvider hint = HintSelector.kiesHintUitLijst(hintProviders);
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
        System.out.println("testing keyhint lol");
    }
}
