package ISP;

public class Kamerinfo implements Readable, Beloning{
    @Override
    public void showMessage() {
        System.out.println("?");
    }

    @Override
    public void ontvangBeloning() {
        System.out.println("Hier heb je een beloning");
    }
}
