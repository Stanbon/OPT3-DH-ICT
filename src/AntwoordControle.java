import java.util.ArrayList;
import java.util.List;

public class AntwoordControle implements Antwoord {
    List<AntwoordObserver> observers = new ArrayList<>();



    @Override
    public void voegObserverToe(AntwoordObserver observer) {
        observers.add(observer);
    }

    @Override
    public void verwijderObserver(AntwoordObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(boolean correct){
        for (AntwoordObserver observer : observers) {
            observer.update(correct);
        }
    }



    public void controleAntwoord(String antwoord, VraagStrategie vraagStrategie) {
        boolean isCorrect = vraagStrategie.controleerAntwoord(antwoord);
        notifyObservers(isCorrect);
    }
}
