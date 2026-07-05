import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("Welcome to Tic Tac Toe!");//intro still needs its own method
            System.out.println("Choose an option:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs AI");
            System.out.println("3. Exit the Game");
            int choice = getIntInput(sc, 1, 3);
            boolean canPlay = false;

            switch(choice) {
                case 1:
                    //player vs player setup
                    canPlay = true;
                    break;
                case 2:
                    //player vs ai setup
                    canPlay = true;
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    isRunning = false;
                    break;
            }

            /*if(canPlay)
                play game*/
        }

        sc.close();
    }

    public static int getIntInput(Scanner sc, int min, int max) {
        int n = -1;
        boolean isValid = false;

        do {
            try {
                n = sc.nextInt();
                sc.nextLine();

                if(!(n >= min && n <= max))
                    System.out.println("Invalid option! Please try again.");
                else isValid = true;
            } catch(InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        } while(!isValid);

        return n;
    }
}
