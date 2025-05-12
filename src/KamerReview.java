class KamerReview extends Kamer {
    public KamerReview(String quiz, Monster obstakel, String a, String b, String c, String d, String antwoord) {
        super(quiz, a, b, c, d, antwoord);
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

    }

    @Override
    public void printIntroductie() {

    }

    @Override
    public boolean checkAntwoord (String userAnswer) {
        return userAnswer.equals(antwoord);
    }
}