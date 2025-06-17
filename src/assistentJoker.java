class assistentJoker implements Joker {

    @Override
    public void useIn(Kamer kamer) {
        if (kamer.kanAssistentJokerGebruiken()) {
            kamer.assistentieActivatie();
        }
        else {
            System.out.println("Assistent Joker kan niet gebruikt worden in deze kamer");
        }
    }
}
