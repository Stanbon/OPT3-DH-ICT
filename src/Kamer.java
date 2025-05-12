abstract class Kamer {



    protected String quiz;

    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String antwoord;



    public Kamer(String quiz, String a, String b, String c, String d, String antwoord) {
        this.quiz = quiz;

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.antwoord = antwoord;
    }

    public final void startKamer() {
        printIntroductie();
        printOpdracht();
        controleerAntwoord();
        printResultaat();
        printFeedback();
    }

    public abstract void printFeedback();

    public abstract void printResultaat();
    public abstract void printOpdracht();


    public abstract void printIntroductie();
    public  abstract void controleerAntwoord();



    public abstract boolean checkAntwoord (String userAnswer);

    public String getQuiz() {
        return quiz;
    }
    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }
    public String getAntwoord() {
        return antwoord;
    }
}
