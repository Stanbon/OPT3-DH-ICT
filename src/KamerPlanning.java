import java.util.Scanner;

class KamerPlanning extends Kamer {


    public KamerPlanning(){
        String vraag = "Vul in:\nTijdens de sprint planning selecteert het team items uit de _______ _______ " +
                "om tijdens de sprint aan te werken.";
        String antwoord = "Product Backlog";
        this.vraagStrategie = new OpenVraag(vraag, antwoord);
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
        System.out.println("Welkom in de kamer van de Sprint Planning!");
    }


}
