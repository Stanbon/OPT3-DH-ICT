import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Spel spel = startSpel();
        while (true){
            showPrompt();
            String input = scanner.nextLine();

            // actie van input.....
            if (input.equals("/status")) {

                System.out.println("Speler Status: " + spel.getSpelers().getFirst().getStatus());
            }

            else if (input.equals("/exit")) {
                break;
            }
            else if (input.equals ("Kamer Keuze")) {
                System.out.println("Type 'Ga naar kamer 1-5' om naar een kamer te gaan");
                Scanner Keuzes  = new Scanner(System.in);
                String keuzeInput = Keuzes.nextLine();
                Character keuzeChar = laatsteDigit(keuzeInput);
                if (keuzeChar == null) {
                    System.out.println("Ongeldige keuze. Kies een kamer tussen 1 en 5.exe");
                    continue;
                }
                switch (keuzeChar) {
                    case '1':
                    spel.getSpelers().get(0).setPositie(1);
                    spel.getKamers().get(0).startKamer();
                    break;
                    case '2':
                    spel.getSpelers().get(0).setPositie(2);
                    spel.getKamers().get(1).startKamer();
                    break;
                    case '3':
                    spel.getSpelers().get(0).setPositie(3);
                    spel.getKamers().get(2).startKamer();
                    break;
                    case '4':
                    spel.getSpelers().get(0).setPositie(4);
                    spel.getKamers().get(3).startKamer();
                    break;
                    case '5':
                    spel.getSpelers().get(0).setPositie(5);
                    spel.getKamers().get(4).startKamer();
                    break;
                    default:
                        System.out.println("Ongeldige keuze. Kies een kamer tussen 1 en 5.");
                }

            }

        }
    }







    private static Spel startSpel() {

        Spel spel = new Spel();

        Monster monster = new MonsterDraak();
        Monster monster1 = new MonsterGorilla();
        Monster monster2 = new MonsterTeemo();

        Kamer kamer = new KamerPlanning();
        Kamer kamer1 = new KamerDailyScrum();
        Kamer kamer2 = new KamerReview();
        Kamer kamer3 = new KamerScrumBoard();
        Kamer kamer4 = new KamerRetrospective();
        Kamer kamer5 = new KamerTIA();


        spel.voegKamerToe(kamer);
        spel.voegKamerToe(kamer1);
        spel.voegKamerToe(kamer2);
        spel.voegKamerToe(kamer3);
        spel.voegKamerToe(kamer4);
        spel.voegKamerToe(kamer5);



        System.out.println("Welkom in de kamers. Ik ben Kamerman, je spel leider.");
        Speler speler = new Speler(0,"Stan", "Levend", 0, 3);
        spel.voegSpelerToe(speler);
        speler.saveToDatabase();
        speler.updatePositieInDatabase(speler.getPositie());
        speler.updateLevensInDatabase(speler.getLevens());
        return spel;
    }

    private static void showPrompt() {
        System.out.println("Type /status om de status van de speler te krijgen");
        System.out.println("Type /exit om het spel te stoppen");

        System.out.println("Type 'Kamer Keuze' om naar een kamer te gaan");
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
