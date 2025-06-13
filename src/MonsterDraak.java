class MonsterDraak implements Monster, AntwoordObserver {
    public void soort() {
        System.out.println("FOUTTTTTTTTTTTTTTTTT!!!!!!!!!");
    }

    @Override
    public void verschijn() {

    }

    @Override
    public void verdwijn() {

    }

    @Override
    public void update(boolean correctAntwoord) {
        if (!correctAntwoord) {
            verschijn();
        } else {
            verdwijn();
        }
    }
}
