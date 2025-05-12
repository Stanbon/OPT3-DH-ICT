class KamerReview extends Kamer {
    public KamerReview(String quiz, Monster obstakel, String a, String b, String c, String d, String antwoord) {
        super(quiz, obstakel, a, b, c, d, antwoord);
    }

    @Override
    public boolean checkAntwoord (String userAnswer) {
        return userAnswer.equals(antwoord);
    }
}