import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements GameBoard.Listener {

    public interface Listener {
        void onGameOver(char winner);
    }

    private final JLabel turnLabel;
    private final GameBoard gameBoard;
    private final Listener listener;

    private final String player1;
    private final String player2;

    private final Color xColor = new Color(42, 180, 239);
    private final Color oColor = new Color(238, 82, 82);

    public GameScreen(
            String player1,
            String player2,
            Listener listener) {

        this.player1 = player1;
        this.player2 = player2;
        this.listener = listener;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        turnLabel = new JLabel();
        turnLabel.setFont(new Font("Serif", Font.BOLD, 25));
        turnLabel.setHorizontalAlignment(JLabel.CENTER);

        gameBoard = new GameBoard(this);

        add(turnLabel, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);

        updateTurnLabel(gameBoard.getCurrentPlayer());
    }

    @Override
    public void onTurnChanged(char player) {
        updateTurnLabel(player);
    }

    @Override
    public void onGameOver(char winner) {
        listener.onGameOver(winner);
    }

    private void updateTurnLabel(char player) {
        if (player == 'x') {
            turnLabel.setForeground(xColor);
            turnLabel.setText(player1 + " escolhe a posição!");
        } else {
            turnLabel.setForeground(oColor);
            turnLabel.setText(player2 + " escolhe a posição!");
        }
    }

    public void resetGame() {
        gameBoard.resetGame();
    }
}
