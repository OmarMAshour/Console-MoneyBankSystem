/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import static moneybanksystem.MoneyBankSystem.Clients;

/**
 *
 * @author root
 */



public class Client extends User{
    
    private double balance;
    private boolean opened;
    private String[] transactionsNeeded = new String[10];
    private int noOfTransactions;
    private ClientAccount accountType;

    public Client() {
    }

//    public Client(double balance, boolean opened, String name, String username, int id, String password) {
//        super(name, username, id, password);
//        this.balance = balance;
//        this.opened = opened;
//        noOfTransactions = 0;
//    }

    public Client(double balance, boolean opened, ClientAccount accountType, String name, String username, String password) {
        super(name, username, password);
        this.balance = balance;
        this.opened = opened;
//        this.noOfTransactions = noOfTransactions;
        this.accountType = accountType;
        
        id = "C"+(Clients.size()+1);
    }
    
    

    public double getBalance() {
        return balance;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void addTransaction(String s){
        transactionsNeeded[noOfTransactions++] = s;
    }

    public void setAccountType(ClientAccount accountType) {
        this.accountType = accountType;
    }

    public ClientAccount getAccountType() {
        return accountType;
    }
    
    
}
