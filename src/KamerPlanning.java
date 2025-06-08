import java.util.Scanner;

class KamerPlanning extends Kamer {


    public KamerPlanning(String quiz, String antwoord) {
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
        System.out.println("Welke taken passen bij de Sprint Planning?");

    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de kamer van de Sprint Planning!");
    }

    @Override
    public boolean checkAntwoord (String userAnswer) {
        return userAnswer.equals(antwoord);
    }
}
