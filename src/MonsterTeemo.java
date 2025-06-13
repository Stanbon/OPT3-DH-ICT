class MonsterTeemo implements Monster, AntwoordObserver {
    public void soort() {
        System.out.println("Surprise!! Laten we later weer spelen!");
    }

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
}
