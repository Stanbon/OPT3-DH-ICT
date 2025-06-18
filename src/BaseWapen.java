public abstract class BaseWapen implements Wapen {
    private final int schade;
    private final String naam;

    public BaseWapen(int schade, String naam) {
        this.schade = schade;
        this.naam = naam;
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
