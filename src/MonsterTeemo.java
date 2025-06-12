class MonsterTeemo implements Monster, AntwoordObserver {
    @Override
    public void aanval() {
        System.out.println("Teemo steekt zijn vijand met een pijl!");
    }

    @Override
    public void vlucht() {
        System.out.println("Teemo rent snel weg in de schaduwen!");
    }

    @Override
    public void update(boolean correctAntwoord) {
        if (correctAntwoord) {
            System.out.println("Teemo is verslagen!");
        } else {
            System.out.println("Teemo is nog steeds in leven en verstopt zich!");
        }
    }
}
