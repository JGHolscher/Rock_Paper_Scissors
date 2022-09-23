import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, statsPnl, displayPnl, btnPnl;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;
    JTextArea resaultTA;
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
        //createStatsPanel();
        createDisplayPanel();
        createButtonPanel();

        setVisible(true);
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

        quitBtn = new JButton("Quit");
        rockBtn = new JButton("rock");
        paperBtn = new JButton("paper");
        scissorsBtn = new JButton("scissors");

        btnPnl.add(quitBtn);
        btnPnl.add(rockBtn);
        btnPnl.add(paperBtn);
        btnPnl.add(scissorsBtn);

        rockBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    do {
                        newDex = rnd.nextInt(compOptions.length);
                    }while(newDex == curCompDex);
                    curCompDex = newDex;
                    System.out.println("Your Fortune: " + newDex);

                    if(newDex == 0){
                        resaultTA.append("Rock ties Rock (Tie)" + "\n");
                    }
                    if(newDex == 1){
                        resaultTA.append("Paper covers Rock (Computer Wins)" + "\n");
                    }
                    if(newDex == 2){
                        resaultTA.append("Rock breaks Scissors (Player Wins)" + "\n");
                    }
                }
        );






        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));


        mainPnl.add(BorderLayout.SOUTH, btnPnl);
    }




}
