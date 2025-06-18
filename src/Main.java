
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Spel spel = startSpel();
        while (true) {
            showPrompt();
            String input = scanner.nextLine();


            if (input.equals("/status")) {

                System.out.println("Speler status is " + spel.getSpelers().getFirst().getStatus() + " met HP: " + spel.getSpelers().getLast().getHP());
            } else if (input.equals("/exit")) {
                break;
            } else if (input.equalsIgnoreCase("Kamer Keuze")) {
                System.out.println("Type 'Ga naar kamer 1-6' om naar een kamer te gaan, De Zesde kamer gaat alleen open na de eerste vijf...");
                Scanner Keuzes = new Scanner(System.in);
                String keuzeInput = Keuzes.nextLine();
                Character keuzeChar = laatsteDigit(keuzeInput);
                if (keuzeChar == null) {
                    System.out.println("Ongeldige keuze. Kies een kamer tussen 1 en 6");
                    continue;
                }
                switch (keuzeChar) {
                    case '1':
                        spel.getSpelers().get(0).setPositie(1);
                        spel.getKamers().get(0).startKamer(spel.getSpelers().get(0));
                        spel.getSpelers().get(0).markeerVoltooid(0);
                        break;
                    case '2':
                        spel.getSpelers().get(0).setPositie(2);
                        spel.getKamers().get(1).startKamer(spel.getSpelers().get(0));
                        spel.getSpelers().get(0).markeerVoltooid(1);
                        break;
                    case '3':
                        spel.getSpelers().get(0).setPositie(3);
                        spel.getKamers().get(2).startKamer(spel.getSpelers().get(0));
                        spel.getSpelers().get(0).markeerVoltooid(2);
                        break;
                    case '4':
                        spel.getSpelers().get(0).setPositie(4);
                        spel.getKamers().get(3).startKamer(spel.getSpelers().get(0));
                        spel.getSpelers().get(0).markeerVoltooid(3);
                        break;
                    case '5':
                        spel.getSpelers().get(0).setPositie(5);
                        spel.getKamers().get(4).startKamer(spel.getSpelers().get(0));
                        spel.getSpelers().get(0).markeerVoltooid(4);
                        break;
                    case '6':
                        if (spel.getSpelers().get(0).zijnKamersVoltooid()) {
                         spel.getSpelers().get(0).setPositie(6);
                         spel.getKamers().get(5).startKamer(spel.getSpelers().get(0));
                         spel.getSpelers().get(0).markeerVoltooid(5); }
                         else { System.out.println("Je moet kamer 1 tot 5 voltooid hebben voordat je kamer 6 in kan"); }
                    default:
                        System.out.println("Ongeldige keuze. Kies een kamer tussen 1 en 6.");
                }

            }

        }
    }







    private static Spel startSpel() {

        Spel spel = new Spel();

        System.out.println("Welkom in de kamers. Ik ben Kamerman, je spel leider.");
        System.out.println("Vul je naam in om te beginnen:");
        Scanner scanner = new Scanner(System.in);
        String naam = scanner.nextLine().trim();

        Speler speler = SpelerDatabase.createSpeler(naam);

        spel.voegSpelerToe(speler);
        CombatStrategy strategy = new TurnBasedCombat();


        Kamer kamer = new KamerPlanning(speler, strategy);
        Kamer kamer1 = new KamerDailyScrum(speler, strategy);
        Kamer kamer2 = new KamerReview(speler, strategy);
        Kamer kamer3 = new KamerScrumBoard(speler, strategy);
        Kamer kamer4 = new KamerRetrospective(speler, strategy);
        Kamer kamer5 = new KamerTIA(speler, strategy);


        spel.voegKamerToe(kamer);
        spel.voegKamerToe(kamer1);
        spel.voegKamerToe(kamer2);
        spel.voegKamerToe(kamer3);
        spel.voegKamerToe(kamer4);
        spel.voegKamerToe(kamer5);

        return spel;
    }

    private static void showPrompt() {
        System.out.println("Type /status om de status van de speler te krijgen");
        System.out.println("Type /exit om het spel te stoppen");

        System.out.println("Type 'Kamer Keuze' om naar een kamer te gaan");
        System.out.println("Type '/joker' in een kamer als je vast zit in een kamer");
    }

    public static Character laatsteDigit(String keuze) {
        for (int i = keuze.length() - 1; i >= 0; i--) {
            char teken = keuze.charAt(i);
            if (Character.isDigit(teken)) {
                return teken;

            }
        }
        return null;
    }
}





