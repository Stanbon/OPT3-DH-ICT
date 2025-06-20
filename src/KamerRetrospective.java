import java.util.List;
import java.util.Scanner;

public class KamerRetrospective extends Kamer implements AntwoordObserver, toonHulpmiddel, toonMotiverendeBericht{

    private final CombatStrategy combatStrategy;
    private final Speler speler;
    private boolean isCorrect;
    private int attempts = 0;
    private Monster monster;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerRetrospective(Speler speler, CombatStrategy combatStrategy) {
        this.speler = speler;
        this.combatStrategy = combatStrategy;
        this.monster = new MonsterGorilla();

        String vraag = "Geef antwoord op de volgende vraag: \nWat is het doel van een retrospective? \nNoem 2 doelen op in alfabetisch volgorde";
        String antwoord = "terugkijken verbeterpunten";
        this.vraagStrategie = new OpenVraag(vraag, antwoord);
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
                gebruikJokerMenu();
                continue;
            }

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
        System.out.println("Welkom in de Sprint Retrospective kamer!");
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
            setBeloning(new HealingBeloning(100));
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
        return true;
    }

    @Override
    public void hulpmiddel() {
        System.out.println("Het eerste woord heeft 11 woorden en het tweede heeft 14 woorden");
    }

    @Override
    public void motiverendeBericht() {
        System.out.println("Kom op speler ik heb vertrouwen in jouw!");
    }

    @Override
    public void assistentieActivatie() {
        activeerKeyHint();
        hulpmiddel();
        motiverendeBericht();
    }

    @Override
    public void vraagHint() {

    }

    @Override
    public void geefHint() {

    }
    @Override
    public void activeerKeyHint() {
        System.out.println("Het is een moment om te leren van de sprint.");
    }

    @Override
    public void markeerAlsCorrect() {
        isCorrect = true;
    }
}
