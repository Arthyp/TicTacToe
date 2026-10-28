import javax.swing.*;
import java.awt.*;

public class ResultScreen extends JPanel {

    public interface Listener {
        void onPlayAgain();
        void onReturnToMenu();
    }

    private final Listener listener;

    public ResultScreen(char winner, String player1, String player2,
                        Listener listener) {
        this.listener = listener;

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);

        JLabel resultLabel;

        if (winner == 'd') {
            resultLabel = new JLabel("It's a draw!");
        } else {
            String winnerName = (winner == 'x') ? player1 : player2;
            resultLabel = new JLabel(winnerName + " wins!");
        }

        resultLabel.setFont(new Font("Serif", Font.BOLD, 32));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.addActionListener(e -> listener.onPlayAgain());

        JButton returnButton = new JButton("Main Menu");
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.addActionListener(e -> listener.onReturnToMenu());

        content.add(resultLabel);
        content.add(Box.createVerticalStrut(25));
        content.add(playAgainButton);
        content.add(Box.createVerticalStrut(10));
        content.add(returnButton);

        add(content);
    }
}
