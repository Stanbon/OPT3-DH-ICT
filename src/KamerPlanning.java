import java.util.Scanner;

class KamerPlanning extends Kamer {




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
        System.out.println("Vul in:");
        System.out.println("Tijdens de sprint planning selecteert het team items uit de _______ _______ " +
                "om tijdens de sprint aan te werken.");

    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de kamer van de Sprint Planning!");
    }

    @Override
    public boolean checkAntwoord (String userAnswer, String goedeAntwoord) {
        return false;
    }
}
