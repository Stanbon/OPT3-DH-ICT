import ISP.Wapen;

public class Speler implements Vechten {
    private int id;
    private String naam;
    private String status;
    private int positie;
    private int levens;
    private int HP;
    private Wapen wapen;

    public Speler(int id, String naam, String status, int positie, int levens, int HP, Wapen wapen) {
        this.id = id;
        this.naam = naam;
        this.status = HP > 0 ? "levend" : "dood";
        this.positie = positie;
        this.levens = levens;
        this.HP = HP;
        this.wapen = wapen;
    }

    public String getStatus() {  return status; }

    public int getLevens() { return levens; }

    public int getPositie() { return positie; }

    public int setPositie(int newPositie) { return this.positie = newPositie;}

    public int getHP() { return HP; }
    
    public Wapen getWapen() { return wapen; }

    @Override
    public String getNaam() { return naam; }

    @Override
    public boolean isVerslagen() { return HP <= 0; }

    @Override
    public void valAan(Vechten doel) {
        int schade = wapen.geefSchade();
        System.out.println(naam + " valt " + doel.getNaam() + " aan met " + wapen.voorwerpNaam() + " en doet " + schade + " schade.");
        doel.ontvangSchade(schade);
    }

    @Override
    public void ontvangSchade(int schade) {
        HP -= schade;
        if (HP < 0) HP = 0;
        status = HP > 0 ? "Levend" : "Dood";
        System.out.println(naam + " ontvangt " + schade + " schade! HP over: " + HP);
        if (HP == 0) System.out.println(naam + " is overleden!");
    }

}
