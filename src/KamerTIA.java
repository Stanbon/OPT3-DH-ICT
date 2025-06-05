public class KamerTIA extends Kamer{



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
        System.out.println("Ja of Nee:");
        System.out.println("Zijn de drie pijlers van scrum onderling " +
                "afhankelijk en noodzakelijk voor empirische proc   escontrole?");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de kamer van de TIA!");
    }

    @Override
    public boolean checkAntwoord(String userAnswer, String goedeAntwoord) {
        return false;
    }
}
