import java.util.List;
import java.util.Scanner;

public class KamerTIA extends Kamer implements AntwoordObserver{

    private final CombatStrategy combatStrategy;
    private final Speler speler;
    private boolean isCorrect;
    private int attempts = 0;
    private Monster monster;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerTIA(Speler speler, CombatStrategy combatStrategy) {
        this.speler = speler;
        this.combatStrategy = combatStrategy;
        this.monster = new MonsterDraak();

        String vraag = "Ja of Nee: Zijn de drie pijlers van scrum onderling afhankelijk voor procescontrole?";
        boolean antwoord = true;
        this.vraagStrategie = new WaarOnwaarVraag(vraag, antwoord);
        this.hintProviders = List.of(
                new HelpHintProvider(),
                new FunnyHintProvider()
        );
    }

    @Override
    public void controleerAntwoord() {
        Deur deur = new Deur();
        ScoreBord scoreBord = new ScoreBord();
        antwoordControle.voegObserverToe(deur);
        antwoordControle.voegObserverToe(monster);
        antwoordControle.voegObserverToe(scoreBord);
        antwoordControle.voegObserverToe(this);
        while (attempts < maxAttempts && !isCorrect) {
            String antwoord = getUserInput().toUpperCase();
            if (antwoord.equalsIgnoreCase("/joker")) {
                System.out.println("Geen hints mogelijk!");
                continue;
            }


            antwoordControle.controleAntwoord(antwoord, vraagStrategie);

            if (isCorrect) {
                System.out.println("Goed gedaan! Je hebt het spel gewonnen!");
                System.exit(0);
                break;
            } else {
                attempts++;
                if (attempts < maxAttempts) {
                    if (!monster.isVerslagen()) {
                        combatStrategy.startCombat(speler, monster);
                    }

                    if (monster.isVerslagen()) {
                        roepHintProviderAan();
                    } else {
                        System.out.println("Je kunt geen hint krijgen totdat het monster is verslagen!");
                    }
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
        System.out.println("Welkom in de kamer van de TIA!");
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
    public boolean kanAssistentJokerGebruiken() {
        return false;
    }


    @Override
    public void assistentieActivatie() {
    }

    @Override
    public void vraagHint() {

    }

    @Override
    public void geefHint() {

    }
    @Override
    public void markeerAlsCorrect() {
        isCorrect = true;
    }
    @Override
    public void activeerKeyHint() {
        System.out.println("");
    }
}
