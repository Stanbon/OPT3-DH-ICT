import java.util.List;
import java.util.Scanner;

public class KamerDailyScrum extends Kamer implements AntwoordObserver {

    private boolean isCorrect;
    private int attempts = 0;
    private final int maxAttempts = 3;
    private final AntwoordControle antwoordControle = new AntwoordControle();

    public KamerDailyScrum() {
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

        antwoordControle.voegObserverToe(this);
    }

    @Override
    public void controleerAntwoord() {
        boolean monsterVerschenen = false;

        while (attempts < getMaxAttempts() && !this.isCorrect) {
            String antwoord = getUserInput().toUpperCase();

            if (antwoord.equalsIgnoreCase("/joker")) {
                gebruikJokerMenu();
                continue;
            }

            boolean isCorrect = vraagStrategie.controleerAntwoord(antwoord);
            antwoordControle.controleAntwoord(antwoord, vraagStrategie);
            update(isCorrect);

            if (isCorrect) {
                if (monsterVerschenen) {
                    System.out.println("Je hebt het monster verslagen!");
                    roepHintProviderAan();
                } else {
                    System.out.println("Goed gedaan! Je had het in één keer goed.");
                }
                break;
            } else {
                attempts++;
                RoepMonsterAan();
                monsterVerschenen = true;

                if (attempts >= getMaxAttempts()) {
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
        public void RoepMonsterAan () {
            System.out.println("Er is geen monster in deze kamer.");
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
    public void activeerKeyHint() {
        System.out.println("");
    }

}

