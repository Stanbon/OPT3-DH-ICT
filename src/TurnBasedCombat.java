public class TurnBasedCombat implements CombatStrategy {

    @Override
    public void startCombat(Vechten speler, Monster monster) {
        System.out.println("Gevecht start tussen " + speler.getNaam() + " en " + monster.getNaam() + "!");
        monster.verschijn();

        while (!speler.isVerslagen() && !monster.isVerslagen()) {
            spelerTurn(speler, monster);
            if (monster.isVerslagen()) {
                System.out.println(monster.getNaam() + " is verslagen! Gevecht voorbij.");
                break;
            }

            monsterTurn(monster, speler);
            if (speler.isVerslagen()) {
                System.out.println(speler.getNaam() + " is verslagen! Gevecht voorbij.");
            }
        }

        monster.verdwijn();
    }

    private void spelerTurn(Vechten speler, Monster monster) {
        speler.valAan(monster);
    }

    private void monsterTurn(Monster monster, Vechten speler) {
        monster.valAan(speler);
    }
}
