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
    public void controleAntwoord(String input, String correctAntwoord){
        boolean correct = input.equals(correctAntwoord);
        notifyObservers(correct);
    }
    @Override
    public void notifyObservers(boolean correct){
        for (AntwoordObserver observer : observers) {
            observer.update(correct);
        }
    }


}
