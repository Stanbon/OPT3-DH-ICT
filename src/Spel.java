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

    public void verwijderSpeler(Speler speler){
        this.spelers.remove(speler);
    }

    public void voegKamerToe(Kamer kamer){
        this.kamers.add(kamer);
    }

    public void verwijderKamer(Kamer kamer){
        this.kamers.remove(kamer);
    }





    public void startSpel(){
        System.out.println("Het spel is gestart!");
    }

    public void stopSpel(){
        System.out.println("Het spel is gestopt!");
    }


}
