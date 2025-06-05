import java.util.List;

public class HelpHintProvider extends BaseHintProvider {
    public HelpHintProvider() {
        super(List.of(
                "Kijk goed naar de volgorde van de symbolen op de muur."
        ));
    }

    @Override
    public void vraagHint() {
        System.out.println("Wil je een hint?");
    }
}
