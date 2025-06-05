import java.util.List;
import java.util.Random;

public class HintSelector {
    private static final Random random = new Random();

    // Kies een willekeurige HintProvider uit een lijst
    public static HintProvider kiesHintUitLijst(List<HintProvider> hints) {
        return hints.get(random.nextInt(hints.size()));
    }
}
