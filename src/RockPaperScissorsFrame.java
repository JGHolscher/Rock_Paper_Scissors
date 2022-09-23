import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, statsPnl, displayPnl, btnPnl;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;
    JTextArea resaultTA;
    JLabel tLbl, cwLbl, pwLbl;
    JTextField tTF, cwTF, pwTF;

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


      cwLbl = new JLabel("# Computer Wins: ");
      cwTF = new JTextField();
        System.out.println();

      pwLbl = new JLabel("# Player Wins: ");
      pwTF = new JTextField();

      tLbl = new JLabel("# of Ties: ");
      tTF = new JTextField();



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
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,4));

        rockBtn = new JButton("rock");
        paperBtn = new JButton("paper");
        scissorsBtn = new JButton("scissors");
        quitBtn = new JButton("Quit");

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
                        resaultTA.append("Rock ties Rock (Tie)" + "\n");
                        tie++;
                        //cwTF.add(tie);
                            System.out.println("tie: " + tie);

                    }
                    if(newDex == 1){
                        resaultTA.append("Paper covers Rock (Computer Wins)" + "\n");
                        cWin++;
                            System.out.println("c wins: " + cWin);

                    }
                    if(newDex == 2){
                        resaultTA.append("Rock breaks Scissors (Player Wins)" + "\n");
                        pWin++;
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
