import java.util.Scanner;

public class KamerTIA extends Kamer{

    public KamerTIA() {
        String vraag = "Ja of Nee: Zijn de drie pijlers van scrum onderling afhankelijk en noodzakelijk voor empirische procescontrole?";
        boolean antwoord = true; // Ja
        this.vraagStrategie = new WaarOnwaarVraag(vraag, antwoord);
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
        System.out.println("Welkom in de kamer van de TIA!");
    }


}
