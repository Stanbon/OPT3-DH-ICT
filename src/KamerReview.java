class KamerReview extends Kamer {


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
        System.out.println("Waar of niet waar:" +
                "\nDe Sprint Review is vooral een statusvergadering waarin teamleden rapporteren " +
                "wat ze tijdens de sprint hebben gedaan.  ");
    }

    @Override
    public void printIntroductie() {
        System.out.println("Welkom in de Sprint Review kamer!");
    }

    @Override
    public boolean checkAntwoord (String userAnswer, String goedeAntwoord) {
        return false;
    }
}