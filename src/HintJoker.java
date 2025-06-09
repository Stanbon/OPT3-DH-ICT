class HintJoker implements Joker {
    protected boolean gebruikt = false;

    @Override
    public void useIn(Kamer kamer) {
        if (!gebruikt) {
            System.out.println("Kamer wordt geskipped");
            gebruikt = true;
            // (zet de skip mechanisme hier)
        }
        else {
            System.out.println("Je hebt je hint al gebruikt");
        }
    }
}
