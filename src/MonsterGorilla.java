class MonsterGorilla implements Monster, AntwoordObserver {
    @Override
    public void update(boolean correctAntwoord) {
        if(!correctAntwoord) {
            verschijn();
        } else {
            verdwijn();
        }
    }

    @Override
    public void verschijn() {

    }

    @Override
    public void verdwijn() {

    }

    public void soort() {
        System.out.println("Ooga ooga jij hebt deze vraag fout! booga booga ");
    }
}
