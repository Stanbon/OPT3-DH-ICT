package ISP;

public class Medicijn implements Geneesmiddel, Beloning {

    public int herstel = 100;
    int HP = 0; // Medicijn heeft geen eigen HP, maar herstelt HP van de speler

    @Override
    public void ontvangBeloning() {
        System.out.println("Beloning Medicijn gegeven.");
    }


    @Override
    public int herstelHP(int huidigeHP, int herstel) {
        return 100 + huidigeHP; // Medicijn herstelt 100 HP
    }

    @Override
    public String voorwerpNaam() {
        return "Medicijn";
    }
}
