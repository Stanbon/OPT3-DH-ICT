public class MonsterDraak implements Monster, AntwoordObserver {
    @Override
    public void aanval() {
        System.out.println("De draak valt aan met vuur!");
    }

    @Override
    public void vlucht() {
        System.out.println("De draak vliegt weg!");
    }

    @Override
    public void update (boolean correctAntwoord) {
        if (correctAntwoord) {
            System.out.println("De draak is verslagen!");
        } else {
            System.out.println("De draak is nog steeds in leven!");
        }
    }
}
