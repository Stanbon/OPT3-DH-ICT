abstract class Kamer implements HintProvider, AntwoordObserver {
    protected VraagStrategie vraagStrategie;

    public void setVraagStrategie(VraagStrategie vraagStrategie) {
        this.vraagStrategie = vraagStrategie;
    }

    protected int attempts = 0;
    protected boolean isCorrect = false;



    //Template method
    /**
     * Start de kamer met de introductie, opdracht, controleer antwoord, resultaat en feedback.
     * Template Method Pattern
     */
    public final void startKamer() {
        printIntroductie();
        printOpdracht();

        // Loop to ask until correct or max attempts
        while (!isCorrect && attempts < getMaxAttempts()) {
            String userAnswer = getUserInput();
            isCorrect = checkAntwoord(userAnswer);

            if (!isCorrect) {
                attempts++;
                printResultaat();
                printFeedback();

                // Only after the first wrong attempt, ask for hint
                if (attempts == 1) {
                    roepHintProviderAan();
                }
            } else {
                printResultaat();
                printFeedback();
            }
        }

        if (!isCorrect) {
            System.out.println("Je hebt alle pogingen gebruikt. Het juiste antwoord was: " + antwoord);
        }
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
     * Print het resultaat van het antwoord;
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
    public  abstract void controleerAntwoord();



    public abstract boolean checkAntwoord (String userAnswer);

    public abstract void roepHintProviderAan();



    public abstract boolean kanKeyJokerGebruiken();

}
