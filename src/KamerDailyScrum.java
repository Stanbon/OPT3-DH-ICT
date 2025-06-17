import java.util.List;
import java.util.Scanner;

public class KamerDailyScrum extends Kamer implements AntwoordObserver {

    private final CombatStrategy combatStrategy;
    private final Speler speler;
    private boolean isCorrect;
    private int attempts = 0;
    private Monster monster;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerDailyScrum(Speler speler, CombatStrategy combatStrategy) {
        this.speler = speler;
        this.combatStrategy = combatStrategy;
        this.monster = new MonsterVertraging();

        String vraag = "Wat is het voornaamste doel van de Daily Scrum?";
        String[] opties = {
                "Nieuwe taken toewijzen aan teamleden",
                "Voortgang rapporteren aan de Product Owner",
                "Het team synchroniseren en de komende 24 uur plannen",
                "Een sprint review houden"
        };
        this.vraagStrategie = new MeerkeuzeVraag(vraag, opties, "C");
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
            antwoordControle.voegObserverToe(this);
            antwoordControle.voegObserverToe(deur);
            antwoordControle.voegObserverToe(monster);
            antwoordControle.voegObserverToe(scoreBord);
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
        public void printFeedback () {

        }

        @Override
        public void printResultaat () {
            if (isCorrect) {
                System.out.println("Goed gedaan! Je hebt het juiste antwoord gegeven.");
            } else {
                System.out.println("Je hebt het helaas niet correct beantwoord.");
            }
        }

        @Override
        public void printOpdracht () {
            vraagStrategie.printVraag();
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
         public void printIntroductie () {
             System.out.println("Welkom in de Daily Scrum kamer!");
         }


        @Override
        public void vraagHint(){
        }


        @Override
        public void geefHint() {
        }

        @Override
        public boolean kanKeyJokerGebruiken () {
            return true;
        }

    @Override
    public void markeerAlsCorrect() {
        isCorrect = true;
    }

    @Override
    public void activeerKeyHint() {
        System.out.println("Het gaat over de dagelijkse planning van het team.");
    }



    @Override
    public void markeerAlsCorrect() {
        isCorrect = true;
    }
}

