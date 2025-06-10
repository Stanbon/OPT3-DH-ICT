class HintJoker implements Joker {
    protected boolean gebruikt = false;

    @Override
    public void useIn(Kamer kamer) {
        if (!gebruikt) {
            kamer.activeerKeyHint();
            gebruikt = true;
        }
        else {
            System.out.println("Je hebt je hint al gebruikt");
        }
    }
}
