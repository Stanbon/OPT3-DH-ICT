import java.util.Scanner;

public class KamerScrumBoard extends Kamer{

    public KamerScrumBoard() {
        String vraag = "Juist of onjuist: Op een scrumboard verplaatst een taak zich van 'Te Doen' naar 'Bezig' naar 'Klaar' naarmate het werk vordert.";
        String antwoord = "Juist";
        this.vraagStrategie = new WaarOnwaarVraag(vraag, true);
    }



    @Override
    public void controleerAntwoord() {
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
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
        System.out.println("Welkom in de Scrum Board kamer!");
    }


}
