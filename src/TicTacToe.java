import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

public class TicTacToe extends JFrame {

    private enum Screen { MENU, PLAYER_SELECTION, GAME, RESULT }

    private final JPanel MainMenu = new JPanel();
    private GameScreen gameScreen;
    private Screen currentScreen = Screen.MENU;

    private final JButton buttonPvp = new JButton("Player v.s. Player");
    private final JButton buttonPvNPC = new JButton("Player v.s. AI");
    private final JButton buttonBackground = new JButton(loadImage("ButtonBackground.png"));
    private final JButton buttonExit = new JButton("Exit");
    private final JLabel TitleGame = new JLabel("<HTML><U>Tic Tac Toe</U></HTML>");
    private final JLabel background = new JLabel(loadImage("startMatchBackground.png"));
    private final JLabel VS = new JLabel("V.S.");
    private final JTextField Player1 = new JTextField(10);
    private final JTextField Player2 = new JTextField(10);
    private final JLabel error = new JLabel("Numele jucatorilor!");
    private final JButton startButton = new JButton("Start");

    private final Color oranje = new Color(238, 82, 82);
    private final Color bluey = new Color(42, 180, 239);
    private boolean orangeBackground = true;
    private String player1;
    private String player2;

    private static ImageIcon loadImage(String filename) {
        URL resource = TicTacToe.class.getResource("/" + filename);
        return resource == null ? new ImageIcon(filename) : new ImageIcon(resource);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe().setVisible(true));
    }

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(500, 500);
        setMinimumSize(new Dimension(450, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainMenu);

        // Apenas UM listener, registrado uma única vez.
        MainMenu.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                if (currentScreen == Screen.MENU) {
                    updateMenuBounds();
                } else if (currentScreen == Screen.PLAYER_SELECTION) {
                    updatePlayerSelectionBounds();
                }
            }
        });

        configureComponents();
        installButtonListeners();
        MainMenu();
    }

    private void configureComponents() {
        buttonPvp.setBackground(Color.LIGHT_GRAY);
        buttonPvp.setFont(new Font("Serif", Font.BOLD, 34));
        buttonPvp.setBorder(BorderFactory.createBevelBorder(0));
        buttonPvNPC.setBackground(Color.LIGHT_GRAY);
        buttonPvNPC.setFont(new Font("Serif", Font.BOLD, 25));
        buttonExit.setBackground(Color.LIGHT_GRAY);
        buttonExit.setFont(new Font("Serif", Font.BOLD, 34));
        TitleGame.setFont(new Font("SansSerif", Font.BOLD, 42));
        buttonBackground.setBorderPainted(false);
        buttonBackground.setContentAreaFilled(false);
        startButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        startButton.setBackground(bluey);
        Player1.setFont(new Font("SansSerif", Font.BOLD, 42));
        Player1.setBackground(bluey);
        Player2.setFont(new Font("SansSerif", Font.BOLD, 42));
        Player2.setBackground(oranje);
        VS.setFont(new Font("Serif", Font.BOLD, 32));
        background.setHorizontalAlignment(JLabel.CENTER);
    }

    private void installButtonListeners() {
        buttonPvp.addActionListener(evt -> showPlayerSelection());
        buttonPvNPC.addActionListener(evt ->
                JOptionPane.showMessageDialog(this, "Modo contra IA ainda não implementado."));
        buttonExit.addActionListener(evt -> dispose());
        buttonBackground.addActionListener(evt -> {
            orangeBackground = !orangeBackground;
            MainMenu.setBackground(orangeBackground ? oranje : bluey);
            MainMenu.repaint();
        });
        startButton.addActionListener(evt -> {
            player1 = Player1.getText().trim();
            player2 = Player2.getText().trim();
            if (player1.isEmpty() || player2.isEmpty()) {
                error.setVisible(true);
                return;
            }
            StartPvP();
        });
    }

    public void MainMenu() {
        currentScreen = Screen.MENU;
        MainMenu.removeAll();
        MainMenu.setLayout(null);
        MainMenu.setBackground(orangeBackground ? oranje : bluey);
        MainMenu.add(buttonPvp);
        // Modo IA não está implementado; não exibir o botão por enquanto.
        MainMenu.add(buttonExit);
        MainMenu.add(TitleGame);
        MainMenu.add(buttonBackground);
        updateMenuBounds();
        MainMenu.revalidate();
        MainMenu.repaint();
    }

    private void showPlayerSelection() {
        currentScreen = Screen.PLAYER_SELECTION;
        MainMenu.removeAll();
        MainMenu.setLayout(null);
        error.setVisible(false);
        MainMenu.add(VS);
        MainMenu.add(error);
        MainMenu.add(Player1);
        MainMenu.add(Player2);
        MainMenu.add(startButton);
        MainMenu.add(background);
        updatePlayerSelectionBounds();
        MainMenu.revalidate();
        MainMenu.repaint();
    }

    private void updateMenuBounds() {
        int width = MainMenu.getWidth();
        int height = MainMenu.getHeight();
        if (width <= 0 || height <= 0) return;
        buttonPvp.setBounds(width / 2 - 160, height / 2 - 30, 320, 60);
        buttonPvNPC.setBounds(width / 2 - 160, height / 2 + 50, 320, 60);
        buttonExit.setBounds(width / 2 - 160, height / 2 + 130, 320, 60);
        TitleGame.setBounds(width / 2 - 125, 30, 400, 100);
        buttonBackground.setBounds(10, height - 65, 20, 20);
    }

    private void updatePlayerSelectionBounds() {
        int width = MainMenu.getWidth();
        int height = MainMenu.getHeight();
        if (width <= 0 || height <= 0) return;
        background.setBounds(0, 0, width, height);
        Player1.setBounds(width / 4 - 50, height / 4 - 50, 240, 100);
        Player2.setBounds(width / 2 - 40, height / 2 + 80, 240, 100);
        VS.setBounds(width / 2 - 35, height / 2 - 35, 80, 80);
        startButton.setBounds(width / 2 - 45, 10, 90, 50);
        error.setBounds(0, 0, 200, 20);
    }

    public void StartPvP() {
        currentScreen = Screen.GAME;
        MainMenu.removeAll();
        MainMenu.setLayout(new BorderLayout());
        gameScreen = new GameScreen(player1, player2, winner -> Finish(winner));
        MainMenu.add(gameScreen, BorderLayout.CENTER);
        MainMenu.revalidate();
        MainMenu.repaint();
    }

    public void Finish(char winnerSymbol) {
        currentScreen = Screen.RESULT;
        MainMenu.removeAll();
        MainMenu.setLayout(new BorderLayout());
        ResultScreen resultScreen = new ResultScreen(
                winnerSymbol, player1, player2,
                new ResultScreen.Listener() {
                    @Override
                    public void onPlayAgain() {
                        restartGame();
                    }

                    @Override
                    public void onReturnToMenu() {
                        returnToMainMenu();
                    }
                }
        );
        MainMenu.add(resultScreen, BorderLayout.CENTER);
        MainMenu.revalidate();
        MainMenu.repaint();
    }

    private void restartGame() {
        StartPvP();
    }

    private void returnToMainMenu() {
        gameScreen = null;
        player1 = null;
        player2 = null;
        Player1.setText("");
        Player2.setText("");
        MainMenu();
    }
}
