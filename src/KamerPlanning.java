import java.util.Scanner;

class KamerPlanning extends Kamer {


    public KamerPlanning(String quiz, Monster obstakel, String a, String b, String c, String d, String antwoord) {
        super(quiz, obstakel, a, b, c, d, antwoord);
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
        System.out.println("Welke taken passen bij de Sprint Planning?");

    }

    @Override
    public void printIntroductie() {

    }

    @Override
    public boolean checkAntwoord (String userAnswer) {
        return userAnswer.equals(antwoord);
    }

    @Override
    public boolean kanKeyJokerGebruiken(){
        return false;
    }
}
