public class MonsterGorilla implements Monster, AntwoordObserver {

    private int hp = 80;
    private final String naam = "Gorilla";
    private boolean verslagen = false;
    private final int schadeWaarde = 12;

    @Override
    public void update(boolean correctAntwoord) {
        if (!correctAntwoord) {
            verschijn();
        } else {
            verdwijn();
        }
    }

    @Override
    public void verschijn() {
        System.out.println(naam + " verschijnt in de kamer!");
    }

    @Override
    public void verdwijn() {
        System.out.println(naam + " verdwijnt uit de kamer!");
    }

    @Override
    public int getHP() { return hp;}

    @Override
    public String getNaam() { return naam; }

    @Override
    public void ontvangSchade(int schade) {
        hp -= schade;
        if (hp < 0) hp = 0;
        System.out.println(naam + " ontvangt " + schade + " schade! HP over: " + hp);
        if (hp == 0) {
            verslagen = true;
            System.out.println(naam + " is verslagen!");
        }
    }

    @Override
    public void valAan(Vechten doel) {
        System.out.println(naam + " valt " + doel.getNaam() + " aan en doet " + schadeWaarde + " schade!");
        doel.ontvangSchade(schadeWaarde);
    }

    @Override
    public boolean isVerslagen() {
        return verslagen;
    }

}
