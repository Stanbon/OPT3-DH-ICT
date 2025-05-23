abstract class Kamer {



    protected String quiz;

    protected String antwoord;



    public Kamer(String quiz, String antwoord) {
        this.quiz = quiz;
        this.antwoord = antwoord;
    }
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

    /**
     * Print de feedback van de kamer.
     */
    public abstract void printFeedback();

    /**
     * Print het resultaat van het antwoord;
     */
    public abstract void printResultaat();
    /**
     * Print de opdracht van de kamer.
     */
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

    public String getQuiz() {
        return quiz;
    }

    public String getAntwoord() {
        return antwoord;
    }
}
