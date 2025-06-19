import java.util.List;

public class HelpHintProvider extends BaseHintProvider {
    public HelpHintProvider() {
        super(
                List.of("Denk aan de Daily Scrum.", "Wat was het doel van die artefact ook alweer?", "Misschien helpt het om te denken aan de Scrum Guide.", "Probeer te focussen op de samenwerking binnen het team.", "Wat zou je teamleider zeggen?", "Misschien is het handig om te denken aan de rollen binnen Scrum.", "Wat zou de Product Owner doen in deze situatie?"),
                "Wil je een hint? Ja/Nee"
        );
    }
}