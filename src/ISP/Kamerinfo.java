package ISP;

public class Kamerinfo implements Readable, Reward{
    @Override
    public void showMessage() {
        System.out.println("De info over de kamer moet hier?");
    }

    @Override
    public void grantReward() {
        System.out.println("Hier heb je een reward");
    }
}
