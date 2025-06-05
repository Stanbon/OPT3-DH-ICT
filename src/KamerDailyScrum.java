import java.util.Scanner;

public class KamerDailyScrum extends Kamer {



    @Override
    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.next();
        String goedeAntwoord = "C";
        checkAntwoord(antwoord, goedeAntwoord);
    }

    @Override
    public void printFeedback() {

    }

    @Override
    public void printResultaat() {

    }

    @Override
    public void printOpdracht() {
        System.out.println("Type de letter van het juiste antwoord in.");
        System.out.println("Wat is het voornaamste doel van de Daily Scrum?");
        System.out.println("A) Nieuwe taken toewijzen aan teamleden" +
                "\nB) Voortgang rapporteren aan de Product Owner" +
                "\nC) Het team synchroniseren en de komende 24 uur plannen" +
                "\nD) Een sprint review houden ");

    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Daily Scrum kamer!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer, String goedeantwoord) {

    }
}
