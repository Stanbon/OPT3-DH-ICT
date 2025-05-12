class monsters  {
    protected Monster monsterSoort;

    public monsters(Monster monsterSoort) {
        this.monsterSoort = monsterSoort;
    }
    public void soort() {
        monsterSoort.soort(); // polymorfisme
    }
}