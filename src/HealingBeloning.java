public class HealingBeloning implements Beloning{
    private int hoeveelheid;

    public HealingBeloning (int hoeveelheid){
        this.hoeveelheid = hoeveelheid;
    }

    @Override
    public void pasToeOp (Speler speler){
        speler.heal(hoeveelheid);
        System.out.println("Je bent genezen met " + hoeveelheid + " HP.");
    }
}
