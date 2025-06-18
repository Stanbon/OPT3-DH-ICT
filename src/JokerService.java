import java.util.Scanner;

public class JokerService {

    public void gebruikJoker(Kamer kamer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke joker wil je gebruiken?");
        System.out.println("1. HintJoker");
        System.out.println("2. KeyJoker");
        System.out.println("3. AssistentJoker");

        String keuze = scanner.nextLine().trim();
        switch (keuze) {
            case "1" -> kamer.hintJoker.useIn(kamer);
            case "2" -> {
                if (kamer.kanKeyJokerGebruiken()) {
                    kamer.keyJoker.useIn(kamer);
                } else {
                    System.out.println("KeyJoker is niet beschikbaar in deze kamer.");
                }
            }
            case "3" -> {
                if (kamer.kanAssistentJokerGebruiken()) {
                    kamer.assistentJoker.useIn(kamer);
                } else {
                    System.out.println("AssistentJoker is niet beschikbaar.");
                }
            }
            default -> System.out.println("Ongeldige keuze.");
        }
    }
}