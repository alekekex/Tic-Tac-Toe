import java.util.Scanner;

public class TicTacToe {
    private static final int MAX_PLAYERS = 2;
    private static final int MIN = 1;
    private static final int MAX = 3;
    private Board b;
    private Player[] p;
    private int playerIdx;
    private boolean isGameOver;

    public TicTacToe(Player p1, Player p2) {
        this.b = new Board();
        this.p = new Player[MAX_PLAYERS];
        this.p[0] = p1;
        this.p[1] = p2;
        this.playerIdx = 0;
        this.isGameOver = false;
    }

    public void playGame(Scanner sc) {
        b.initializeBoard();

        while(!isGameOver) {
            System.out.println();
            System.out.println(p[playerIdx].getName() + "\'s turn (" + p[playerIdx].getM().getSymbol() + ")");
            b.displayBoard();
            boolean isAvailable = false;

            while(!isAvailable) {
                System.out.println("Enter row (Range 1-3)");
                int row = Input.getIntChoice(sc, MIN, MAX);
                System.out.println("Enter column (Range 1-3)");
                int column = Input.getIntChoice(sc, MIN, MAX);
                isAvailable = b.placeMarker(p[playerIdx].getM(), row, column);

                if(!isAvailable)
                    System.out.println("That spot is already taken! Try again.");
            }

            if(b.isWinner(p[playerIdx].getM()) || b.isBoardFull())
                isGameOver = true;
            else switchTurn();
        }

        if(isGameOver) {
            System.out.println();
            System.out.println("Game Over!");
            b.displayBoard();

            if(b.isWinner(p[playerIdx].getM()))
                System.out.println(p[playerIdx].getName() + " has won the game!\n");
            else System.out.println("It's a tie!\n");
        }
    }

    public void switchTurn() {
        playerIdx = 1 - playerIdx;
    }
}
