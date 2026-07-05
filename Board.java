public class Board {
    private Marker[][] grid;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public Board() {
        this.grid = new Marker[ROWS][COLUMNS];
    }

    public void initializeBoard() {
        int i, j;

        for(i = 0; i < ROWS; i++) {
            for(j = 0; j < COLUMNS; j++) {
                grid[i][j] = new Marker(' ');
            }
        }
    }

    public void displayBoard() {
        int i, j;
        System.out.println("+---+---+---+");

        for(i = 0; i < ROWS; i++) {
            for(j = 0; j < COLUMNS; j++) {
                System.out.print("| " + grid[i][j].getSymbol() + " ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public boolean placeMarker(Marker m, int r, int c) {
        boolean isPlaced = false;

        if(grid[r - 1][c - 1].getSymbol() == ' ') {
            grid[r - 1][c - 1] = m;
            isPlaced = true;
        }

        return isPlaced;
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        int i, j;

        for(i = 0; i < ROWS; i++) {
            for(j = 0; j < COLUMNS; j++) {
                if(grid[i][j].getSymbol() == ' ')
                    isFull = false;
            }
        }

        return isFull;
    }
}
