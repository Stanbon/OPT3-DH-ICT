public interface Antwoord {
    void voegObserverToe(AntwoordObserver observer);
    void controleAntwoord(String input, String correctAntwoord);
    void notifyObservers(boolean correctAntwoord);
}
