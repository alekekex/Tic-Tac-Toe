public class Board {
    private Marker[][] grid;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final int MAX_LINE = 3;
    private static final int MAX_WINCONS = 8;

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

    public boolean isWinner(Marker m) {
        boolean hasWon = false;
        int[] scores = new int[MAX_WINCONS];
        int offset = 2;
        int i;

        for(i = 0; i < MAX_LINE; i++) {
            if(grid[0][i] == m)
                scores[0]++;
            if(grid[1][i] == m)
                scores[1]++;
            if(grid[2][i] == m)
                scores[2]++;
            if(grid[i][0] == m)
                scores[3]++;
            if(grid[i][1] == m)
                scores[4]++;
            if(grid[i][2] == m)
                scores[5]++;
            if(grid[i][i] == m)
                scores[6]++;
            if(grid[i][offset] == m)
                scores[7]++;
            offset--;
        }

        for(i = 0; i < MAX_WINCONS; i++) {
            if(scores[i] == MAX_LINE) {
                hasWon = true;
                i = MAX_WINCONS;
            }
        }

        return hasWon;
    }
}
