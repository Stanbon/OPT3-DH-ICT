import java.util.List;

public class FunnyHintProvider extends BaseHintProvider {
    public FunnyHintProvider() {
        super(
                List.of("Heb je ooit geprobeerd links te kijken?", "Misschien helpt een dansje.", "Of je kunt gewoon de deur uitlopen.", "Of je kunt gewoon gokken, dat werkt ook soms.","Waarom niet gewoon alles proberen?"),
                "Wil je een hint? Ja/Nee"
        );
    }
}


