import java.util.Scanner;

public class TicTacToe {
    private static final int MAX_PLAYERS = 2;
    private Board b;
    private Player[] p;
    private boolean isXTurn;
    private boolean isGameOver;

    public TicTacToe() {
        this.b = new Board();
        this.p = new Player[MAX_PLAYERS];
        this.isXTurn = true;
        this.isGameOver = false;
    }

    public void playGame(Scanner sc) {
        //main game logic
    }

    public char getCharInput(Scanner sc) {
        char c;

        do {
            c = Character.toUpperCase(sc.nextLine().charAt(0));

            if(!(c == 'X' || c == 'O'))
                System.out.println("Invalid input! Please enter X or O only.");
        } while(!(c == 'X' || c == 'O'));

        return c;
    }
}
