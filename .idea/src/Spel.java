import java.util.ArrayList;
import java.util.List;

public class Spel {
    private ArrayList<Speler> spelers;
    private ArrayList<Kamer> kamers;


    public Spel(){
        this.spelers = new ArrayList<Speler>();
        this.kamers = new ArrayList<>();
    }


    public void voegSpelerToe(Speler speler){
        this.spelers.add(speler);
    }

    public void voegKamerToe(Kamer kamer){
        this.kamers.add(kamer);
    }

    public void startSpel(){
        System.out.println("Het spel is gestart!");
    }

    public void stopSpel(){
        System.out.println("Het spel is gestopt!");
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public void setKamers(ArrayList<Kamer> kamers) {
        this.kamers = kamers;
    }


}
