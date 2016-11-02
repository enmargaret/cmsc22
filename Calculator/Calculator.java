package Calculator;

/**
 * Created by enmargaret on 28/10/2016.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private Frame frame = new Frame("Calculator");
    private JTextField txtDisplay = new JTextField("0",20);
    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton point = new JButton(".");
    private JButton clear = new JButton("AC");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton times = new JButton("x");
    private JButton divide = new JButton("/");
    private JButton sign = new JButton("+/-");
    private JButton equals = new JButton("=");
    private JPanel whole = new JPanel();
    private JPanel label = new JPanel();
    private String input = "";
    private int signFlag = 0;
    private double doubleAns = 0.0, in1 = 0.0, in2 = 0.0;
    private int operation = 0;
    private BigInteger intAns, bin1, bin2;
    private BigDecimal decAns, din1, din2;
    boolean yesPoint = false;

    public Calculator(){
        point.setBackground(Color.orange);
        plus.setBackground(Color.orange);
        clear.setBackground(Color.orange);
        minus.setBackground(Color.orange);
        divide.setBackground(Color.orange);
        times.setBackground(Color.orange);
        equals.setBackground(Color.orange);
        sign.setBackground(Color.orange);
        label.setSize(300,150);
        label.setBackground(Color.LIGHT_GRAY);
        whole.setSize(300,250);
        txtDisplay.setSize(250,20);
        txtDisplay.setHorizontalAlignment(JTextField.TRAILING);
        txtDisplay.setEditable(false);
        frame.setLayout(new BorderLayout());
        whole.setLayout(new GridLayout(6, 4));
        label.add(txtDisplay);
        whole.add(clear);
        whole.add(sign);
        whole.add(plus);
        whole.add(one);
        whole.add(two);
        whole.add(minus);
        whole.add(three);
        whole.add(four);
        whole.add(times);
        whole.add(five);
        whole.add(six);
        whole.add(divide);
        whole.add(seven);
        whole.add(eight);
        whole.add(point);
        whole.add(nine);

        whole.add(zero);
        whole.add(equals);
        frame.add(label,BorderLayout.NORTH);
        frame.add(whole,BorderLayout.CENTER);

        frame.setSize(300,400);
        frame.setVisible(true);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
        sign.addActionListener(this);
        point.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        divide.addActionListener(this);
        sign.addActionListener(this);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });


    }

    public static void main (String[] args){
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == one){
            input+="1";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == two){
            input+="2";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == three){
            input+="3";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == four){
            input+="4";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == five){
            input+="5";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == six){
            input+="6";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == seven){
            input+="7";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == eight){
            input+="8";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == nine){
            input+="9";
            txtDisplay.setText(input);
        }
        else if (e.getSource() == zero){
            input+="0";
            txtDisplay.setText(input);
        }

        else if (e.getSource() == clear){
            input="";
            txtDisplay.setText("0");
        }
        else if (e.getSource() == point){
            yesPoint = true;
            input+=".";
            txtDisplay.setText(input);
        }

        else if (e.getSource() == plus){
            if(yesPoint){
                din1 = new BigDecimal(input);
            }
            else{
                bin1 = new BigInteger(input);
            }
            if(input == ""){
                txtDisplay.setText("0");
            }
            else {
                operation = 1;
                input = "";
                txtDisplay.setText("0");
            }

        }
        else if (e.getSource() == minus){
            if(yesPoint){
                din1 = new BigDecimal(input);
            }
            else{
                bin1 = new BigInteger(input);
            }

            if(input == ""){
                input = "-" + input;
                txtDisplay.setText(input);
            }else {
                operation = 2;
                input = "";
                txtDisplay.setText("0");
            }
        }
        else if (e.getSource() == times){
            if(yesPoint){
                din1 = new BigDecimal(input);
            }
            else{
                bin1 = new BigInteger(input);
            }
            operation = 3;
            input = "";
            txtDisplay.setText("0");
        }
        else if (e.getSource() == divide){
            if(yesPoint){
                din1 = new BigDecimal(input);
            }
            else{
                bin1 = new BigInteger(input);
            }
            operation = 4;
            input = "";
            txtDisplay.setText("0");
        }
        else if (e.getSource() == sign){
            if(signFlag == 0){
                signFlag = 1;
                input = "-" + input;
                txtDisplay.setText(input);
            }
            else{
                signFlag = 0;
                input = input.substring(1);
                txtDisplay.setText(input);
            }
        }

        else if (e.getSource() == equals){
            if(operation == 1){
                if(yesPoint){
                    din2 = new BigDecimal(input);
                    decAns = din1.add(din2);
                    String ans = "" + decAns;
                    txtDisplay.setText(ans);
                    yesPoint = false;
                }
                else {
                    bin2 = new BigInteger(input);
                    intAns = bin1.add(bin2);
                    String ans = "" + intAns;
                    txtDisplay.setText(ans);
                }
            }
            else if(operation == 2){
                if(yesPoint){
                    din2 = new BigDecimal(input);
                    decAns = din1.subtract(din2);
                    String ans = "" + decAns;
                    txtDisplay.setText(ans);
                    yesPoint = false;
                }
                else {
                    bin2 = new BigInteger(input);
                    intAns = bin1.subtract(bin2);
                    String ans = "" + intAns;
                    txtDisplay.setText(ans);
                }
            }

            else if(operation == 3){
                if(yesPoint){
                    din2 = new BigDecimal(input);
                    decAns = din1.multiply(din2);
                    String ans = "" + decAns;
                    txtDisplay.setText(ans);
                    yesPoint = false;
                }
                else {
                    bin2 = new BigInteger(input);
                    intAns = bin1.multiply(bin2);
                    String ans = "" + intAns;
                    txtDisplay.setText(ans);
                }
            }
            else if(operation == 4){
                if(yesPoint){
                    din2 = new BigDecimal(input);
                    decAns = din1.subtract(din2);
                    String ans = "" + decAns;
                    txtDisplay.setText(ans);
                    yesPoint = false;
                }
                else {
                    bin2 = new BigInteger(input);
                    intAns = bin1.subtract(bin2);
                    String ans = "" + intAns;
                    txtDisplay.setText(ans);
                }
            }

        }

    }

    private class ActionListener {
    }
}
