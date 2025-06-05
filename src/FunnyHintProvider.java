import java.util.List;

public class FunnyHintProvider extends BaseHintProvider {
    public FunnyHintProvider() {
        super(List.of(
                "Kijk goed naar de volgorde van de symbolen op de muur."
        ));
    }

    @Override
    public void vraagHint() {
        System.out.println("Wil je een hint?");
    }
}
