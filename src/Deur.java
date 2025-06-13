public class Deur implements AntwoordObserver {
    @Override
    public void update(boolean antwoord) {
        if (antwoord) {
            openDeur();
        } else {
            sluitDeur();
        }
    }

    private void sluitDeur() {
        System.out.println("De deur is gesloten.");
    }

    private void openDeur() {
        System.out.println("De deur is geopend.");
    }
}
