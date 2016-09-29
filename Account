import java.util.*;
import java.lang.*;
import java.io.*;

/*
Solution by: Ena Margarita O. Bojos
*/

public class Account{
    private int accountNumber;
    private double balance = 0.0;

    Account(int accNum,double bal){
        accountNumber = accNum;
        balance = bal;
    }
    Account(int accNum){
        accountNumber = accNum;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double bal){
        balance = bal;
    }

    public void credit(double amount){
        balance+=amount;
    }

    public void debit(double amount){
        if(balance >= amount){
            balance-=amount;
        }
        else{
            System.out.println("Amount withdrawn exceeds the current balance!");
        }
    }
    public String toString(){
        return String.format("A/C no:%d, Balance=$%.2f",accountNumber,balance);
    }
}
