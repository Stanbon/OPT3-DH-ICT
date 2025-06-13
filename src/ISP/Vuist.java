package ISP;

public class Vuist implements Wapen, Beloning{
    @Override
    public void ontvangBeloning() {
        System.out.println("Speler begint met hun vuisten.");
    }

    @Override
    public int geefSchade() {
        return 10;
    }

    @Override
    public String voorwerpNaam() {
        return "Vuist";
    }
}
