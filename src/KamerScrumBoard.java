public class KamerScrumBoard extends Kamer{




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
        System.out.println("Juist of onjuist:");
        System.out.println("Op een scrumboard verplaatst een taak zich van 'Te Doen'" +
                "naar 'Bezig' naar 'Klaar' naarmate het werk vordert.");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Scrum Board kamer!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer, String goedeAntwoord) {
        return false;
    }
}
