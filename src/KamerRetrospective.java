public class KamerRetrospective extends Kamer{
    public KamerRetrospective(String quiz, String antwoord) {
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
        System.out.println("Je gaat situaties krijgen en moet aangeven wat het team hier van kan leren");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Sprint Retrospective kamer!");
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
