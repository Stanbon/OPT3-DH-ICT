import java.util.List;
import java.util.Random;

public abstract class BaseHintProvider implements HintProvider {
    protected final List<String> hints;
    protected final String vraagTekst;
    private final Random random = new Random();

    public BaseHintProvider(List<String> hints, String vraagTekst) {
        this.hints = hints;
        this.vraagTekst = vraagTekst;
    }

    @Override
    public void vraagHint() {
        System.out.println(vraagTekst);
    }

    @Override
    public void geefHint() {
        System.out.println("Hint: " + hints.get(random.nextInt(hints.size())));
    }
}
