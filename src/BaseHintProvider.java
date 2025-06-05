import java.util.List;
import java.util.Random;

public abstract class BaseHintProvider implements HintProvider {
    protected final List<String> hints;
    private final Random random = new Random();

    public BaseHintProvider(List<String> hints) {
        this.hints = hints;
    }

    @Override
    public void geefHint() {
        System.out.println("Hint: " + hints.get(random.nextInt(hints.size())));
    }
}
