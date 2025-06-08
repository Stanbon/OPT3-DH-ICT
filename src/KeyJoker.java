class KeyJoker extends Joker{
    protected boolean gebruikt = false;

    @Override void useIn(Kamer kamer) {
        if (!gebruikt) {
            if (kamer.kanKeyJokerGebruiken()) {
                System.out.println("Extra Key gekregen!");
                gebruikt = true;
                // add extra key code

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
