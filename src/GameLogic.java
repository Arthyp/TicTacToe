import java.util.Arrays;

public class GameLogic {

    private static final int SIZE = 3;

    private static final int[][] WIN_PATTERNS = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    private final char[][] board = new char[SIZE][SIZE];

    private char currentPlayer = 'x';
    private boolean finished = false;
    private int[] winningCells = null;

    // Returns the player whose turn it is
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Returns a copy of the board
    public char[][] getBoard() {
        char[][] copy = new char[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            copy[row] = board[row].clone();
        }

        return copy;
    }

    // Returns the positions of the winning line
    public int[] getWinningCells() {
        return winningCells == null
                ? null
                : winningCells.clone();
    }

    // Checks whether the game has ended
    public boolean isFinished() {
        return finished;
    }

    // Attempts to place a mark on the board
    public boolean makeMove(int row, int col) {
        if (finished || !isValidMove(row, col)) {
            return false;
        }

        board[row][col] = currentPlayer;

        winningCells = findWinningLine();

        if (winningCells != null || isBoardFull()) {
            finished = true;
        } else {
            switchPlayer();
        }

        return true;
    }

    // Checks whether the selected position is available
    private boolean isValidMove(int row, int col) {
        return row >= 0
                && row < SIZE
                && col >= 0
                && col < SIZE
                && board[row][col] == '\0';
    }

    // Changes the current player
    private void switchPlayer() {
        currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
    }

    // Returns the winner, or '\0' if there is none
    public char checkWinner() {
        if (winningCells == null) {
            return '\0';
        }

        int first = winningCells[0];

        return board[first / SIZE][first % SIZE];
    }

    // Checks whether the game ended in a draw
    public boolean isDraw() {
        return finished && winningCells == null;
    }

    // Returns the result of the game
    // 'x' = X wins
    // 'o' = O wins
    // 'd' = draw
    // '\0' = game still running
    public char getResult() {
        if (!finished) {
            return '\0';
        }

        if (isDraw()) {
            return 'd';
        }

        return checkWinner();
    }

    // Finds the winning combination
    private int[] findWinningLine() {
        for (int[] pattern : WIN_PATTERNS) {

            char first = board[pattern[0] / SIZE]
                              [pattern[0] % SIZE];

            char second = board[pattern[1] / SIZE]
                               [pattern[1] % SIZE];

            char third = board[pattern[2] / SIZE]
                              [pattern[2] % SIZE];

            if (first != '\0'
                    && first == second
                    && first == third) {

                return pattern.clone();
            }
        }

        return null;
    }

    // Checks whether every position is occupied
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

    // Resets the game to its initial state
    public void resetGame() {
        for (char[] row : board) {
            Arrays.fill(row, '\0');
        }

        currentPlayer = 'x';
        finished = false;
        winningCells = null;
    }
}
