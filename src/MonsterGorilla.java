class MonsterGorilla implements Monster, AntwoordObserver {
    @Override
    public void aanval() {
        System.out.println("De gorilla slaat met zijn krachtige vuisten!");
    }

    @Override
    public void vlucht() {
        System.out.println("De gorilla klimt snel in een boom om te ontsnappen!");
    }

    @Override
    public void update(boolean correctAntwoord) {
        if (correctAntwoord) {
            System.out.println("De gorilla is verslagen!");
        } else {
            System.out.println("De gorilla is nog steeds in leven en brult woedend!");
        }
    }
}

