public class KamerScrumBoard extends Kamer{


    public KamerScrumBoard(String quiz, String antwoord) {
        super(quiz, antwoord);
    }

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
        System.out.println("Richt de Scrum Board in met de juiste items.");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Scrum Board kamer!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer) {
        return false;
    }
}
