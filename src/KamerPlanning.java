import java.util.List;
import java.util.Scanner;

class KamerPlanning extends Kamer implements AntwoordObserver, toonHulpmiddel, toonMotiverendeBericht{
    private final CombatStrategy combatStrategy;
    private final Speler speler;
    private boolean isCorrect;
    private int attempts = 0;
    private Monster monster;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerPlanning(Speler speler, CombatStrategy combatStrategy) {
        this.speler = speler;
        this.combatStrategy = combatStrategy;
        this.monster = new MonsterScope();

        String vraag = "Vul in:\nTijdens de sprint planning selecteert het team items uit de _______ _______ " +
                "om tijdens de sprint aan te werken.";
        String antwoord = "Product Backlog";
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
            antwoordControle.voegObserverToe(this);
            antwoordControle.voegObserverToe(deur);
            antwoordControle.voegObserverToe(monster);
            antwoordControle.voegObserverToe(scoreBord);
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
            }
            else {
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
        System.out.println("Het eerste woord heeft 7 letters en het tweede woord heeft ook 7 letters");
    }

    @Override
    public void motiverendeBericht() {
        System.out.println("Dan denk je als een echte product owner!");
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
    public void markeerAlsCorrect() {
        isCorrect = true;
    }
        @Override
        public void activeerKeyHint() {
            System.out.println("Het is een lijst met items die het team kan oppakken.");
        }
    }

