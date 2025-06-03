package ISP;

public class Zwaard implements Weapon, Reward{
    @Override
    public void attack() {
        System.out.println("Valt aan met zwaard");
    }

    @Override
    public void grantReward() {
        System.out.println("Reward Zwaard granted");
    }
}
