import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
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

    public static char getCharInput(Scanner sc) {
        char c;

        do {
            c = Character.toUpperCase(sc.nextLine().charAt(0));

            if(!(c == 'X' || c == 'O'))
                System.out.println("Invalid input! Please enter X or O only.");
        } while(!(c == 'X' || c == 'O'));

        return c;
    }
}
