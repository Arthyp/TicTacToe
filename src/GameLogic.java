import java.util.Arrays;

public class GameLogic {

    private static final int SIZE = 3;

    private static final int[][] WIN_PATTERNS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    private final char[][] board = new char[SIZE][SIZE];

    private char currentPlayer = 'x';
    private boolean finished = false;
    private int[] winningCells;

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        char[][] copy = new char[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            copy[row] = board[row].clone();
        }

        return copy;
    }

    public int[] getWinningCells() {
        return winningCells == null
                ? null
                : winningCells.clone();
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean makeMove(int row, int col) {
        if (finished || !isValidMove(row, col)) {
            return false;
        }

        board[row][col] = currentPlayer;

        winningCells = findWinningLine();

        if (winningCells != null || isBoardFull()) {
            finished = true;
        } else {
            currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
        }

        return true;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0
                && row < SIZE
                && col >= 0
                && col < SIZE
                && board[row][col] == '\0';
    }

    public char checkWinner() {
        if (winningCells == null) {
            return '\0';
        }

        int first = winningCells[0];

        return board[first / SIZE][first % SIZE];
    }

    public boolean isDraw() {
        return finished && winningCells == null;
    }
    
    private int[] findWinningLine() {
        for (int[] pattern : WIN_PATTERNS) {
            char first = board[pattern[0] / SIZE]
                              [pattern[0] % SIZE];

            if (first != '\0'
                    && first == board[pattern[1] / SIZE]
                                      [pattern[1] % SIZE]
                    && first == board[pattern[2] / SIZE]
                                      [pattern[2] % SIZE]) {

                return pattern.clone();
            }
        }

        return null;
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '\0') {
                    return false;
                }
            }
        }

        return true;
    }

    public void resetGame() {
        for (char[] row : board) {
            Arrays.fill(row, '\0');
        }

        currentPlayer = 'x';
        finished = false;
        winningCells = null;
    }
}
