import java.util.Scanner;
public class Main {
    private static Speler speler;
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
                Character keuze = laatsteDigit(Keuzes.nextLine());
                switch (keuze) {
                    case 1: speler.setPositie(1);
                    System.out.println("Je bent nu in kamer 1");
                    case 2: speler.setPositie(2);
                    System.out.println("Je bent nu in kamer 2");
                    case 3: speler.setPositie(3);
                    System.out.println("Je bent nu in kamer 3");
                    case 4: speler.setPositie(4);
                    System.out.println("Je bent nu in kamer 4");
                    case 5: speler.setPositie(5);
                    System.out.println("Je bent nu in kamer 5");
                }

            }

        }
        }







    private static Spel startSpel() {

        Spel spel = new Spel();

        Monster monster = new MonsterDraak();
        Monster monster1 = new MonsterGorilla();
        Monster monster2 = new MonsterTeemo();

        Kamer kamer = new KamerPlanning("Welke taken passen bij de Sprint Planning?", "Sprint Planning");
        Kamer kamer1 = new KamerDailyScrum("Wie geeft welke status update?", "Daily Scrum");
        Kamer kamer2 = new KamerReview("Interpreteer de feedback van de stekeholders en schat de impact er van in", "Sprint Review");
        Kamer kamer3 = new KamerScrumBoard("Richt de Scrum Board in met de juiste items.", "Scrum Board");
        Kamer kamer4 = new KamerTIA("Wat is de rol van de TIA in het Scrum proces?", "Scrum TIA");
        Kamer kamer5 = new KamerRetrospective("Je gaat situaties krijgen en moet aangeven wat het team hier van kan leren", "Sprint Retrospective");


        spel.voegKamerToe(kamer);
        spel.voegKamerToe(kamer1);
        spel.voegKamerToe(kamer2);
        spel.voegKamerToe(kamer3);
        spel.voegKamerToe(kamer4);
        spel.voegKamerToe(kamer5);



        System.out.println("Welkom in de kamers. Ik ben Kamerman, je spel leider.");
        Speler speler = new Speler(0,"Stan", "Levend", 0, 3);
        spel.voegSpelerToe(speler);
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
