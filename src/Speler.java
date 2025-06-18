

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

    public int setPositie(int newPositie) { return this.positie = newPositie;}

    public int getHP() { return HP; }


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

    private boolean[] voltooideKamers = new boolean[6];

    public void markeerVoltooid(int kamerIndex) {
        if (kamerIndex >= 0 && kamerIndex < voltooideKamers.length) {
            voltooideKamers[kamerIndex] = true;
        }
    }


    public boolean zijnKamersVoltooid() {
        for (int i = 0; i <= 4; i++) {
            if (!voltooideKamers[i]) {
                return false;
            }
        }
        return true;
    }

    public void heal(int amount) {
        HP += amount;
        if (HP > 100) HP = 100;
        System.out.println(naam + " is nu op " + HP + " HP.");
    }

    public void setWapen(Wapen wapen) {
        this.wapen = wapen;
    }



}
