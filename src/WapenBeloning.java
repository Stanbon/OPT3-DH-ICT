public class WapenBeloning implements Beloning {
    private Wapen nieuwWapen;

    public WapenBeloning (Wapen nieuwWapen){
        this.nieuwWapen = nieuwWapen;
    }

    @Override
    public void pasToeOp (Speler speler){
        speler.setWapen(nieuwWapen);
        System.out.println("Je hebt een nieuw wapen gekregen: " + nieuwWapen.voorwerpNaam());
    }
}
