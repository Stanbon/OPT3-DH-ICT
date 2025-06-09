public interface Antwoord {
    void voegObserverToe(AntwoordObserver observer);
    void controleAntwoord(String input, VraagStrategie vraagStrategie);
    void notifyObservers(boolean correctAntwoord);
}
