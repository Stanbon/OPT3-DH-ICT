import java.util.List;
import java.util.Random;

public class HintSelector {
    private static final Random random = new Random();


    public static HintProvider kiesHintUitLijst(List<HintProvider> hints) {
        return hints.get(random.nextInt(hints.size()));
    }
}
