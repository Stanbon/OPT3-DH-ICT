import java.util.ArrayList;

public class Spel {
    private List <Speler> spelers;
    private List<Kamer> kamers;

    public void Spel(){
        this.spelers = new ArrayList<>();
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

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public List<Kamer> getKamers() {
        return kamers;
    }

    public void setKamers(List<Kamer> kamers) {
        this.kamers = kamers;
    }


}
