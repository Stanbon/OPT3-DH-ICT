import java.util.ArrayList;
import java.util.List;

public class AntwoordControle implements Antwoord {
    List<AntwoordObserver> observers = new ArrayList<>();
    private boolean antwoord;


    @Override
    public void voegObserverToe(AntwoordObserver observer) {
        observers.add(observer);
    }

    @Override
    public void controleAntwoord(String input, VraagStrategie strategie) {
        boolean correct = strategie.controleerAntwoord(input);
        notifyObservers(correct);
    }

    @Override
    public void notifyObservers(boolean correct){
        for (AntwoordObserver observer : observers) {
            observer.update(correct);
        }
    }


}
