    import java.util.List;
    import java.util.Scanner;

    abstract class Kamer implements HintProvider, AntwoordObserver {
        protected VraagStrategie vraagStrategie;



        protected List<HintProvider> hintProviders;
        protected final KeyJoker keyJoker = new KeyJoker();
        protected final HintJoker hintJoker = new HintJoker();
        protected final assistentJoker assistentJoker = new assistentJoker();
        protected final JokerService jokerService = new JokerService();

        protected void gebruikJokerMenu() {
            jokerService.gebruikJoker(this);
        }
        //Template method

        public final void startKamer(Speler speler) {
            printIntroductie();
            printOpdracht();
            controleerAntwoord();
            printResultaat();
            printFeedback();
            geefBeloning(speler);
        }




        protected String getUserInput() {
            System.out.print("Je antwoord: ");
            return new java.util.Scanner(System.in).nextLine().trim();
        }


        public abstract void printFeedback();


        public abstract void printResultaat();

        public abstract void printOpdracht();


        public abstract void printIntroductie();

        public abstract void controleerAntwoord();

        public abstract void roepHintProviderAan();

        public abstract boolean kanKeyJokerGebruiken();

        public abstract boolean kanAssistentJokerGebruiken();

        public abstract void activeerKeyHint();

        public abstract void markeerAlsCorrect();

        public abstract void assistentieActivatie();

        protected Beloning kamerBeloning;

        public void setBeloning(Beloning beloning) {
            this.kamerBeloning = beloning;
        }

        protected void geefBeloning(Speler speler) {
            if (kamerBeloning != null) {
                kamerBeloning.pasToeOp(speler);
            }
        }


    }
