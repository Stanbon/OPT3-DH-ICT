public abstract class Kamer implements HintProvider, AntwoordObserver {

    protected String quiz;
    protected String antwoord;

    protected int attempts = 0;
    protected boolean isCorrect = false;

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

    public abstract void printResultaat();

    public abstract void printOpdracht();

    public abstract void printIntroductie();

    public abstract boolean checkAntwoord(String userAnswer);

    public abstract void roepHintProviderAan();

    public String getQuiz() {
        return quiz;
    }

    public String getAntwoord() {
        return antwoord;
    }
}
