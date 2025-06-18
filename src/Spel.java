import java.util.ArrayList;
import java.util.List;



public class Spel {
    private ArrayList<Speler> spelers;
    private ArrayList<Kamer> kamers;


    public Spel(){
        this.spelers = new ArrayList<>();
        this.kamers = new ArrayList<>();
    }

    public void voegSpelerToe(Speler speler){
        this.spelers.add(speler);
    }

    public void voegKamerToe(Kamer kamer){
        this.kamers.add(kamer);
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }


}
