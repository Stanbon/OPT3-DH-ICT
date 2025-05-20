import java.util.ArrayList;
import java.util.List;

public class AntwoordControle {
    List<AntwoordObserver> observers = new ArrayList<>();
    private boolean antwoord;


    public void voegObserverToe(AntwoordObserver observer) {
        observers.add(observer);
    }

    public void controleAntwoord(String input, String correctAntwoord){
        boolean correct = input.equals(correctAntwoord);
        notifyObservers(correct);
    }

    public void notifyObservers(boolean correct){
        for (AntwoordObserver observer : observers) {
            observer.update(correct);
        }
    }


}
