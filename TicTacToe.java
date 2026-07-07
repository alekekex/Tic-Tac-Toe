import java.util.Scanner;
import java.util.Random;

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
        Random rnd = new Random();
        b.initializeBoard();

        while(!isGameOver) {
            System.out.println();
            b.displayBoard();
            System.out.println(p[playerIdx].getName() + "\'s turn (" + p[playerIdx].getM().getSymbol() + ")");
            boolean isValid = false;
            int row, column;

            if(p[playerIdx].isAI()) {
                System.out.println(p[playerIdx].getName() + " is thinking...");

                try {
                    Thread.sleep(1500);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            while(!isValid) {
                if(p[playerIdx].isAI()) {
                    row = rnd.nextInt(MAX) + MIN;
                    column = rnd.nextInt(MAX) + MIN;
                }
                else {
                    System.out.println("Enter row (Range 1-3)");
                    row = Input.getIntChoice(sc, MIN, MAX);
                    System.out.println("Enter column (Range 1-3)");
                    column = Input.getIntChoice(sc, MIN, MAX);
                }

                isValid = b.placeMarker(p[playerIdx].getM(), row, column);

                if(isValid)
                    System.out.println("Move: (" + row + "," + column + ")");
                else if (!(p[playerIdx].isAI()))
                    System.out.println("That spot is already taken! Try again.");
            }


            if(b.isWinner(p[playerIdx].getM()) || b.isBoardFull())
                isGameOver = true;
            else switchTurn();
        }

        if(isGameOver) {
            System.out.println();
            System.out.println(">>> GAME OVER <<<");
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
