/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import currency.CurrencyExchange;
import java.io.IOException;
import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Tellers;
import security.VerifyUser;
/**
 *
 * @author root
 */
public class Teller extends User{
 
    protected Client client;

    public Teller() {
    }

    public Teller( String name, String username, String password) {
        super(name, username, password);
        id = "T"+(Tellers.size()+1);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
    
    public boolean VerifyClient(){
        
        // TO BE DECLARED 
        
        return false;
    }
    
    public boolean SaveDate(){
        
        // TO BE DECLARED 
        
        return false;
    }
    
    public boolean LoadData(){
        
        // TO BE DECLARED 
        
        return false;
    }
    
    public void doDeposit(double amount){
        
        
        // TO BE DECLARED 
        
        client.setBalance(client.getBalance()+amount);
        
    }
    
     public boolean doWithdraw(double amount){
        
        // TO BE DECLARED 
        if(amount <= client.getBalance()){
        client.setBalance(client.getBalance()-amount);
        return true;
        }
        else{
            return false;
        }
        
    }
     
      public boolean doTransfer(double amount, String clientID){
        
        // TO BE DECLARED 
        
        if(amount <= client.getBalance() && VerifyUser.checkClient(clientID)){
        client.setBalance(client.getBalance()-amount);
        
        for(Client c:Clients){
            if(c.getId().equals(clientID)){
                c.setBalance(c.getBalance()+amount);
            }
        }
        
        return true;
        }
        else{
            return false;
        }

    }
      
      public double ChangeCurrencyToUSD(double amount, String from) throws IOException{
        // TO BE DECLARED 
        
        return CurrencyExchange.performFrom(amount, from);
        
      }
      
      public double ChangeCurrencyFromUSD(double amount, String to) throws IOException{
        // TO BE DECLARED 
        
        return CurrencyExchange.performTo(amount, to);
        
      }
}
