package ISP;

public class Medicijn implements Wapen, Beloning{

    int herstel = 100;
    int HP = 0; // Medicijn heeft geen eigen HP, maar herstelt HP van de speler

    @Override
    public void ontvangBeloning() {
        System.out.println("Beloning Medicijn gegeven.");
    }
    @Override

    public int geefSchade() {
        return 25; // Medicijn doet geen schade, maar herstelt HP
    }

    public int herstelHP(int HP, int herstel) {
        int nieuweHP = HP + herstel;
        System.out.println("Medicijn herstelt " + herstel + " HP. Nieuwe HP: " + nieuweHP);
        return nieuweHP;
    }

    @Override
    public String voorwerpNaam() {
        return "Medicijn";
    }
}
