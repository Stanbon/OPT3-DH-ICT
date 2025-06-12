public class DeurBeweging implements AntwoordObserver {
    private boolean open;

    @Override
    public void update(boolean correct) {
        if (correct) open();
        else dicht();
    }

    public void open() {
        open = true;
        System.out.println("De deur is geopend.");
    }

    public void dicht() {
        open = false;
        System.out.println("De deur is gesloten.");
    }
}
