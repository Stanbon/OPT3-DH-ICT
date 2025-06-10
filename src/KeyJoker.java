class KeyJoker implements Joker{
    protected boolean gebruikt = false;

    @Override
    public void useIn(Kamer kamer) {
        if (!gebruikt) {
            if (kamer.kanKeyJokerGebruiken()) {
                System.out.println("Extra Key gekregen!");
                System.out.println("Kamer wordt overgeslagen!");
                kamer.markeerAlsCorrect();
                gebruikt = true;
            }
            else {
                System.out.println("De KeyJoker werkt niet :(");
            }
        }
        else {
            System.out.println("Geen keyjoker meer :(");
        }
    }
}
