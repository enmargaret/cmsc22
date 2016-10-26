/**
 * Created by enmargaret on 25/10/2016.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class Janken extends Frame {
    private Label lblChoice, lblPlayer, lblAI;
    private CheckboxGroup cbg = new CheckboxGroup();
    private Checkbox rock = new Checkbox("Rock",cbg,true);
    private Checkbox paper = new Checkbox("Paper",cbg,false);
    private Checkbox scissors = new Checkbox("Scissors",cbg,false);
    private Checkbox lizard = new Checkbox("Lizard",cbg,false);
    private Checkbox spock = new Checkbox("Spock",cbg,false);
    private TextArea text;
    private TextField textPlayer, textAI;
    private Button play;
    private Dialog display;
    private int playerScore = 0, aiScore = 0, aiChoice = 0, playerChoice = 1, winner = 0;
    private Random rand = new Random();
    /*
    rock = 1;
    paper = 2;
    scissors = 3;
    lizard = 4;
    spock = 5;
     */

    public String moveText(int player){
        String str = "";

        if(player == 1){
            str += "ROCK\n";
        }
        else if(player == 2){
            str += "PAPER\n";
        }
        else if(player == 3){
            str += "SCISSORS\n";
        }
        else if(player == 4){
            str += "LIZARD\n";
        }
        else if(player == 5){
            str += "SPOCK\n";
        }
        return str;
    }

    public String winnerIs(int winner){
        String win = "";

        if(winner == 1){
            win = "\nYOU WON THIS ROUND\n";
        }
        else if(winner == -1){
            win = "\nCOMPUTER WON THIS ROUND\n";
        }
        else if(winner == 0){
            win = "\nDRAW\n";
        }
        return win;
    }

    public int checkWinner(int player, int ai){
        if(player==1){
            if(ai == 3 || ai == 4){
                playerScore++;
                winner = 1;
            }
            else if(ai == 1){
                winner = 0;
            }
            else{
                aiScore++;
                winner = -1;
            }
        }
        else if(player == 2){
            if(ai == 1 || ai == 5){
                playerScore++;
                winner = 1;
            }
            else if(ai == 2){
                winner = 0;
            }
            else{
                aiScore++;
                winner = -1;
            }
        }
        else if(player == 3){
            if(ai == 2 || ai == 4){
                playerScore++;
                winner = 1;
            }
            else if(ai == 3){
                winner = 0;
            }
            else{
                aiScore++;
                winner = -1;
            }
        }
        else if(player == 4){
            if(ai == 2 || ai == 5){
                playerScore++;
                winner = 1;
            }
            else if(ai == 4){
                winner = 0;
            }
            else{
                aiScore++;
                winner = -1;
            }
        }
        else if(player == 5){
            if(ai == 1 || ai == 3){
                playerScore++;
                winner = 1;
            }
            else if(ai == 5){
                winner = 0;
            }
            else{
                aiScore++;
                winner = -1;
            }
        }
        return winner;
    }

    public Janken() {
        Frame frame = new Frame();
        frame.setLayout(new FlowLayout());
        lblChoice = new Label("Your Choice:");
        frame.add(lblChoice);
        frame.add(rock);
        frame.add(paper);
        frame.add(scissors);
        frame.add(lizard);
        frame.add(spock);

        text = new TextArea("Results:\n", 10, 20, 1);
        text.setEditable(false);
        play = new Button("RockPaperScissorsLizardSpock!");
        play.setSize(10, 5);
        lblPlayer = new Label("Player's Score: ");
        textPlayer = new TextField(Integer.toString(playerScore), 5);
        textPlayer.setEditable(false);
        lblAI = new Label("Computer's Score: ");
        textAI = new TextField(Integer.toString(aiScore), 5);
        textAI.setEditable(false);

        frame.add(text);
        frame.add(play);
        frame.add(lblPlayer);
        frame.add(textPlayer);
        frame.add(lblAI);
        frame.add(textAI);

        rock.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                playerChoice = 1;
            }
        });
        paper.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                playerChoice = 2;
            }
        });

        scissors.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                playerChoice = 3;
            }
        });

        lizard.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                playerChoice = 4;
            }
        });

        spock.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                playerChoice = 5;
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aiChoice = rand.nextInt(5) + 1;
                Label lblWin = new Label();
                if (playerScore != 5 && aiScore != 5) {
                    text.setText("Results:\nPlayer chose " + moveText(playerChoice) + "\nComputer chose " + moveText(aiChoice) + winnerIs(checkWinner(playerChoice,aiChoice)));
                    textPlayer.setText(Integer.toString(playerScore));
                    textAI.setText(Integer.toString(aiScore));
                    if(playerScore == 5 || aiScore == 5) {
                        if (playerScore == 5) {
                            text.append("\nYOU WIN THE GAME");
                            lblWin.setText("YOU WIN!");
                        } else if (aiScore == 5) {
                            text.append("\nCOMPUTER WINS THE GAME");
                            lblWin.setText("COMPUTER WINS!");
                        }
                        display = new Dialog(frame, "Restart?");
                        Button yes = new Button("YES");
                        Button no = new Button("NO");
                        Label lblRes = new Label("Restart the game?");
                        lblRes.setAlignment(Label.CENTER);
                        display.setLayout(new FlowLayout(FlowLayout.CENTER));
                        Panel controlPanel = new Panel();
                        controlPanel.setLayout(new FlowLayout());
                        yes.setSize(10, 5);
                        no.setSize(10, 5);
                        controlPanel.add(yes);
                        controlPanel.add(no);

                        yes.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                playerScore = 0;
                                aiScore = 0;
                                display.setVisible(false);
                                textPlayer.setText(Integer.toString(playerScore));
                                textAI.setText(Integer.toString(aiScore));
                                text.setText("Results:\n");
                            }
                        });

                        no.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });

                        display.add(lblWin);
                        display.add(lblRes);
                        display.add(controlPanel);
                        display.setSize(200,150);
                        display.setVisible(true);
                    }
                }
            }
        });

        frame.setTitle("Rock, Paper, Scissors, Lizard, Spock!");
        frame.setSize(600, 400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public static void main(String [] args){
        new Janken();
    }
}
