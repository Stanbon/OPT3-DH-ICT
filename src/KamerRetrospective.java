public class KamerRetrospective extends Kamer{


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
        System.out.println("Geef antwoord op de volgende vraag:");
        System.out.println("Wat is het doel van een retrospective?");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Sprint Retrospective kamer!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer, String goedeAntwoord) {
        return false;
    }
}
