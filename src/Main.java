import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Spel spel = startSpel();
        showPrompt(spel);
        // input ......
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // actie van input.....
        if (input.equals("/status")) {

            System.out.println("Speler Status: " + spel.getSpelers().getFirst().getStatus());

        }

    }



    private static Spel startSpel() {

        Spel spel = new Spel();

        Monster monster = new Monster("Draak");
        Monster monster1 = new Monster("Gorilla");
        Monster monster2 = new Monster("Teemo");


        Kamer kamer = new KamerPlanning("Wat is de hoofdstad van Frankrijk?", monster, "A) Parijs", "B) Londen", "C) Rome", "D) Berlijn", "A");
        Kamer kamer1 = new KamerReview("Is de aarde plat?", monster1, "A) Ja", "B) Nee", "", "", "A");

        spel.voegKamerToe(kamer);
        spel.voegKamerToe(kamer1);


        System.out.println("Welkom in de kamers. Ik ben Kamerman, je spel leider.");
        Speler speler = new Speler(0,"Stan", "Levend", 0, 3);
        spel.voegSpelerToe(speler);
        return spel;
    }

    private static void showPrompt(Spel spel) {
        System.out.println("Type /status om de status van de speler te krijgen");
    }
}
