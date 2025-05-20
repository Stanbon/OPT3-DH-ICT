class Monsters {
    protected Monster monsterSoort;

    public Monsters(Monster monsterSoort) {
        this.monsterSoort = monsterSoort;
    }
    public void soort() {
        monsterSoort.soort(); // polymorfisme
    }
}