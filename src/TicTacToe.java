import javax.swing.*;
import org.w3c.dom.events.EventListener;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    JPanel MainMenu = new JPanel();
    private GameScreen gameScreen;
    JButton buttonPvp= new JButton("Player v.s. Player");
    JButton buttonPvNPC=new JButton("Pleyer v.s. AI");
    JButton buttonBackground=new JButton(new ImageIcon("C:/Users/CCCC/Desktop/JAVA/TicTacToe/src/ButtonBackground.png"));
    JButton buttonExit=new JButton("Exit");
    JLabel TitleGame=new JLabel("<HTML><U>Tic Tac Toe</U></HTML>");
    JLabel background=new JLabel(new ImageIcon("C:/Users/CCCC/Desktop/JAVA/TicTacToe/src/startMatchBackground.png"));
    JLabel VS=new JLabel("V.S.");
    JTextField Player1=new JTextField(10);
    JTextField Player2=new JTextField(10);
    JLabel error=new JLabel("Numele jucatorilor!");
    JButton startButton=new JButton("Start");
    ButtonsHandler handler=new ButtonsHandler();
    private boolean player1Input=false;
    private boolean menuListenersInstalled=false;
    private Color oranje=new Color(238,82,82);
    private Color bluey=new Color(42,180,239);
    private String backgroundColor="oranje";
    private String player1;
    private String player2;

/*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    public static void main(String[] args) {
        JFrame window = new TicTacToe();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        

    }
    public TicTacToe() {
        super("Tic Tac Toe");

        setSize(500, 500);
        setLocation(0, 0);
        setContentPane(MainMenu);

        MainMenu();
    }

    /*------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    public class ButtonsHandler extends JButton implements EventListener{
        public void actionPerformed(ActionEvent evt){
            String cmd=evt.getActionCommand();
            System.out.println(cmd);
        }
        public void handleEvent(org.w3c.dom.events.Event evt) { }
    }
    public void Finish(char winnerSymbol) {
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

    public void MainMenu(){
        MainMenu.removeAll();
        repaint();

        MainMenu.setLayout(null);
        buttonPvp.setBackground(Color.LIGHT_GRAY);
        buttonPvp.setFont(new Font("Serif",Font.BOLD,34));
        buttonPvp.setActionCommand("Pvp");
        buttonPvp.setBorder(BorderFactory.createBevelBorder(0));
        
        
        
        buttonBackground.setBorderPainted(false);
        buttonBackground.setContentAreaFilled(false);
        buttonBackground.setActionCommand("Background");
        
        

       
        buttonExit.setBackground(Color.LIGHT_GRAY);
        buttonExit.setFont(new Font("Serif",Font.BOLD,34));
        buttonExit.setActionCommand("Exit");

        TitleGame.setFont(new Font("SansSerif",Font.BOLD,42));
        
        
        
        
        startButton.setFont(new Font("SansSerif",Font.BOLD,22));
        startButton.setBackground(bluey);
        if (!menuListenersInstalled) {
        Player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
               String pl1=Player1.getText().toString();
               player1=pl1;
               System.out.println(player1);
            }
        });
        Player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
               String pl2=Player2.getText().toString();
               player2=pl2;
               System.out.println(player2);
            }
        });
        
        }
        Player1.setFont(new Font("SansSerif",Font.BOLD,42));
        Player1.setBackground(bluey);
        Player2.setFont(new Font("SansSerif",Font.BOLD,42));
        Player2.setBackground(oranje);

       VS.setFont(new Font("Serif",Font.BOLD,32));
       MainMenu.setBackground(oranje);
       MainMenu.add(buttonPvp);

       MainMenu.add(buttonExit);
       MainMenu.add(TitleGame);
       MainMenu.add(buttonBackground);


        MainMenu.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent evt) {
                buttonPvp.setBounds(getWidth()/2-160,getHeight()/2-30,320,60);
                buttonPvNPC.setBounds(getWidth()/2-160,getHeight()/2+50,320,60);
                buttonExit.setBounds(getWidth()/2-160,getHeight()/2+130,320,60);
                TitleGame.setBounds(getWidth()/2-125,30,400,100);
                buttonBackground.setBounds(10,getHeight()-65,20,20);
            }
            public void componentMoved(ComponentEvent evt){ }
            public void componentShown(ComponentEvent e) { }
            public void componentHidden(ComponentEvent evt){ }
            
        });
        if (!menuListenersInstalled) {
         buttonPvNPC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String cmd=evt.getActionCommand();
                System.out.println(cmd);
            }
        });
        buttonBackground.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String cmd=evt.getActionCommand();
                if("Background".equals(cmd)){
                    if("oranje".equals(backgroundColor)){
                    MainMenu.setBackground(bluey);
                    backgroundColor="bluey";
                    }else{
                    MainMenu.setBackground(oranje);
                    backgroundColor="oranje";
                    }
                }
            }
        });
         
        
        

        buttonPvp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                buttonPvp.setBorder(BorderFactory.createBevelBorder(1));
                player1Input=true;
                MainMenu.removeAll();


                MainMenu.add(VS);
                MainMenu.add(error);
                MainMenu.add(Player1);
                MainMenu.add(Player2);
                MainMenu.add(startButton);
                MainMenu.add(background);
                
                error.setVisible(false);

                background.setBounds(0,0,getWidth(),getHeight());
                Player1.setBounds(getWidth()/4-50,getHeight()/4-50,240,100);
                Player2.setBounds(getWidth()/2-40,getHeight()/2+80,240,100);
                VS.setBounds(getWidth()/2-35,getHeight()/2-35,80,80);
                startButton.setBounds(getWidth()/2-45,10,90,50);
                error.setBounds(0,0,150,15);

                MainMenu.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent evt) {
                background.setBounds(0,0,getWidth(),getHeight());
                Player1.setBounds(getWidth()/4-50,getHeight()/4-50,240,100);
                Player2.setBounds(getWidth()/2-40,getHeight()/2+80,240,100);
                startButton.setBounds(getWidth()/2-45,10,90,50);
                VS.setBounds(getWidth()/2-35,getHeight()/2-35,80,80);
                error.setBounds(0,0,150,15);
                }
                public void componentMoved(ComponentEvent evt){ }

                    public void componentShown(ComponentEvent e) { }

                    public void componentHidden(ComponentEvent evt){ }
            public void componentShow(ComponentEvent evt){ }
        });
        repaint();
        
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String cmd=evt.getActionCommand();
                if("Exit".equals(cmd)){
                    System.exit(0);
                }
            }
        });
       startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt){
            player1 = Player1.getText().trim();
            player2 = Player2.getText().trim();
            if (!player1.isEmpty() && !player2.isEmpty()) {
          MainMenu.removeAll();
          StartPvP();
          repaint();
          MainMenu.repaint();
          
          
          
            
            }else{
                
                
                error.setVisible(true);
                
            }
        }
       });
        }
        menuListenersInstalled = true;
        JPanel PvP=new JPanel();

    }

    public void StartPvP() {
        MainMenu.removeAll();
        MainMenu.setLayout(new BorderLayout());

        gameScreen = new GameScreen(player1, player2, winner -> Finish(winner));
        MainMenu.add(gameScreen, BorderLayout.CENTER);

        MainMenu.revalidate();
        MainMenu.repaint();
    }
}
