public class AntwoordLogger implements AntwoordObserver {

    @Override
    public void update(boolean correctAntwoord) {
        if (correctAntwoord) {
            System.out.println("Dat is correct!");
        } else {
            System.out.println("Dat is incorrect!");
        }
    }
}
