    import java.util.List;
    import java.util.Scanner;

    abstract class Kamer implements HintProvider, AntwoordObserver {
        protected VraagStrategie vraagStrategie;


        public void setVraagStrategie(VraagStrategie vraagStrategie) {
            this.vraagStrategie = vraagStrategie;
        }

        protected int attempts = 0;
        protected boolean isCorrect = false;
        protected List<HintProvider> hintProviders;
        protected final KeyJoker keyJoker = new KeyJoker();
        protected final HintJoker hintJoker = new HintJoker();
        protected final assistentJoker assistentJoker = new assistentJoker();






        //Template method
        /**
         * Start de kamer met de introductie, opdracht, controleer antwoord, resultaat en feedback.
         * Template Method Pattern
         */
        public final void startKamer() {
            printIntroductie();
            printOpdracht();
            controleerAntwoord();
            printResultaat();
            printFeedback();
        }


        protected int getMaxAttempts() {
            return 3;
        }

        protected String getUserInput() {
            System.out.print("Je antwoord: ");
            return new java.util.Scanner(System.in).nextLine().trim();
        }


        public abstract void printFeedback();

        /**
         * Print het resultaat van het antwoord.
         */
        public abstract void printResultaat();

        public abstract void printOpdracht();

        /**
         * Print de introductie van de kamer.
         */
        public abstract void printIntroductie();
        /**
         * Controleer het antwoord van de gebruiker.
         */
        public abstract void controleerAntwoord();

        protected void gebruikJokerMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welke joker wil je gebruiken? (Gebruik het nummers!)");
            System.out.println("1. HintJoker ");
            System.out.println("2. KeyJoker ");
            System.out.println("3. AssistentJoker");
            String keuze = scanner.nextLine().trim();

            switch (keuze) {
                case "1":
                    hintJoker.useIn(this);
                    break;
                case "2":
                    keyJoker.useIn(this);
                    break;
                case "3":
                    assistentJoker.useIn(this);
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
            }
        }


        public abstract void roepHintProviderAan();

        public abstract boolean kanKeyJokerGebruiken();

        public abstract boolean kanAssistentJokerGebruiken();

        public abstract void activeerKeyHint();

        public abstract void markeerAlsCorrect();

        public abstract void assistentieActivatie();

    }
