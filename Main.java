import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            displayMenu();
            int choice = Input.getIntChoice(sc, 1, 3);
            boolean canPlay = false;
            Player p1 = null;
            Player p2 = null;

            switch(choice) {
                case 1:
                    p1 = new Player("Player 1", new Marker('X'));
                    p2 = new Player("Player 2", new Marker('O'));
                    canPlay = true;
                    break;
                case 2:
                    System.out.println("Choose your marker (X or O)");
                    char marker = Input.getCharChoice(sc);

                    if(marker == 'X') {
                        p1 = new Player("Player 1", new Marker('X'));
                        p2 = new Player(new Marker('O'));
                    }
                    else if(marker == 'O') {
                        p1 = new Player(new Marker('X'));
                        p2 = new Player("Player 2", new Marker('O'));
                    }

                    canPlay = true;
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    isRunning = false;
                    break;
            }

            if(canPlay) {
                TicTacToe game = new TicTacToe(p1, p2);
                game.playGame(sc);// not yet finished
            }
        }

        sc.close();
    }

    public static void displayMenu() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Choose an option:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs AI");
        System.out.println("3. Exit the Game");
    }
}
