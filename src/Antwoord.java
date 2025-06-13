public interface Antwoord {

    void voegObserverToe(AntwoordObserver observer);
    void notifyObservers(boolean correctAntwoord);
    void verwijderObserver(AntwoordObserver observer);
}
