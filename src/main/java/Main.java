import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Game game = new Game();
        game.createRandomGame();

        while (true) {
            game.generateGameGrid();
            game.findLife();
            game.death();
            game.birth();
            sc.nextLine();
        }
    }
}
