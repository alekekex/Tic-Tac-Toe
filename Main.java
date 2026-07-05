import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("Welcome to Tic Tac Toe!");
            System.out.println("Choose an option:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs AI");
            System.out.println("3. Exit the Game");
            boolean isValid = false;

            do {
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();

                    if(!(choice >= 1 && choice <= 3))
                        System.out.println("Invalid option! Please try again.");
                    else isValid = true;
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input! Please try again.");
                    sc.nextLine();
                }
            } while(!isValid);

            //play the game
        }

        sc.close();
    }
}
