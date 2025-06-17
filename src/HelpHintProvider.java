import java.util.List;

public class HelpHintProvider extends BaseHintProvider {
    public HelpHintProvider() {
        super(
                List.of("Denk aan de Daily Scrum.", "Wat was het doel van die artefact ook alweer?"),
                "Wil je een hint? Ja/Nee"
        );
    }
}