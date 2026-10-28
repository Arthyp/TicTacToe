import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class GameBoard extends JPanel {

    public interface Listener {
        void onTurnChanged(char player);
        void onGameOver(char winner);
    }

    private static final int SIZE = 3;
    private static final int CELL_SIZE = 100;
    private static final int BOARD_SIZE = SIZE * CELL_SIZE;

    private static final Color X_COLOR =
            new Color(42, 180, 239);

    private static final Color O_COLOR =
            new Color(238, 82, 82);

    private static final int[][] WIN_PATTERNS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    private final char[][] board = new char[SIZE][SIZE];
    private final Listener listener;

    private char currentPlayer = 'x';
    private boolean finished = false;
    private int[] winningCells;

    public GameBoard(Listener listener) {
        this.listener = listener;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 400));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                handleClick(event);
            }
        });
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void resetGame() {
        for (char[] row : board) {
            Arrays.fill(row, '\0');
        }

        currentPlayer = 'x';
        finished = false;
        winningCells = null;

        repaint();
        listener.onTurnChanged(currentPlayer);
    }

    private void handleClick(MouseEvent event) {
        if (finished || event.getButton() != MouseEvent.BUTTON1) {
            return;
        }

        int left = (getWidth() - BOARD_SIZE) / 2;
        int top = (getHeight() - BOARD_SIZE) / 2;

        int x = event.getX() - left;
        int y = event.getY() - top;

        if (x < 0 || y < 0 ||
                x >= BOARD_SIZE || y >= BOARD_SIZE) {
            return;
        }

        int col = x / CELL_SIZE;
        int row = y / CELL_SIZE;

        if (board[row][col] != '\0') {
            return;
        }

        board[row][col] = currentPlayer;

        winningCells = findWinningLine();

        if (winningCells != null) {
            finished = true;
            repaint();
            listener.onGameOver(currentPlayer);
            return;
        }

        if (isBoardFull()) {
            finished = true;
            repaint();
            listener.onGameOver('\0');
            return;
        }

        currentPlayer = currentPlayer == 'x' ? 'o' : 'x';

        repaint();
        listener.onTurnChanged(currentPlayer);
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
                return pattern;
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        try {
            int left = (getWidth() - BOARD_SIZE) / 2;
            int top = (getHeight() - BOARD_SIZE) / 2;

            g2.setStroke(new BasicStroke(4));
            g2.setColor(Color.BLACK);

            for (int i = 1; i < SIZE; i++) {
                int offset = i * CELL_SIZE;

                g2.drawLine(left + offset, top,
                        left + offset, top + BOARD_SIZE);

                g2.drawLine(left, top + offset,
                        left + BOARD_SIZE, top + offset);
            }

            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    drawMark(g2, row, col, left, top);
                }
            }

            drawWinningLine(g2, left, top);
        } finally {
            g2.dispose();
        }
    }

    private void drawMark(
            Graphics2D g2, int row, int col,
            int left, int top) {

        char mark = board[row][col];

        if (mark == '\0') {
            return;
        }

        int x = left + col * CELL_SIZE;
        int y = top + row * CELL_SIZE;
        int padding = 20;

        g2.setStroke(new BasicStroke(7));
        g2.setColor(mark == 'x' ? X_COLOR : O_COLOR);

        if (mark == 'x') {
            g2.drawLine(
                    x + padding, y + padding,
                    x + CELL_SIZE - padding,
                    y + CELL_SIZE - padding);

            g2.drawLine(
                    x + CELL_SIZE - padding, y + padding,
                    x + padding, y + CELL_SIZE - padding);
        } else {
            g2.drawOval(
                    x + padding, y + padding,
                    CELL_SIZE - 2 * padding,
                    CELL_SIZE - 2 * padding);
        }
    }

    private void drawWinningLine(
            Graphics2D g2, int left, int top) {

        if (winningCells == null) {
            return;
        }

        int first = winningCells[0];
        int last = winningCells[2];

        int x1 = left + (first % SIZE) * CELL_SIZE
                + CELL_SIZE / 2;
        int y1 = top + (first / SIZE) * CELL_SIZE
                + CELL_SIZE / 2;

        int x2 = left + (last % SIZE) * CELL_SIZE
                + CELL_SIZE / 2;
        int y2 = top + (last / SIZE) * CELL_SIZE
                + CELL_SIZE / 2;

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(x1, y1, x2, y2);
    }
}
