import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import static java.awt.Color.black;


public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, statsPnl, displayPnl, btnPnl;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;
    JTextArea resaultTA, cwTA;
    JLabel tLbl, cwLbl, pwLbl;
    JTextField tTF, cwTF, pwTF;

    ImageIcon rock, paper, scissors, quit;

    int cWin = 0;
    int pWin = 0;
    int tie = 0;

    JScrollPane scroller;

    Random rnd = new Random();


    int curCompDex = -1;
    int newDex = 1;
    String[] compOptions = { "R", "P", "S"};


    public RockPaperScissorsFrame() //DONE
    {
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize((screenWidth /4) * 3 , screenHeight);
        setLocationRelativeTo(null); //centers

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        add(mainPnl);
        createStatsPanel();
        createDisplayPanel();
        createButtonPanel();

        setVisible(true);
    }


    private void createStatsPanel()
    {
      statsPnl  = new JPanel();
      //statsPnl.setLayout(new GridLayout(3,1));

      cwLbl = new JLabel("# Computer Wins:");
      cwTF = new JTextField( " " + cWin + " ",3);
        cwLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        cwTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));


      pwLbl = new JLabel("# Player Wins:");
      pwTF = new JTextField( " " + pWin + " ",3);
        pwLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        pwTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));

      tLbl = new JLabel("# of Ties:");
      tTF = new JTextField( " " + tie + " ",3);
        tLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        tTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));


      statsPnl.add(cwLbl);
        statsPnl.add(cwTF);
      statsPnl.add(pwLbl);
        statsPnl.add(pwTF);
      statsPnl.add(tLbl);
        statsPnl.add(tTF);

      mainPnl.add(statsPnl, BorderLayout.NORTH);
    }



    private void createDisplayPanel()// done
    {
        displayPnl = new JPanel();

        resaultTA =  new JTextArea(12, 30);
        scroller = new JScrollPane(resaultTA);
        resaultTA.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }


    private void createButtonPanel() //ROCK, QUIT, SCISSORS, PAPER
    {
        rock = new ImageIcon(new ImageIcon("src/rockImage.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        paper = new ImageIcon(new ImageIcon("src/paperImage.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        scissors = new ImageIcon(new ImageIcon("src/scissorsImage.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        quit = new ImageIcon(new ImageIcon("src/quitImage.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,4));
        btnPnl.setBorder(new LineBorder(black, 6 ));

        rockBtn = new JButton(rock);
        paperBtn = new JButton(paper);
        scissorsBtn = new JButton(scissors);
        quitBtn = new JButton(quit);

        btnPnl.add(rockBtn);
        btnPnl.add(paperBtn);
        btnPnl.add(scissorsBtn);
        btnPnl.add(quitBtn);

        rockBtn.addActionListener( // ROCK DONE
                (ActionEvent ae) ->
                {
                    do {
                        newDex = rnd.nextInt(compOptions.length);
                    }while(newDex == curCompDex);
                    curCompDex = newDex;
                    //      System.out.println("Your Fortune: " + newDex);
                    if(newDex == 0){
                        tie++;
                        resaultTA.append("Rock ties Rock (Tie)" + "\n" + "\n");

                    }
                    if(newDex == 1){
                        cWin++;
                        resaultTA.append("Paper covers Rock (Computer Wins)" + "\n" + "\n");
                        cwTA.setText("# of Computer Wins" + cWin);
                    }
                    if(newDex == 2){
                        pWin++;
                        resaultTA.append("Rock breaks Scissors (Player Wins)" + "\n" + "\n");
                    }
                    System.out.println("tie: " + tie + "   p wins: " + pWin + "  c wins: " + cWin);
                    pwTF.setText(" " + pWin + " ");
                    cwTF.setText(" " + cWin + " ");
                    tTF.setText(" " + tie + " ");
                }
        );

        //Paper
        paperBtn.addActionListener( // ROCK DONE
                (ActionEvent ae) ->
                {
                    do {
                        newDex = rnd.nextInt(compOptions.length);
                    }while(newDex == curCompDex);
                    curCompDex = newDex;
                    //      System.out.println("Your Fortune: " + newDex);
                    //0-r 1-p 2-s
                    //paper v rock0
                    //paper v paper1
                    //paper v scissors2

                    if(newDex == 1){//paperp v paperc
                        tie++;
                        resaultTA.append("Paper ties paper (Tie)" + "\n" + "\n");
                    }
                    if(newDex == 2){//paperp v scissorsc
                        cWin++;
                        resaultTA.append("Scissors cut paper (Computer Wins)" + "\n" + "\n");
                        //cwTF.append(cWin);
                    }
                    if(newDex == 0){//paperp v rockc
                        pWin++;
                        resaultTA.append("Paper covers Rock (Player Wins)" + "\n" + "\n");
                    }
                    System.out.println("tie: " + tie + "   p wins: " + pWin + "  c wins: " + cWin);
                    pwTF.setText(" " + pWin + " ");
                    cwTF.setText(" " + cWin + " ");
                    tTF.setText(" " + tie + " ");
                }
        );

        //Scissors
        scissorsBtn.addActionListener( // ROCK DONE
                (ActionEvent ae) ->
                {
                    do {
                        newDex = rnd.nextInt(compOptions.length);
                    }while(newDex == curCompDex);
                    curCompDex = newDex;
                    //      System.out.println("Your Fortune: " + newDex);
                    //0-r 1-p 2-s
                    //s v rock0 cw
                    //s v paper1 pw
                    //s v scissors2 tie

                    if(newDex == 2){//s v scissorsc
                        tie++;
                        resaultTA.append("Scissors ties Scissors (Tie)" + "\n" + "\n");
                    }
                    if(newDex == 0){//s v rockc
                        cWin++;
                        resaultTA.append("Rock break Scissors (Computer Wins)" + "\n" + "\n");

                    }
                    if(newDex == 1){//s v paperc
                        pWin++;
                        resaultTA.append("Scissors cut paper (Player Wins)" + "\n" + "\n");
                    }
                    System.out.println("tie: " + tie + "   p wins: " + pWin + "  c wins: " + cWin);
                    pwTF.setText(" " + pWin + " ");
                    cwTF.setText(" " + cWin + " ");
                    tTF.setText(" " + tie + " ");
                }
        );

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));//QUIT DONE

        mainPnl.add(BorderLayout.SOUTH, btnPnl);
    }
}
