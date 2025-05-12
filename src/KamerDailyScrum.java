public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum(String quiz, String antwoord) {
        super(quiz,antwoord);
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
        System.out.println("Welkom in de Daily Scrum kamer!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer) {
        return false;
    }
}
