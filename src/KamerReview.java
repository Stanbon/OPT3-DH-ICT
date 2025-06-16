import java.util.List;
import java.util.Scanner;

class KamerReview extends Kamer implements AntwoordObserver{

    private final CombatStrategy combatStrategy;
    private final Speler speler;
    private boolean isCorrect;
    private int attempts = 0;
    private Monster monster;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerReview(Speler speler, CombatStrategy combatStrategy) {
        this.speler = speler;
        this.combatStrategy = combatStrategy;
        this.monster = new MonsterTeemo();

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
        while (attempts < maxAttempts && !isCorrect) {
            String antwoord = getUserInput().toUpperCase();
            if (antwoord.equalsIgnoreCase("/joker")) {
                gebruikJokerMenu();
                continue;
            }
            Deur deur = new Deur();
            ScoreBord scoreBord = new ScoreBord();
            antwoordControle.voegObserverToe(deur);
            antwoordControle.voegObserverToe(monster);
            antwoordControle.voegObserverToe(scoreBord);
            antwoordControle.voegObserverToe(this);
            antwoordControle.controleAntwoord(antwoord, vraagStrategie);

            if (isCorrect) {
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
        System.out.println("Welkom in de Sprint Review kamer!");
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
        return true;
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
        System.out.println("Gaat de Sprint Review vooral over de voortgang van het team?");
    }
}