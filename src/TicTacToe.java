
import javax.swing.*;

import org.w3c.dom.events.EventListener;

import java.awt.event.*;

import java.awt.*;

public class TicTacToe extends JFrame {
    JPanel MainMenu = new JPanel();
    GamePvP gamePanelPvP = new GamePvP();
    JButton buttonPvp= new JButton("Player v.s. Player");
    JButton buttonPvNPC=new JButton("Pleyer v.s. AI");
    JButton buttonBackground=new JButton(new ImageIcon("C:/Users/CCCC/Desktop/JAVA/TicTacToe/src/ButtonBackground.png"));
    JButton buttonExit=new JButton("Exit");
    JLabel TitleGame=new JLabel("<HTML><U>Tic Tac Toe</U></HTML>");
    JLabel choser=new JLabel();
    JLabel background=new JLabel(new ImageIcon("C:/Users/CCCC/Desktop/JAVA/TicTacToe/src/startMatchBackground.png"));
    JLabel VS=new JLabel("V.S.");
    JTextField Player1=new JTextField(10);
    JTextField Player2=new JTextField(10);
    JLabel error=new JLabel("Numele jucatorilor!");
    JButton startButton=new JButton("Start");
    ButtonsHandler handler=new ButtonsHandler();
    private boolean player1Input=false;
    private Color oranje=new Color(238,82,82);
    private Color bluey=new Color(42,180,239);
    private String backgroundColor="oranje";
    private String player1;
    private String player2;

    /*--------------------------------------------------------------------------------------------------------------------------------------- */
    
    /*--------------------------------------------------------------------------------------------------------------------- */
    public class GamePvP extends JPanel implements MouseListener{
    public char token='o';
    public char b1='1';
    public char b2='2';
    public char b3='3';
    public char b4='4';
    public char b5='5';
    public char b6='6';
    public char b7='7';
    public char b8='8';
    public char b9='9';
    public boolean a=false;
    public boolean check1=false;
    public boolean check2=false;
    public boolean check3=false;
    public boolean check4=false;
    public boolean check5=false;
    public boolean check6=false;
    public boolean check7=false;
    public boolean check8=false;
    public boolean blueColor=false;
    
    /*------------------------------------------------------------------------ */
        public void paint(Graphics g) {
            if(token=='o'&&a==false){
             choser.setForeground(bluey);
             choser.setText(player1+" alege pozitia!");
        } else{
            if(a==false){
             choser.setForeground(oranje);
             choser.setText(player2+" alege pozitia!");
            }
        }
        if(a==true){
            Finish();
        }
            super.paint(g);
            g.fillOval(100,200,10,10);
            g.fillRect(105,200,320,10);
            g.fillOval(420,200,10,10);

            g.fillOval(100,310,10,10);
            g.fillRect(105,310,320,10);
            g.fillOval(420,310,10,10);

            g.fillOval(200,100,10,10);
            g.fillRect(200,105,10,320);
            g.fillOval(200,420,10,10);

            g.fillOval(310,100,10,10);
            g.fillRect(310,105,10,320);
            g.fillOval(310,420,10,10);
            /*------------------------------------------------------------------------------------------------------------------------ */
                if(check1==true){
                for(int i=100, j=100;i<=410&&j<=410;i++,j++){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                    g.fillOval(i,j,20,20);
                }
            }
            if(check2==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=410, j=100;i>=100&&j<=410;i--,j++){
                    g.fillOval(i,j,20,20);
                }
            }
                /*-------------------------------------- */
                if(check3==true){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=145, j=100;j<=410;j++){
                    g.fillOval(i,j,20,20);
                }
            }
            if(check4==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=250, j=100;j<=410;j++){
                    
                    g.fillOval(i,j,20,20);
                }
            }
            if(check5==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=360, j=100;j<=410;j++){
                   
                    g.fillOval(i,j,20,20);
                }
            }
                /*------------------------------------- */
                if(check6==true){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                 for(int i=100, j=145;i<=410;i++){
                   
                    g.fillOval(i,j,20,20);
                }
            }
            if(check7==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=100, j=250;i<=410;i++){
                  
                    g.fillOval(i,j,20,20);
                }
            }
            if(check8==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=100, j=360;i<=410;i++){
                  
                    g.fillOval(i,j,20,20);
                }
            }
            /*------------------------------------------------------------------------------------------------------------------------ */
            if(b1=='x'){
                g.setColor(Color.BLUE);
            int i=110,j=110;
            while(i<190){
                g.fillOval(i,i,10,10);
                i++;
            }
            i=190;
            while(i>110&&j<190){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b2=='x'){
                g.setColor(Color.BLUE);
            int i=110,j=220;
            while(i<190&&j<300){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=190;j=220;
            while(i>110&&j<300){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b3=='x'){
                g.setColor(Color.BLUE);
            int i=110,j=330;
            while(i<190&&j<410){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=190;j=330;
            while(i>110&&j<410){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b4=='x'){
                g.setColor(Color.BLUE);
            int i=220,j=110;
            while(i<300&&j<190){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=300;j=110;
            while(i>220&&j<190){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b5=='x'){
                g.setColor(Color.BLUE);
            int i=220,j=220;
            while(i<300){
                g.fillOval(i,i,10,10);
                i++;
            }
            i=300;
            while(i>220&&j<300){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            
            g.setColor(Color.BLACK);
            }
            if(b6=='x'){
                g.setColor(Color.BLUE);
            int i=220,j=330;
            while(i<300&&j<410){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=300;j=330;
            while(i>220&&j<410){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b7=='x'){
                g.setColor(Color.BLUE);
            int i=330,j=110;
            while(i<410&&j<190){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=410;j=110;
            while(i>330&&j<190){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b8=='x'){
                g.setColor(Color.BLUE);
            int i=330,j=220;
            while(i<410&&j<300){
                g.fillOval(i,j,10,10);
                i++;
                j++;
            }
            i=410;j=220;
            while(i>330&&j<300){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            if(b9=='x'){
                g.setColor(Color.BLUE);
            int i=330,j=330;
            while(i<410){
                g.fillOval(i,i,10,10);
                i++;
            }
            i=410;
            while(i>330&&j<410){
                g.fillOval(i,j,10,10);
                i--;
                j++;
            }
            g.setColor(Color.BLACK);
            }
            
            /*----------------------------------------------------------------------------------------------------------------------- */
            if(b1=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(100,100,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(110,110,80,80);
                    g.setColor(Color.BLACK);
            }
             if(b2=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(100,210,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(110,220,80,80);
                    g.setColor(Color.BLACK);
            }
            if(b3=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(100,320,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(110,330,80,80);
                    g.setColor(Color.BLACK);
            }
            if(b4=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(210,100,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(220,110,80,80);
                    g.setColor(Color.BLACK);
            }
             if(b5=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(210,210,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(220,220,80,80);
                    g.setColor(Color.BLACK);
            }
            if(b6=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(210,320,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(220,330,80,80);
                    g.setColor(Color.BLACK);
            }
            if(b7=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(320,100,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(330,110,80,80);
                    g.setColor(Color.BLACK);
            }
             if(b8=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(320,210,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(330,220,80,80);
                    g.setColor(Color.BLACK);
            }
            if(b9=='o'){
                    Color oranje=new Color(238,82,82);
                    g.setColor(oranje);
                    g.fillOval(320,320,100,100);
                    g.setColor(Color.WHITE);
                    g.fillOval(330,330,80,80);
                    g.setColor(Color.BLACK);
            }
        
         /*------------------------------------------------------------------------------------------------------------------------ */
                if(check1==true){
                for(int i=100, j=100;i<=410&&j<=410;i++,j++){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                    g.fillOval(i,j,20,20);
                }
            }
            if(check2==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=410, j=100;i>=100&&j<=410;i--,j++){
                    g.fillOval(i,j,20,20);
                }
            }
                /*-------------------------------------- */
                if(check3==true){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=145, j=100;j<=410;j++){
                    g.fillOval(i,j,20,20);
                }
            }
            if(check4==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=250, j=100;j<=410;j++){
                    
                    g.fillOval(i,j,20,20);
                }
            }
            if(check5==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=360, j=100;j<=410;j++){
                   
                    g.fillOval(i,j,20,20);
                }
            }
                /*------------------------------------- */
                if(check6==true){
                    if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                 for(int i=100, j=145;i<=410;i++){
                   
                    g.fillOval(i,j,20,20);
                }
            }
            if(check7==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=100, j=250;i<=410;i++){
                  
                    g.fillOval(i,j,20,20);
                }
            }
            if(check8==true){
                if(blueColor==true){
                        g.setColor(Color.BLUE);
                    }else{
                        g.setColor(Color.RED);
                    }
                for(int i=100, j=360;i<=410;i++){
                  
                    g.fillOval(i,j,20,20);
                }
            }
        }
        /*----------------------------------------------------------------------------------------------------------------------------- */
        /*----------------------------------------------------------------------------------------------------------------------------- */
    public void mousePressed(MouseEvent evt) { 
        if(evt.getButton()==MouseEvent.BUTTON1){
        int x = evt.getX();
        int y = evt.getY();
        int i,j;
        
        System.out.println(x+" "+y);
        for(i=100;i<=200;i++)
            for(j=100;j<=200;j++)
            if(x==i&&y==j&&b1=='1'&&a==false) {
                 
                 repaint();
                 
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b1=token;
                 checkWin();
        }
      
        for(i=100;i<=200;i++)
            for(j=210;j<=310;j++)
            if(x==i&&y==j&&b2=='2'&&a==false) {
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b2=token;
                 checkWin();
             }
        
        for(i=100;i<=200;i++)
            for(j=320;j<=420;j++)
            if(x==i&&y==j&&b3=='3'&&a==false) { 
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b3=token;
                 checkWin();
            }

        for(i=210;i<=310;i++)
            for(j=100;j<=200;j++)
            if(x==i&&y==j&&b4=='4'&&a==false) {
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b4=token;
                 checkWin();
             }
      
        for(i=210;i<=310;i++)
            for(j=210;j<=310;j++)
            if(x==i&&y==j&&b5=='5'&&a==false) {
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b5=token;
                 checkWin();
             }
        
        for(i=210;i<=310;i++)
            for(j=320;j<=420;j++)
            if(x==i&&y==j&&b6=='6'&&a==false) {
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b6=token;
                 checkWin();
             }

        for(i=320;i<=420;i++)
            for(j=100;j<=200;j++)
            if(x==i&&y==j&&b7=='7'&&a==false) { 
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b7=token;
                 checkWin();
            }
      
        for(i=320;i<=420;i++)
            for(j=210;j<=310;j++)
            if(x==i&&y==j&&b8=='8'&&a==false) { 
                 
                 repaint();
                 
                 if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b8=token;
                 checkWin();
            }
        
        for(i=320;i<=420;i++)
            for(j=320;j<=420;j++)
                if(x==i&&y==j&&b9=='9'&&a==false) {
                     
                     repaint();
                     
                     if(token=='x'){
                    token='o';
                 } else{
                    token='x';
                 }
                 b9=token;
                 checkWin();
                 }
    }
}
public void mouseReleased(MouseEvent evt) { }
public void mouseClicked(MouseEvent evt) { }
public void mouseEntered(MouseEvent evt) { }
public void mouseExited(MouseEvent evt) { } 
/*----------------------------------------------------------------------------------------------------------- */
    public void checkWin(){
        if(b1==b2&&b2==b3){
            check3=true;
            a=true;
            if(b1=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b4==b5&&b4==b6){
            check4=true;
            a=true;
            if(b4=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b7==b8&&b7==b9){
            check5=true;
            a=true;
            if(b7=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b1==b4&&b1==b7){
            check6=true;
            a=true;
            if(b1=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b2==b5&&b2==b8){
            check7=true;
            a=true;
            if(b2=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b3==b6&&b3==b9){
            check8=true;
            a=true;
            if(b3=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b1==b5&&b1==b9){
            check1=true;
            a=true;
            if(b1=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
        if(b7==b5&&b7==b3){
            check2=true;
            a=true;
            if(b1=='x'){
                blueColor=true;
            } else{
                blueColor=false;
            }
            repaint();
        }
    }
}
/*=================================================================================================================================================== */


/*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    public static void main(String[] args) {
        JFrame window = new TicTacToe();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        

    }
    public TicTacToe(){
        super("Tic Tac Toe");
        setSize(500,500);
        setLocation(0,0);
        
        
        Dimension buttonSize=new Dimension(320, 60);
        setContentPane(MainMenu);

        MainMenu();



    }
    
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    /*------------------------------------------------------------------------------------------------------------------------------------ */
    public class ButtonsHandler extends JButton implements EventListener{
        public void actionPerformed(ActionEvent evt){
            String cmd=evt.getActionCommand();
            System.out.println(cmd);
        }
        public void handleEvent(org.w3c.dom.events.Event evt) { }
    }
    public void Finish(){
        JPanel buttonsPanel=new JPanel(new GridLayout(1,2,100,0));
        MainMenu.removeAll();
        MainMenu.setLayout(new BorderLayout());
        if(gamePanelPvP.token=='x'){
            MainMenu.setBackground(bluey);
            buttonsPanel.setBackground(bluey);
            JLabel winner=new JLabel(player1+" a castigat!");
            MainMenu.add(winner,BorderLayout.CENTER);
            winner.setFont(new Font("Serif",Font.BOLD,32));
            winner.setHorizontalAlignment(JLabel.CENTER);
        
        }else{
            MainMenu.setBackground(oranje);
            buttonsPanel.setBackground(oranje);
            JLabel winner=new JLabel(player2+" a castigat!");
            MainMenu.add(winner,BorderLayout.CENTER);
            winner.setFont(new Font("Serif",Font.BOLD,32));
            winner.setHorizontalAlignment(JLabel.CENTER);
            
        }
        
        JButton playAgain=new JButton("Play again");
        playAgain.setActionCommand("PlayAgain");
        playAgain.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                MainMenu.removeAll();
                StartPvP();
                gamePanelPvP.token='o';
                gamePanelPvP.b1='1';
                gamePanelPvP.b2='2';
                gamePanelPvP.b3='3';
                gamePanelPvP.b4='4';
                gamePanelPvP.b5='5';
                gamePanelPvP.b6='6';
                gamePanelPvP.b7='7';
                gamePanelPvP.b8='8';
                gamePanelPvP.b9='9';
                gamePanelPvP.a=false;
                gamePanelPvP.check1=false;
                gamePanelPvP.check2=false;
                gamePanelPvP.check3=false;
                gamePanelPvP.check4=false;
                gamePanelPvP.check5=false;
                gamePanelPvP.check6=false;
                gamePanelPvP.check7=false;
                gamePanelPvP.check8=false;
                gamePanelPvP.blueColor=false;
                repaint();
            }
        });
        buttonsPanel.add(playAgain);
        JButton mainmenu=new JButton("Extit to MainMenu");
        mainmenu.setActionCommand("ExitMainMenu");
        mainmenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                MainMenu();
                gamePanelPvP.token='o';
                gamePanelPvP.b1='1';
                gamePanelPvP.b2='2';
                gamePanelPvP.b3='3';
                gamePanelPvP.b4='4';
                gamePanelPvP.b5='5';
                gamePanelPvP.b6='6';
                gamePanelPvP.b7='7';
                gamePanelPvP.b8='8';
                gamePanelPvP.b9='9';
                gamePanelPvP.a=false;
                gamePanelPvP.check1=false;
                gamePanelPvP.check2=false;
                gamePanelPvP.check3=false;
                gamePanelPvP.check4=false;
                gamePanelPvP.check5=false;
                gamePanelPvP.check6=false;
                gamePanelPvP.check7=false;
                gamePanelPvP.check8=false;
                gamePanelPvP.blueColor=false;
                player1=null;
                player2=null;
                Player1.setText("");
                Player2.setText("");
            }
        } );
        buttonsPanel.add(mainmenu);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));
        MainMenu.add(buttonsPanel,BorderLayout.SOUTH);
        repaint();
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
         buttonPvNPC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String cmd=evt.getActionCommand();
                System.out.println(cmd);
            }
        });
        buttonBackground.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                String cmd=evt.getActionCommand();
                if(cmd=="Background"){
                    if(backgroundColor=="oranje"){
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
                if(cmd=="Exit"){
                    System.exit(0);
                }
            }
        });
       startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt){
            if(player1!=null&&player2!=null){
          MainMenu.removeAll();
          StartPvP();
          repaint();
          gamePanelPvP.repaint();
          
          
          
            
            }else{
                
                
                error.setVisible(true);
                
            }
        }
       });
        JPanel PvP=new JPanel();

    }
    public void StartPvP(){
        MainMenu.setLayout(new BorderLayout());
          choser.setFont(new Font("Serif",Font.BOLD,25));
          choser.setHorizontalAlignment(JLabel.CENTER);
          MainMenu.add(choser,BorderLayout.NORTH);
          MainMenu.add(gamePanelPvP,BorderLayout.CENTER);
          MainMenu.addMouseListener(gamePanelPvP);
          MainMenu.setBackground(Color.WHITE);
    }
}