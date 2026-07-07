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
        b.initializeBoard();

        while(!isGameOver) {
            displayGameState();
            makeTurn(sc, checkIfAI());
            isGameOver = checkIfGameOver();
        }

        if(isGameOver)
            displayGameOver();
    }

    public void displayGameState() {
        System.out.println();
        b.displayBoard();
        System.out.println(p[playerIdx].getName() + "\'s turn (" + p[playerIdx].getM().getSymbol() + ")");
    }

    public boolean checkIfAI() {
        boolean isAI = false;

        if(p[playerIdx].isAI()) {
            isAI = true;
            System.out.println(p[playerIdx].getName() + " is thinking...");

            try {
                Thread.sleep(1500);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return isAI;
    }

    public void makeTurn(Scanner sc, boolean isAI) {
        Random rnd = new Random();
        boolean isValid = false;
        int r, c;

        while(!isValid) {
            if(isAI) {
                r = rnd.nextInt(MAX) + MIN;
                c = rnd.nextInt(MAX) + MIN;
            }
            else {
                System.out.println("Enter row (Range 1-3)");
                r = Input.getIntChoice(sc, MIN, MAX);
                System.out.println("Enter column (Range 1-3)");
                c = Input.getIntChoice(sc, MIN, MAX);
            }

            isValid = b.placeMarker(p[playerIdx].getM(), r, c);

            if(isValid)
                System.out.println("Move: (" + r + "," + c + ")");
            else if (!(p[playerIdx].isAI()))
                System.out.println("That spot is already taken! Try again.");
        }
    }

    public void switchTurn() {
        playerIdx = 1 - playerIdx;
    }

    public boolean checkIfGameOver() {
        boolean isGameOver = false;

        if(b.isWinner(p[playerIdx].getM()) || b.isBoardFull())
            isGameOver = true;
        else switchTurn();

        return isGameOver;
    }

    public void displayGameOver() {
        System.out.println();
        System.out.println(">>> GAME OVER <<<");
        b.displayBoard();

        if(b.isWinner(p[playerIdx].getM()))
            System.out.println(p[playerIdx].getName() + " has won the game!\n");
        else System.out.println("It's a tie!\n");
    }
}
