import java.util.List;

public class FunnyHintProvider extends BaseHintProvider {
    public FunnyHintProvider() {
        super(
                List.of("Heb je ooit geprobeerd links te kijken?", "Misschien helpt een dansje."),
                "Wil je een hint? Ja/Nee"
        );
    }
}


