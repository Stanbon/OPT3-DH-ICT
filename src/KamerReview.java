class KamerReview extends Kamer {
    public KamerReview(String quiz, String antwoord) {
        super(quiz, antwoord);
    }

    @Override
    public void controleerAntwoord() {

    }

    @Override
    public void printFeedback() {

    }

    @Override
    public void printResultaat() {

    }

    @Override
    public void printOpdracht() {
        System.out.println("Interpreteer de feedback van de stekeholders en schat de impact er van in");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Sprint Review kamer!");
    }

    @Override
    public boolean checkAntwoord (String userAnswer) {
        return userAnswer.equals(antwoord);
    }
}