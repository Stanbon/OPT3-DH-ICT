import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum() {
        String vraag = "Wat is het voornaamste doel van de Daily Scrum?";
        String[] opties = {
                "Nieuwe taken toewijzen aan teamleden",
                "Voortgang rapporteren aan de Product Owner",
                "Het team synchroniseren en de komende 24 uur plannen",
                "Een sprint review houden"
        };
        this.vraagStrategie = new MeerkeuzeVraag(vraag, opties, "C");
    }

    @Override
    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.next();
        boolean correct = vraagStrategie.controleerAntwoord(antwoord);
    }

    @Override
    public void printFeedback() {

    }

    @Override
    public void printResultaat() {

    }

    @Override
    public void printOpdracht() {
        vraagStrategie.printVraag();
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Daily Scrum kamer!");
    }


}
