public class KamerTIA extends Kamer{

    public KamerTIA(String quiz, String antwoord) {
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
        System.out.println("Wat is de rol van de TIA in het Scrum proces?");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de kamer van de TIA!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer) {
        return false;
    }

    @Override
    public boolean kanKeyJokerGebruiken(){
        return false;
    }
}

