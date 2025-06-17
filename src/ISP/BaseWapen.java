package ISP;

public abstract class BaseWapen implements Wapen, Beloning {
    protected final int schade;
    protected final String naam;

    public BaseWapen(String naam, int schade) {
        this.naam = naam;
        this.schade = schade;
    }

    @Override
    public void ontvangBeloning() {
        System.out.println("Beloning " + naam + " gegeven.");
    }

    @Override
    public int geefSchade() {
        return schade;
    }

    @Override
    public String voorwerpNaam() {
        return naam;
    }
}
