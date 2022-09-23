import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import static java.awt.Color.black;
import static java.awt.Color.blue;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, statsPnl, displayPnl, btnPnl;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;
    JTextArea resaultTA;
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


      cwLbl = new JLabel("# Computer Wins: " );
      cwTF = new JTextField(8);

      pwLbl = new JLabel("# Player Wins: ");
      pwTF = new JTextField(8);

      tLbl = new JLabel("# of Ties: ");
      tTF = new JTextField(8);


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

        resaultTA =  new JTextArea(12, 70);
        scroller = new JScrollPane(resaultTA);

        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }


    private void createButtonPanel() //ROCK, QUIT, ..., ...
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
                        resaultTA.append("Rock ties Rock (Tie)" + "\n");
                            System.out.println("tie: " + tie);

                    }
                    if(newDex == 1){
                        cWin++;
                        resaultTA.append("Paper covers Rock (Computer Wins)" + cWin + "\n");
                        //cwTF.append(cWin);
                            System.out.println("c wins: " + cWin);

                    }
                    if(newDex == 2){
                        pWin++;
                        resaultTA.append("Rock breaks Scissors (Player Wins)" + "\n");
                            System.out.println("p wins: " + pWin);
                    }
                }
        );

        //Paper

        //Scissors


        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));//QUIT DONE


        mainPnl.add(BorderLayout.SOUTH, btnPnl);
    }
}
